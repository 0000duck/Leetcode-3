package Leetcode_856_ScoreofParentheses;

import java.util.Stack;

/*
	����һ��ƽ�������ַ��� S�����������������ַ����ķ�����	
		() �� 1 �֡�
		AB �� A + B �֣����� A �� B ��ƽ�������ַ�����
		(A) �� 2 * A �֣����� A ��ƽ�������ַ�����
	 
	
	ʾ�� 1��	
		���룺 "()"
		����� 1
	ʾ�� 2��	
		���룺 "(())"
		����� 2
	ʾ�� 3��	
		���룺 "()()"
		����� 2
	ʾ�� 4��	
		���룺 "(()(()))"
		����� 6 
	
	��ʾ��	
		S ��ƽ�������ַ�������ֻ���� ( �� ) ��
		2 <= S.length <= 50
 */

//856. ���ŵķ���
public class ScoreofParentheses {

	public int scoreOfParentheses(String S) {
		Stack<Integer> stack = new Stack<Integer>();
		// Stack<Character> num = new Stack<>();
		int res = 0;
		for (char ch : S.toCharArray()) {
			if (ch == '(') {
				stack.push(res);
				res = 0;
			} else {
				res = stack.pop() + Math.max(res * 2, 1);
			}
		}
		return res;
	}

	// 1ms
	public int scoreOfParentheses0(String S) {
		int point = 0;
		int mul = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				mul++;
			} else {
				mul--;
			}
			if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
				point += 1 << mul; // 1�˼���2
			}
		}
		return point;
	}

}
