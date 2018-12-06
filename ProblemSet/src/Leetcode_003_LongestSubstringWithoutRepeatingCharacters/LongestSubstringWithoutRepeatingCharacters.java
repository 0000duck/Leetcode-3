package Leetcode_003_LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.List;

/*
	����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
	
	ʾ�� 1:	
		����: "abcabcbb"
		���: 3 
		����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
	ʾ�� 2:	
		����: "bbbbb"
		���: 1
		����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
	ʾ�� 3:	
		����: "pwwkew"
		���: 3
		����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
		     ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "au";
		new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
	}

	// 3. ���ظ��ַ�����Ӵ�
	public int lengthOfLongestSubstring(String s) {
		
	}
	//�����ڴ����� 
	public int lengthOfLongestSubstring1(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		int maxlength = Integer.MIN_VALUE;
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (list.contains(s.charAt(i))) {
				maxlength = Math.max(maxlength, list.size());
				break;
			} else {
				list.add(s.charAt(i));
			}
			if (i == s.length() - 1) {
				maxlength = Math.max(maxlength, list.size());
			}
		}
		return Math.max(maxlength, lengthOfLongestSubstring(s.substring(1, s.length())));
	}

}
