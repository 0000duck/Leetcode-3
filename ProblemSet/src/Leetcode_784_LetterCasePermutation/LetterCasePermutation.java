package Leetcode_784_LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

/*
	����һ���ַ���S��ͨ�����ַ���S�е�ÿ����ĸת���Сд�����ǿ��Ի��һ���µ��ַ������������п��ܵõ����ַ������ϡ�
	
	ʾ��:
		����: S = "a1b2"
		���: ["a1b2", "a1B2", "A1b2", "A1B2"]
		
		����: S = "3z4"
		���: ["3z4", "3Z4"]
		
		����: S = "12345"
		���: ["12345"]
		
	ע�⣺		
		S �ĳ��Ȳ�����12��
		S �������ֺ���ĸ��ɡ�
 */
public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String S = "a1b2";
		LetterCasePermutation lcp = new LetterCasePermutation();
		lcp.letterCasePermutation(S);
	}

	// 784. ��ĸ��Сдȫ����
	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<String>();
		StringBuilder temStr = new StringBuilder(S);
		letterCasePermutation(temStr, S, S.length() - 1, result);

		return result;
	}

	public void letterCasePermutation(StringBuilder temStr, String S, int end, List<String> result) {
		result.add(temStr.toString());
		for (int i = end; i >= 0; i--) {
			char temp = S.charAt(i);
			if (temp >= 'a' && temp <= 'z') {
				temStr.replace(i, i + 1, String.valueOf((char) (temp - 32)));
				letterCasePermutation(temStr, S, i - 1, result);
				temStr.replace(i, i + 1, String.valueOf(temp));
			} else if (temp >= 'A' && temp <= 'Z') {
				temStr.replace(i, i + 1, String.valueOf((char) (temp + 32)));
				letterCasePermutation(temStr, S, i - 1, result);
				temStr.replace(i, i + 1, String.valueOf(temp));

			}
		}
	}

	// 4ms
	public List<String> letterCasePermutation0(String S) {
		List<String> list = new ArrayList<>();
		if (S == null)
			return list;
		dfs(S.toCharArray(), 0, list);
		return list;
	}

	void dfs(char[] chars, int index, List<String> list) {
		if (index == chars.length) {
			list.add(new String(chars));
			return;
		}
		char c = chars[index];
		dfs(chars, index + 1, list);
		if (chars[index] >= 'a') {
			chars[index] = (char) (chars[index] - 32);
			dfs(chars, index + 1, list);
		} else if (chars[index] >= 'A') {
			chars[index] = (char) (chars[index] + 32);
			dfs(chars, index + 1, list);
		}

		chars[index] = c;

	}
}
