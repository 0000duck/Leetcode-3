package Leetcode_1003_CheckIfWordIsValidAfterSubstitutions;

import java.util.Stack;

/*
	������Ч�ַ��� "abc"��	
	�����κ���Ч���ַ��� V�����ǿ��Խ� V �ֳ��������� X �� Y��ʹ�� X + Y��X �� Y ���ӣ����� V����X �� Y ����Ϊ�ա�����ô��X + "abc" + Y Ҳͬ������Ч�ġ�	
	���磬��� S = "abc"������Ч�ַ�����ʾ���ǣ�"abc"��"aabcbc"��"abcabc"��"abcabcababcc"����Ч�ַ�����ʾ���ǣ�"abccba"��"ab"��"cababc"��"bac"��	
	��������ַ��� S ��Ч���򷵻� true�����򣬷��� false��	 
	
	ʾ�� 1��	
		���룺"aabcbc"
		�����true
		���ͣ�
		����Ч�ַ��� "abc" ��ʼ��
		Ȼ�����ǿ����� "a" �� "bc" ֮�������һ�� "abc"������ "a" + "abc" + "bc"���� "aabcbc"��
	ʾ�� 2��	
		���룺"abcabcababcc"
		�����true
		���ͣ�
		"abcabcabc" ����Ч�ģ�������������ԭ������������ "abc"��
		Ȼ�����ǿ��������һ����ĸ֮ǰ���� "abc"������ "abcabcab" + "abc" + "c"���� "abcabcababcc"��
	ʾ�� 3��	
		���룺"abccba"
		�����false
	ʾ�� 4��	
		���룺"cababc"
		�����false
	
	��ʾ��	
		1 <= S.length <= 20000
		S[i] Ϊ 'a'��'b'���� 'c'
 
 */
public class CheckIfWordIsValidAfterSubstitutions {
//1003. ����滻��Ĵ��Ƿ���Ч
	public boolean isValid(String S) {
		Stack<Character> stack = new Stack<>();
		for (char ch : S.toCharArray()) {
			if (ch != 'c') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty() && stack.pop() != 'b') {
					return false;
				}
				if (!stack.isEmpty() && stack.pop() != 'a') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
