package Leetcode_290_WordPattern;

import java.util.HashMap;
import java.util.Map;

/*
	����һ�� pattern(ģʽ) ��һ���ַ��� str ���ж� str �Ƿ���ѭ��ͬ��ģʽ��	
	�������ѭָ��ȫƥ�䣬���磬 pattern ���ÿ����ĸ���ַ��� str �е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧģʽ��
	
	ʾ��1:	
		����: pattern = "abba", str = "dog cat cat dog"
		���: true
		
	ʾ�� 2:	
		����:pattern = "abba", str = "dog cat cat fish"
		���: false
		
	ʾ�� 3:	
		����: pattern = "aaaa", str = "dog cat cat dog"
		���: false
		
	ʾ�� 4:		
		����: pattern = "abba", str = "dog dog dog dog"
		���: false
		
	˵��:
		����Լ��� pattern ֻ����Сд��ĸ�� str �������ɵ����ո�ָ���Сд��ĸ��    
 */
public class WordPattern {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String pattern = "ab";
		String str = "cat dog";
		System.out.println(new WordPattern().wordPattern(pattern, str));
	}

	// 290. ����ģʽ

	// 0ms
	public boolean wordPattern0(String pattern, String str) {
		char[] pc = pattern.toCharArray();
		String[] words = str.split(" ");
		// ���Ȳ���
		if (pc.length != words.length) {
			return false;
		}
		// ��ascii����Ϊ�±�洢String��Ҳ����String[] mark = new String[26];ֻҪ����mark[pc[i]-97]����
		String[] mark = new String[123];
		for (int i = 0; i < pc.length; i++) {
			if (mark[pc[i]] == null) {
				mark[pc[i]] = words[i];
			}
			// ����ֵ������֮ǰ�洢�Ĳ�ͬ�����Ը�ʽ����
			else if (!mark[pc[i]].equals(words[i])) {
				return false;
			}
		}

		// ����2����������
		for (int i = 97; i < 122; i++) {
			for (int j = i + 1; j < 123; j++) {
				if (mark[i] != null && mark[i].equals(mark[j])) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean wordPattern2(String pattern, String str) {
		String[] sArr = str.split(" ");
		HashMap<Character, String> map = new HashMap<>();
		HashMap<String, Character> map2 = new HashMap<>();
		if (pattern.length() != sArr.length) {
			return false;
		}
		for (int i = 0; i < sArr.length; i++) {
			char temp = pattern.charAt(i);
			if (map.containsKey(temp) && !map.get(temp).equals(sArr[i])) {
				return false;
			}
			if (map2.containsKey(sArr[i]) && map2.get(sArr[i]) != temp) {
				return false;
			}
			map.put(temp, sArr[i]);
			map2.put(sArr[i], temp);
		}
		return true;

	}
}
