package Leetcode_643_MaximumAverageSubarray1;

/*
	���� n ���������ҳ�ƽ��������ҳ���Ϊ k �����������飬����������ƽ������
	
	ʾ�� 1:	
		����: [1,12,-5,-6,50,3], k = 4
		���: 12.75
		����: ���ƽ���� (12-5-6+50)/4 = 51/4 = 12.75	
	ע��:	
		1 <= k <= n <= 30,000��
		�������ݷ�Χ [-10,000��10,000]��
 */
public class MaximumAverageSubarray1 {


	// 643. ���������ƽ���� I
	public double findMaxAverage(int[] nums, int k) {
		double maxSum = Integer.MIN_VALUE;
		double sum = 0;
		// k = min((size_t)k, nums.size());
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i >= k) {
				sum -= nums[i - k];
			}
			if (i >= k - 1) {
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum / k;
	}

	// 9ms
	public double findMaxAverage0(int[] nums, int k) {
		int n = nums.length;
		int sum = 0;
		int sum1 = 0;
		for (int i = 0; i < k; i++) {
			sum1 += nums[i];
		}
		sum = sum1;
		for (int i = k; i < n; i++) {
			sum1 += nums[i];
			sum1 -= nums[i - k];
			sum = Math.max(sum1, sum);
		}
		return sum * 1.0 / k;
	}

	// ��ʱ
	public double findMaxAverage2(int[] nums, int k) {
		double maxAverage = Integer.MIN_VALUE;
		for (int i = 0; i <= nums.length - k; i++) {
			double sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += nums[j];
			}
			maxAverage = Math.max(maxAverage, sum / k);
		}
		return maxAverage;
	}

}
