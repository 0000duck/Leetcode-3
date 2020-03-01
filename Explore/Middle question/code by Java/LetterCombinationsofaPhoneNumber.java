package Leetcode_017_LetterCombinationsofaPhoneNumber;

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
	public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();// ����
		if (digits.isEmpty())
			return ans;
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
