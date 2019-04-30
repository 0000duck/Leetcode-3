package Leetcode_1021_RemoveOutermostParentheses;

import java.util.LinkedList;
import java.util.Queue;

/*
	��Ч�����ַ���Ϊ�� ("")��"(" + A + ")" �� A + B��
	���� A �� B ������Ч�������ַ�����+ �����ַ��������ӡ�
	���磬""��"()"��"(())()" �� "(()(()))" ������Ч�������ַ�����
	
	�����Ч�ַ��� S �ǿգ��Ҳ����ڽ�����Ϊ S = A+B �ķ�����
	���ǳ���Ϊԭ�primitive�������� A �� B ���Ƿǿ���Ч�����ַ�����
	
	����һ���ǿ���Ч�ַ��� S�����ǽ������ԭ�ﻯ�ֽ⣬
	ʹ�ã�S = P_1 + P_2 + ... + P_k������ P_i ����Ч�����ַ���ԭ�
	
	�� S ����ԭ�ﻯ�ֽ⣬ɾ���ֽ���ÿ��ԭ���ַ�������������ţ����� S ��	 
	
	ʾ�� 1��	
		���룺"(()())(())"
		�����"()()()"
		���ͣ�
		�����ַ���Ϊ "(()())(())"��ԭ�ﻯ�ֽ�õ� "(()())" + "(())"��
		ɾ��ÿ�������е���������ź�õ� "()()" + "()" = "()()()"��
	ʾ�� 2��	
		���룺"(()())(())(()(()))"
		�����"()()()()(())"
		���ͣ�
		�����ַ���Ϊ "(()())(())(()(()))"��ԭ�ﻯ�ֽ�õ� "(()())" + "(())" + "(()(()))"��
		ɾ��ÿ�������е���������ź�õ� "()()" + "()" + "()(())" = "()()()()(())"��
	ʾ�� 3��	
		���룺"()()"
		�����""
		���ͣ�
		�����ַ���Ϊ "()()"��ԭ�ﻯ�ֽ�õ� "()" + "()"��
		ɾ��ÿ�������е���������ź�õ� "" + "" = ""��
 */
// 1021. ɾ������������
public class RemoveOutermostParentheses {
	public static void main(String[] args) {
		String S = "()()";
		String res = "";
		System.out.println(new RemoveOutermostParentheses().removeOuterParentheses(S).equals(res));
	}

	public String removeOuterParentheses(String S) {
		Queue<Character> queue = new LinkedList<Character>();
		int count = 0;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (count == 0 && !queue.isEmpty()) {
				clearMyQueue(queue, res);
			}
			if (S.charAt(i) == '(') {
				count++;
			} else {
				count--;
			}
			queue.add(S.charAt(i));
		}
		if (!queue.isEmpty()) {
			clearMyQueue(queue, res);
		}
		return res.toString();

	}

	// queue.clear
	public void clearMyQueue(Queue<Character> queue, StringBuilder res) {
		queue.poll();
		while (queue.size() > 1) {
			res.append(queue.poll());
		}
		queue.poll();
	}

	// 2ms
	public String removeOuterParentheses0(String S) {
		int length = S.length();
		char[] primitive = new char[length];
		// ���"("�ĸ���
		int flag = 0;
		// ��¼�������Ч����
		int count = 0;
		char[] ch = S.toCharArray();
		for (int i = 0; i < length; i++) {
			if (flag == 0) {
				++flag;
			} else {
				if (ch[i] == '(') {
					primitive[count] = '(';
					++count;
					++flag;
				} else {
					--flag;
					if (flag > 0) {
						primitive[count] = ')';
						++count;
					}
				}
			}
		}
		String Str = String.valueOf(primitive);
		Str = Str.substring(0, count);
		return Str;
	}
}
