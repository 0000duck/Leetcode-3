package Leetcode_020_ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

/*
	����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
	
	��Ч�ַ��������㣺	
		�����ű�������ͬ���͵������űպϡ�//��Ϊ0
		�����ű�������ȷ��˳��պϡ�
		ע����ַ����ɱ���Ϊ����Ч�ַ�����
	
	ʾ�� 1:	
		����: "()"
		���: true
	ʾ�� 2:	
		����: "()[]{}"
		���: true
	ʾ�� 3:	
		����: "(]"
		���: false
	ʾ�� 4:	
		����: "([)]"
		���: false
	ʾ�� 5:	
		����: "{[]}"
		���: true
*/
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("()"));
	}

	// 20.��Ч������
	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();
		for (char temp : s.toCharArray()) {
			if ((temp == '(') || (temp == '[') || (temp == '{')) {
				stack.push(temp);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char c = stack.pop();
				char match;
				if ((temp == ')')) {
					match = '(';
				} else if (temp == ']') {
					match = '[';
				} else {
					match = '}';
				}

				if (c != match) {
					return false;
				}
			}

		}

		return stack.isEmpty();

	}

	// 4ms
	public boolean isValid0(String s) {
		char[] stack = new char[s.length() / 2 + 1];
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			switch (x) {
			case '(':
			case '[':
			case '{':
				stack[k++] = x;
				break;
			case ')':
				if (k <= 0 || stack[--k] != '(') {
					return false;
				}
				break;
			case ']':
				if (k <= 0 || stack[--k] != '[') {
					return false;
				}
				break;
			case '}':
				if (k <= 0 || stack[--k] != '{') {
					return false;
				}
				break;
			}
		}
		return k == 0;
	}

}
