package Leetcode_150_EvaluateReversePolishNotation;

import java.sql.Array;
import java.util.Arrays;
import java.util.Stack;

/*
	�����沨����ʾ��������ʽ��ֵ��
	
	��Ч����������� +, -, *, / ��ÿ��������������������Ҳ��������һ���沨�����ʽ��
	
	˵����	
		��������ֻ�����������֡�
		�����沨�����ʽ������Ч�ġ����仰˵�����ʽ�ܻ�ó���Ч��ֵ�Ҳ����ڳ���Ϊ 0 �������
	
	ʾ�� 1:	
		����: ["2", "1", "+", "3", "*"]
		���: 9
		����: ((2 + 1) * 3) = 9
		
	ʾ�� 2��	
		����: ["4", "13", "5", "/", "+"]
		���: 6
		����: (4 + (13 / 5)) = 6
		
	ʾ�� 3��	
		����: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
		���: 22
		����: 
		  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
		= ((10 * (6 / (12 * -11))) + 17) + 5
		= ((10 * (6 / -132)) + 17) + 5
		= ((10 * 0) + 17) + 5
		= (0 + 17) + 5
		= 17 + 5
		= 22
 */
public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
	}

	// 150. �沨�����ʽ��ֵ
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		for (String str : tokens) {
			if (str.equals("+")) {
				int temp1 = s.peek();
				s.pop();
				int temp2 = s.peek();
				s.pop();
				s.push(temp1 + temp2);
			} else if (str.equals("-")) {
				int temp1 = s.peek();
				s.pop();
				int temp2 = s.peek();
				s.pop();
				s.push(temp2 - temp1);
			} else if (str.equals("*")) {
				int temp1 = s.peek();
				s.pop();
				int temp2 = s.peek();
				s.pop();
				s.push(temp1 * temp2);
			} else if (str.equals("/")) {
				int temp1 = s.peek();
				s.pop();
				int temp2 = s.peek();
				s.pop();
				s.push(temp2 / temp1);
			} else {
				s.push(Integer.parseInt(str));
			}
		}
		return s.peek();
	}

	// 2ms
	private int N = -1;

	public int evalRPN0(String[] tokens) {

		if (N == -1)
			N = tokens.length - 1;
		String s = tokens[N--];
		char c = s.charAt(0);
		if (s.length() == 1 && "+-*/".indexOf(c) != -1) {
			int a = evalRPN(tokens);
			int b = evalRPN(tokens);
			switch (c) {
			case '+':
				return a + b;
			case '-':
				return b - a;
			case '*':
				return a * b;
			case '/':
				return b / a;
			default:
				break;
			}
		}
		return Integer.parseInt(s);
	}
}
