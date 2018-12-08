package Leetcode_748_ShortestCompletingWord;

import java.util.HashMap;
import java.util.Map;

/*
	��������б�words���е�һ�����ʰ������գ�licensePlate�������е���ĸ����ô���ǳ�֮Ϊ�����ʡ�
	�������������У���̵ĵ������ǳ�֮Ϊ��������ʡ�	
	������ƥ�������е���ĸʱ�����ִ�Сд�����������е� "P" ��Ȼ����ƥ�䵥���е� "p" ��ĸ��	
	���Ǳ�֤һ������һ����������ʡ����ж�����ʶ�������������ʵ�ƥ������ʱȡ�����б����ǰ��һ����	
	�����п��ܰ��������ͬ���ַ�������˵���������� "PP"������ "pair" �޷�ƥ�䣬���� "supper" ����ƥ�䡣
	
	 
	
	ʾ�� 1��	
		���룺
			licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
		�����
			"steps"
		˵����
			���������Ӧ�ð��� "s"��"p"��"s" �Լ� "t"��
			���� "step" ��ֻ����һ�� "s" ������������������
			ͬʱ��ƥ����������Ǻ��������еĴ�Сд��
	 
	
	ʾ�� 2��	
		���룺
			licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
		�����
			"pest"
		˵����
			���������ʶ����������ʵĶ��壬�������Ƿ������ȳ��ֵĵ��ʡ�
	 
	
	ע��:
	
	���գ�licensePlate���ĳ���������[1, 7]�С�
	���գ�licensePlate������������֡��ո񡢻�����ĸ����д��Сд����
	�����б�words������������ [10, 1000] �С�
	ÿһ������ words[i] ����Сд�����ҳ��������� [1, 15] �С�
 */
public class ShortestCompletingWord {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ShortestCompletingWord scw= new ShortestCompletingWord();
		String licensePlate = "1s3 PSt";
		String[] words = {"step", "steps", "stripe", "stepple"};
		scw.shortestCompletingWord(licensePlate, words);
	}

	// 748. ���������
	public String shortestCompletingWord(String licensePlate, String[] words) {
		Map<Character, Integer> licenseMap = stringToMap(licensePlate);
		int minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			Map<Character, Integer> wordMap = stringToMap(words[i]);
			int index = 0;
			for (Character ch : licenseMap.keySet()) {
				if ((wordMap.containsKey(ch)) && (wordMap.get(ch) == licenseMap.get(ch))) {
					index++;
					continue;
				} else {
					break;
				}
			}
			if(index == licenseMap.size()-1) {
				if(minIndex<words.length) {
					if(words[minIndex].length()>words[i].length()) {
						minIndex = Math.min(minIndex, i);
					}
				}else {
					minIndex = i;
				}
				
			}

		}
		return words[minIndex];

	}

	// StringToMap
	public Map<Character, Integer> stringToMap(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if ((str.toLowerCase().charAt(i) >= 'a') && (str.toLowerCase().charAt(i) <= 'z')) {
				map.put(str.toLowerCase().charAt(i), map.getOrDefault(str.toLowerCase().charAt(i), 0) + 1);
			}
		}
		return map;
	}

}
