package Leetcode_377_CombinationSumIV;

import java.util.Arrays;

/*
	����һ��������������Ҳ������ظ����ֵ����飬�ҳ���Ϊ����Ŀ������������ϵĸ�����
	
	ʾ��:	
		nums = [1, 2, 3]
		target = 4
		
		���п��ܵ����Ϊ��
		(1, 1, 1, 1)
		(1, 1, 2)
		(1, 2, 1)
		(1, 3)
		(2, 1, 1)
		(2, 2)
		(3, 1)
		
		��ע�⣬˳��ͬ�����б�������ͬ����ϡ�
		
		������Ϊ 7��
	���ף�
		��������������к��и�������ô����
		��������ʲô�仯��
		������Ҫ����Ŀ�����ʲô�������������ĳ��֣�
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/combination-sum-iv
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

//377. ����ܺ� ��
public class CombinationSumIV {
	public static void main(String[] args) {
		new CombinationSumIV().combinationSum42(new int[] { 1, 2, 3 }, 4);
	}

	// DFS(��ʱ)
	public int combinationSum42(int[] nums, int target) {
		if (target == 0) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target - nums[i] >= 0) {
				res += combinationSum42(nums, target - nums[i]);
			}
		}
		return res;
	}

	// ���仯����
	public int combinationSum41(int[] nums, int target) {
		int[] memo = new int[target + 1];
		Arrays.fill(memo, -1);
		if (target == 0) {
			return 1;
		}
		memo[0] = 1;
		return combinationSum41(nums, target, memo);
	}

	private int combinationSum41(int[] nums, int target, int[] memo) {
		if (memo[target] != -1) {
			return memo[target];
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target - nums[i] >= 0) {
				res += combinationSum41(nums, target - nums[i], memo);
			}
		}
		memo[target] = res;
		return res;
	}

	// ��̬�滮
	public int combinationSum4(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			int res = 0;
			for (int j = 0; j < nums.length; j++) {
				if (i - nums[j] >= 0) {
					res += dp[i - nums[j]];
				}
			}
			dp[i] = res;
		}
		return dp[target];
	}
}
