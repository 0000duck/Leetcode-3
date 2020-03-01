package Leetcode_300_LongestIncreasingSubsequence;

/*
	����һ��������������飬�ҵ���������������еĳ��ȡ�
	
	ʾ��:	
		����: [10,9,2,5,3,7,101,18]
		���: 4 
	����: ��������������� [2,3,7,101]�����ĳ����� 4��
	˵��:	
		���ܻ��ж�������������е���ϣ���ֻ��Ҫ�����Ӧ�ĳ��ȼ��ɡ�
		���㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(n2) ��
	����: ���ܽ��㷨��ʱ�临�ӶȽ��͵� O(n log n) ��?
 */
//300.�������������
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int length = nums.length;
		int[] dp = new int[length];
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}

	// 0ms
	public int lengthOfLIS0(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		int last = 0;
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				dp[0] = nums[0];
			} else if (dp[last] < nums[i]) {
				dp[++last] = nums[i];
			} else {
				for (int j = 0; j <= last; j++) {
					if (dp[j] >= nums[i]) {
						dp[j] = nums[i];
						break;
					}
				}
			}
		}
		return last + 1;
	}
}
