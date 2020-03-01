package Leetcode_739_DailyTemperatures;

import java.util.Arrays;

/*
	����ÿ�� ���� �б�����������һ���б���Ӧλ�õ�����������Ҫ�ٵȴ�����¶ȲŻ����ߵ����������֮�󶼲������ߣ������� 0 �����档
	
	���磬����һ���б� temperatures = [73, 74, 75, 71, 69, 72, 76, 73]��
					  ������Ӧ����   [ 1,  1,  4,  2,  1,  1,  0,  0]��
	
	��ʾ������ �б��ȵķ�Χ�� [1, 30000]��ÿ�����µ�ֵ�Ķ��� [30, 100] ��Χ�ڵ�������
 */
public class DailyTemperatures {
	public static void main(String[] args) {
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		Arrays.toString(new DailyTemperatures().dailyTemperatures(T));
	}

	// 739. ÿ���¶�
	public int[] dailyTemperatures(int[] T) {
		if (T.length == 1) {
			return new int[] { 0 };
		}
		int[] result = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			int res = 0;
			for (int j = i + 1; j < T.length; j++) {
				if (T[j] > T[i]) {
					res++;
					break;
				} else if (j == T.length - 1) {
					res = 0;
					break;
				} else {
					res++;
				}
			}
			result[i] = res;
		}
		return result;
	}

	// 7ms
	public int[] dailyTemperatures0(int[] T) {
		if (T == null || T.length == 0)
			return T;
		int[] result = new int[T.length];
		int[] stack = new int[T.length]; // ��int�������stack
		int top = -1;
		for (int i = 0; i < T.length; i++) {
			while (top > -1 && T[i] > T[stack[top]]) {
				int index = stack[top--];
				result[index] = i - index;
			}
			stack[++top] = i;
		}
		return result;
	}
}
