package Leetcode_1137_NthTribonacciNumber;

/*
	̩���������� Tn �������£� 
		T0 = 0, 
		T1 = 1, 
		T2 = 1, 
		Tn+3 = Tn + Tn+1 + Tn+2(n>=0)
	�������� n���뷵�ص� n ��̩�������� Tn ��ֵ��
	
	ʾ�� 1��
		���룺n = 4
		�����4
		���ͣ�
			T_3 = 0 + 1 + 1 = 2
			T_4 = 1 + 1 + 2 = 4
	ʾ�� 2��
		���룺n = 25
		�����1389537
	
	��ʾ��
		0 <= n <= 37
		�𰸱�֤��һ�� 32 λ�������� answer <= 2^31 - 1��
 */

//1137.�� N ��̩��������
public class NthTribonacciNumber {
	public int tribonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n <= 2) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}
}