package Leetcode_017_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
	����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
	�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
	
	ʾ��:
		���룺"23"
		�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
//17. �绰�������ĸ���
public class LetterCombinationsofaPhoneNumber {
	private char[][] map = { { '0' }, { '1' }, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
	List<String> res = new ArrayList<String>();
	public List<String> letterCombinations(String digits) {
		if(digits==null||digits.length()==0) {
			return res;
		}
		helper(digits.toCharArray(),0,"");
		return res;
	}

	private void helper(char[] digits, int index, String str) {
		if(index==digits.length) {
			res.add(str);
			return;
		}
		int digit = digits[index]-'0';
		for(int i = 0;i<map[digit].length;i++) {
			helper(digits,index+1,str+map[digit][i]);
		}
		
	}

	public List<String> letterCombinations1(String digits) {
		LinkedList<String> ans = new LinkedList<String>();// ����
		if (digits.isEmpty()) {
			return ans;
		}
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			// ����x
			int x = Character.getNumericValue(digits.charAt(i));
			// �ж��Ƿ������ϣ��ַ����ĳ��������ֵ�λ�����
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;

	}
}
