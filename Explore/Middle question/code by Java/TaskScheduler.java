package Leetcode_621_TaskScheduler;

import java.util.Arrays;

/*
	����һ�����ַ������ʾ�� CPU ��Ҫִ�е������б����а���ʹ�ô�д�� A - Z ��ĸ��ʾ��26 �ֲ�ͬ���������
	�������������˳��ִ�У�����ÿ�����񶼿����� 1 ����λʱ����ִ���ꡣCPU ���κ�һ����λʱ���ڶ�����ִ��һ�����񣬻����ڴ���״̬��
	Ȼ����������ͬ���������֮������г���Ϊ n ����ȴʱ�䣬������������� n ����λʱ���� CPU ��ִ�в�ͬ�����񣬻����ڴ���״̬��
	����Ҫ�������������������Ҫ�����ʱ�䡣
	
	ʾ�� 1��
		����: tasks = ["A","A","A","B","B","B"], n = 2
		���: 8
		ִ��˳��: A -> B -> (����) -> A -> B -> (����) -> A -> B.
	ע��
		������ܸ���Ϊ [1, 10000]��
		n ��ȡֵ��ΧΪ [0, 100]��
 */

//621. ���������
public class TaskScheduler {
	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		new TaskScheduler().leastInterval(tasks, 3);

	}

	public int leastInterval(char[] tasks, int n) {
		int[] c = new int[26];
		for (char ch : tasks) {
			c[ch - 'A']++;
		}
		Arrays.sort(c);// ��ʾ����������c[25]��
		int i = 25;// 25-i��ʾ�����������25-i��
		while (i >= 0 && c[i] == c[25])
			i--;		
		// (c[25] - 1) * (n + 1) + 25 - i
		// ÿ��n+1������һ����Ҫc[25]-1�飬��������Ļ�������һ�鵫ֻ��25-iλ��
		return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);

	}
}
