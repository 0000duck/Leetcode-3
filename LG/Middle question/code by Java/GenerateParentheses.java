package Leetcode_022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
	���� n �����������ŵĶ���������д��һ��������
	ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
	
	���磬���� n = 3�����ɽ��Ϊ��
		[
		  "((()))",
		  "(()())",
		  "(())()",
		  "()(())",
		  "()()()"
		]
 */

//22. ��������
public class GenerateParentheses {
	List<String> result = null;
	int n = 0;

	public List<String> generateParenthesis(int n) {
		result = new ArrayList<String>();
		this.n = n;
		char[] arr = new char[2 * n];
		// lc��������,rc��������,pos�����ָ��
		generateParenRec(0, 0, 0, arr);
		return result;
	}

	public void generateParenRec(int lc, int rc, int pos, char[] arr) {
		// lc�������ŵĸ���;rc:�����ŵĸ���;pos:��ǰ���ŵ�����

		// ���������һ��
		if (pos == arr.length) {
			result.add(new String(arr));
			return;
		}
		// ������������
		if (lc < n) {
			arr[pos] = '(';
			generateParenRec(lc + 1, rc, pos + 1, arr);
		}
		// ��������������������
		if (lc > rc) {
			arr[pos] = ')';
			generateParenRec(lc, rc + 1, pos + 1, arr);
		}

	}
}
