package Leetcode_921_MinimumAddtoMakeParenthesesValid;

import java.util.Stack;

/*
	����һ���� '(' �� ')' ������ɵ��ַ��� S��
	������Ҫ������ٵ����ţ� '(' ���� ')'���������κ�λ�ã�����ʹ�õ��������ַ�����Ч��
	
	����ʽ�Ͻ���ֻ���������漸��֮һ�������ַ���������Ч�ģ�
		����һ�����ַ���������
		�����Ա�д�� AB ��A �� B ���ӣ�, ���� A �� B ������Ч�ַ���������
		�����Ա�д�� (A)������ A ����Ч�ַ�����
		����һ�������ַ���������Ϊʹ����ַ�����Ч��������ӵ�������������
	ʾ�� 1��
		���룺"())"
		�����1
	ʾ�� 2��
		���룺"((("
		�����3
	ʾ�� 3��
		���룺"()"
		�����0
	ʾ�� 4��
		���룺"()))(("
		�����4
	��ʾ��
		S.length <= 1000
		S ֻ���� '(' �� ')' �ַ���
 */
public class MinimumAddtoMakeParenthesesValid {
	public int minAddToMakeValid(String S) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) {
			if ((S.charAt(i) == ')') && !stack.isEmpty() && (stack.peek() == '(')) {
				stack.pop();
			} else {
				stack.push(S.charAt(i));
			}
		}
		return stack.size();
	}
}
