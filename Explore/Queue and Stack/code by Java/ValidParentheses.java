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
		// ���ַ���
		if (s.equals("")) {
			return true;
		}
		// ��������
		if (s.length() % 2 == 1) {
			return false;
		}
		// ջ
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if ((temp == '(') || (temp == '[') || (temp == '{')) {
				stack.push(temp);
			} else if ((temp == ')') || (temp == ']') || (temp == '}')) {
				if (stack.isEmpty()) {
					return false;
				} else if ((temp == ')')) {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
				} else if (temp == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						return false;
					}
				} else {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						return false;
					}
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

	public boolean isValid2(String s) {
		// ���ַ���
		if (s.equals("")) {
			return true;
		}
		// ��������
		if (s.length() % 2 == 1) {
			return false;
		}
		// HashMap
		HashMap<Character, Integer> map = new HashMap();
		map.put('(', -1);
		map.put(')', 1);
		map.put('[', -2);
		map.put(']', 2);
		map.put('{', -3);
		map.put('}', 3);
		// �ַ���������
		StringBuilder builder = new StringBuilder(s);
		if (map.get(builder.charAt(0)) > 0) {
			return false;
		}
		// ɾ�����ڵ�����
		int[] flag = { 0, 1 };
		while (flag[0] != flag[1]) {
			flag[0] = builder.length();
			for (int i = 1; i < builder.length(); i++) {
				if (map.get(builder.charAt(i)) + map.get(builder.charAt(i - 1)) == 0) {
					builder.delete(i - 1, i + 1);
				}
			}
			flag[1] = builder.length();
		}
		if (builder.length() != 0) {
			return false;
		}
		return true;

	}

}
