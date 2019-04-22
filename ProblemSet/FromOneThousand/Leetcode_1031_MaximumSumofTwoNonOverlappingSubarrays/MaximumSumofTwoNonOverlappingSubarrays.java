package Leetcode_1031_MaximumSumofTwoNonOverlappingSubarrays;

/*
	�����Ǹ��������� A �������������ص�����������������Ԫ�ص����ͣ�������ĳ��ȷֱ�Ϊ L �� M��
	��������Ҫ������ǣ���Ϊ L ����������Գ����ڳ�Ϊ M ��������֮ǰ��֮�󡣣�
		
	����ʽ�Ͽ����������� V���� V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) 
	��������������֮һ��	
		0 <= i < i + L - 1 < j < j + M - 1 < A.length, ��
		0 <= j < j + M - 1 < i < i + L - 1 < A.length.	 
	
	
	 V = (dpL[i]) + (dpM[j])��ʱ��0 <= i < i + L - 1 < j < j + M - 1 < A.length, ��
	  
	
	ʾ�� 1��	
		���룺A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
		�����20
		���ͣ��������һ��ѡ���У�[9] ����Ϊ 1��[6,5] ����Ϊ 2��
	ʾ�� 2��	
		���룺A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
		�����29
		���ͣ��������һ��ѡ���У�[3,8,1] ����Ϊ 3��[8,9] ����Ϊ 2��
	ʾ�� 3��	
		���룺A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
		�����31
		���ͣ��������һ��ѡ���У�[5,6,0,9] ����Ϊ 4��[0,3,8] ����Ϊ 3��	 
	
	��ʾ��	
		L >= 1
		M >= 1
		L + M <= A.length <= 1000
		0 <= A[i] <= 1000
 */
//1031. �������ص������������
public class MaximumSumofTwoNonOverlappingSubarrays {
	// O(N^2)
	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
		int n = A.length;
		// s[i] = sum(A[0],....,A[i-1])
		int[] s = new int[n + 1];
		for (int i = 0; i < n; i++) {
			s[i + 1] = s[i] + A[i];
		}
		int ans = 0;
		for (int i = 0; i <= n - L; i++) {
			// 0-i+L - 0-i,����ΪL
			int ls = s[i + L] - s[i];
			// 0 ... i ... i+L-1.....n-1
			int ms = Math.max(maxSum(s, 0, i - M - 1, M), maxSum(s, i + L, n - M, M));
			ans = Math.max(ans, ls + ms);
		}
		return ans;
	}

	private int maxSum(int[] s, int start, int end, int M) {
		int ans = Integer.MIN_VALUE;
		// ������Ȳ����ᵼ��start>end
		for (int i = start; i <= end; i++) {
			ans = Math.max(ans, s[i + M] - s[i]);
		}
		return ans;
	}

}
