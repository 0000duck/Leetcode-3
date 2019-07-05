package Leetcode_1099_TwoSumLessThanK;

import java.util.Arrays;

/*
	����һ���������� A ��һ������ K�����ڸ��������ҳ�����Ԫ�أ�
	ʹ���ǵĺ�С�� K �������ܵؽӽ� K������������Ԫ�صĺ͡�
	
	�粻��������������Ԫ�أ��뷵�� -1�� 
	
	ʾ�� 1��	
		���룺A = [34,23,1,24,75,33,54,8], K = 60
		�����58
		���ͣ�
		34 �� 24 ��ӵõ� 58��58 С�� 60���������⡣
	ʾ�� 2��	
		���룺A = [10,20,30], K = 15
		�����-1
		���ͣ�
		�����޷��ҵ���С�� 15 ������Ԫ�ء�
	
	��ʾ��	
		1 <= A.length <= 100
		1 <= A[i] <= 1000
		1 <= K <= 2000
 */
//1099.С�� K ������֮��
public class TwoSumLessThanK {

	// O(N^2)
	public int twoSumLessThanK(int[] A, int K) {
		int res = -1;
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] + A[j] < K) {
					res = Math.max(res, A[i] + A[j]);
				}
			}
		}
		return res;
	}

	// O(NlogN)
	public int twoSumLessThanK2(int[] A, int K) {
		Arrays.sort(A);
		int res = -1;
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi) {
			if (A[lo] + A[hi] >= K) {
				hi--;
			} else {
				res = Math.max(A[lo] + A[hi], res);
				lo++;
			}
		}
		return res;
	}
}
