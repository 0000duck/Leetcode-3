package Leetcode_494_TargetSum;

import java.util.Stack;

/*
	����һ���Ǹ��������飬a1, a2, ..., an, ��һ��Ŀ������S��
	���������������� + �� -��
	���������е�����һ���������㶼���Դ� + �� -��ѡ��һ�����������ǰ�档
	
	���ؿ���ʹ���������ΪĿ���� S ��������ӷ��ŵķ�������
	
	ʾ�� 1:	
		����: nums: [1, 1, 1, 1, 1], S: 3
		���: 5
		����: 		
			-1+1+1+1+1 = 3
			+1-1+1+1+1 = 3
			+1+1-1+1+1 = 3
			+1+1+1-1+1 = 3
			+1+1+1+1-1 = 3
		
		һ����5�ַ���������Ŀ���Ϊ3��
	ע��:	
		����ĳ��Ȳ��ᳬ��20�����������е�ֵȫΪ������
		��ʼ������ĺͲ��ᳬ��1000��
		��֤���ص����ս��Ϊ32λ������
 */
public class TargetSum {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int S = 3;
		TargetSum ts = new TargetSum();
		ts.findTargetSumWays(nums, S);
	}

	// 494. Ŀ��ͣ������ף�
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		//

		return helper(nums, S, 0, 0, 0);
	}

	// ���ﲻ����ȫ�ֱ���count��ԭ����ÿ�ε�count���ѷ���ֵ��ʽ����
	public int helper(int[] nums, int S, int sum, int index, int count) {
		// System.out.println("sum:" + sum + ";index:" + index);
		if (index == nums.length) {
			if (sum == S) {
				count++;
			}
			return count;
		}
		return helper(nums, S, sum + nums[index], index + 1, count)

				+ helper(nums, S, sum - nums[index], index + 1, count);
	}

	// 7ms
	public int findTargetSumWays0(int[] nums, int s) {
		int sum = 0;
		for (int n : nums)
			sum += n;
		//���������ּ���һ����s�Ƚ�
		//���sum<s����(s + sum) % 2 > 0������0��
		//����subsetSum(nums, (s + sum) >>> 1)
		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
	}

	public int subsetSum(int[] nums, int s) {
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int n : nums)
			for (int i = s; i >= n; i--)
				dp[i] += dp[i - n];
		return dp[s];
	}
}
