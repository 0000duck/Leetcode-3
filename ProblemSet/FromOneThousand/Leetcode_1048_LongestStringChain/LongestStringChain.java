package Leetcode_1048_LongestStringChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	����һ�������б�����ÿ�����ʶ���СдӢ����ĸ��ɡ�
	
	������ǿ����� word1 ���κεط����һ����ĸʹ���� word2��
	��ô������Ϊ word1 �� word2 ��ǰ�����磬"abc" �� "abac" ��ǰ��
	
	�����ǵ��� [word_1, word_2, ..., word_k] ��ɵ����У�
	k >= 1������ word_1 �� word_2 ��ǰ��word_2 �� word_3 ��ǰ���������ơ�
	
	�Ӹ��������б� words ��ѡ�񵥴���ɴ��������ش���������ܳ��ȡ� 
	
	ʾ����	
		���룺["a","b","ba","bca","bda","bdca"]
		�����4
		���ͣ��������֮һΪ "a","ba","bda","bdca"��
	
	��ʾ��	
		1 <= words.length <= 1000
		1 <= words[i].length <= 16
		words[i] ����СдӢ����ĸ��ɡ�
 */

//1048. Longest String Chain
public class LongestStringChain {
	public static void main(String[] args) {
		System.out.println(new LongestStringChain().isPre("a", "ba"));
	}
    public int longestStrChain(String[] words) {
        Arrays.sort(words,new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		// TODO �Զ����ɵķ������
        		return o1.length()-o2.length();
        	}
        });
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<words.length;i++) {
        	String str = words[i];
        	if(!map.containsKey(str)) {
        		List<String> list = new ArrayList<>();
        		map.put(str, list);        		
        	}
        	for(int j = i+1;j<words.length;j++) {
        		if(isPre(str,words[j])) {
        			map.get(str).add(words[j]);        			
        		}
        	}
        }
        int res = Integer.MIN_VALUE;
        
        return -1;
        
    }
    //�ж��Ƿ���ǰ��

	private boolean isPre(String str, String str2) {
		int i = 0;
		int j = 0;
		while(i<str.length()) {
			if(j==str2.length()) {
				return false;
			}
			char ch1 = str.charAt(i);
			char ch2 = str2.charAt(j);
			if(ch1==ch2) {
				i++;
				j++;
			}else {
				j++;
			}			
		}
		return true;
		
	}
    
}

