package Leetcode_1119_RemoveVowelsfromaString;

import java.util.Arrays;
import java.util.HashSet;
/*
	����һ���ַ��� S������ɾȥ���е�����Ԫ����ĸ�� 'a'��'e'��'i'��'o'��'u'����������������ַ����� 
	
	ʾ�� 1��	
		���룺"leetcodeisacommunityforcoders"
		�����"ltcdscmmntyfrcdrs"
	ʾ�� 2��		
		���룺"aeiou"
		�����""
	 
	
	��ʾ��	
	S ����СдӢ����ĸ��ɡ�
	1 <= S.length <= 1000
 */
public class RemoveVowelsfromaString {
	
	//1119. ɾȥ�ַ����е�Ԫ��
    public String removeVowels(String S) {
        HashSet<Character> set = new HashSet<>(Arrays.asList(new Character[] {'a','e','i','o','u'}));
        StringBuilder res = new StringBuilder();
        for(char ch :S.toCharArray()) {
        	if(!set.contains(ch)) {
        		res.append(ch);
        	}
        }
        return res.toString();
        
    }
}
