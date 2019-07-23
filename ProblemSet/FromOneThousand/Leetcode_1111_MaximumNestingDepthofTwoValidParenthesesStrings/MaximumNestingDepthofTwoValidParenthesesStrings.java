package Leetcode_1111_MaximumNestingDepthofTwoValidParenthesesStrings;

import java.util.Arrays;
import java.util.Stack;

/*
	��Ч�����ַ��� ���� "(" �� ")" ���ɣ�������������������֮һ��
		���ַ���
		���ӣ����Լ��� AB��A �� B ���ӣ������� A �� B ������Ч�����ַ���
		Ƕ�ף����Լ��� (A)������ A ����Ч�����ַ���
	���Ƶأ����ǿ��Զ���������Ч�����ַ��� s �� Ƕ����� depth(S)��
		s Ϊ��ʱ��depth("") = 0
		s Ϊ A �� B ����ʱ��depth(A + B) = max(depth(A), depth(B))������ A �� B ������Ч�����ַ���
		s ΪǶ�������depth("(" + A + ")") = 1 + depth(A)������ A ����Ч�����ַ���
		���磺""��"()()"���� "()(()())" ������Ч�����ַ�����Ƕ����ȷֱ�Ϊ 0��1��2���� ")(" �� "(()" ��������Ч�����ַ����� 
	
	����һ����Ч�����ַ��� seq������ֳ��������ཻ�������� A �� B��
	�� A �� B ������Ч�����ַ����Ķ��壨ע�⣺A.length + B.length = seq.length����
	
	���ڣ�����Ҫ����ѡ�� ���� һ����Ч�����ַ��� A �� B��ʹ max(depth(A), depth(B)) �Ŀ���ȡֵ��С��
	
	���س���Ϊ seq.length ������ answer ��ѡ�� A ���� B �ı�������ǣ�
		��� seq[i] �� A ��һ���֣���ô answer[i] = 0������answer[i] = 1��
		�����ж������Ҫ��Ĵ𰸴��ڣ���Ҳֻ�践�� һ���� 
	
	ʾ�� 1��
		���룺seq = "(()())"
		�����[0,1,1,1,1,0]
	ʾ�� 2��
		���룺seq = "()(())()"
		�����[0,0,0,1,1,0,1,1] 
	
	��ʾ��
		1 <= text.size <= 10000
 */
//1111.��Ч���ŵ�Ƕ�����
public class MaximumNestingDepthofTwoValidParenthesesStrings {
	public int[] maxDepthAfterSplit(String seq) {
		int length = seq.length();
		int[] res = new int[length];
		Stack<Integer> stack = new Stack<>();
		char[] seqArr = seq.toCharArray();
		for (int i = 0; i < length; i++) {
			if (seqArr[i] == '(') {
				if (stack.isEmpty()) {
					res[i] = 0;
				} else {
					res[i] = 1 - res[stack.peek()];
				}
				stack.push(i);
			} else {
				res[i] = res[stack.pop()];
			}
		}
		return res;
	}
}
