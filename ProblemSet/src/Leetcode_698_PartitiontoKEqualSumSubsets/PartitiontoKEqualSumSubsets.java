package Leetcode_698_PartitiontoKEqualSumSubsets;

/*
	����һ����������  nums ��һ�������� k��
	�ҳ��Ƿ��п��ܰ��������ֳ� k ���ǿ��Ӽ������ܺͶ���ȡ�
	
	ʾ�� 1��	
		���룺 nums = [4, 3, 2, 3, 5, 2, 1], k = 4
		����� True
		˵���� �п��ܽ���ֳ� 4 ���Ӽ���5������1,4������2,3������2,3�������ܺ͡�	
	ע��:	
		1 <= k <= len(nums) <= 16
		0 < nums[i] < 10000
 */

//698. ����Ϊk����ȵ��Ӽ�
public class PartitiontoKEqualSumSubsets {
	public static void main(String[] args) {
		PartitiontoKEqualSumSubsets pkess = new PartitiontoKEqualSumSubsets();
		int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
		int k = 4;
		System.out.println(pkess.canPartitionKSubsets(nums, k));
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		int maxNum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			maxNum = Math.max(maxNum, nums[i]);
		}
		if (sum % k != 0 || maxNum > sum / k)
			return false;
		return canKSubsetsSum(nums, k, sum / k, 0, new boolean[nums.length], 0);
	}

	// nums,k,�Ӽ�Ŀ��ͣ���ǰ�ͣ�ǩ�����飬innerStart��ֹ�ظ�
	private boolean canKSubsetsSum(int[] nums, int k, int targetSum, int curSum, boolean[] visited, int innerStart) {
		// k=0 ʱ˵�����е���ֺ�
		if (k == 0) {
			return true;
		} else if (curSum > targetSum) {
			// ������
			return false;
		} else if (curSum == targetSum) {
			// �������
			// �ӵ�һ��û�б�ʹ�ù�������ʼ��
			return canKSubsetsSum(nums, k - 1, targetSum, 0, visited, 0);
		}
		for (int i = innerStart; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (canKSubsetsSum(nums, k, targetSum, curSum + nums[i], visited, i + 1)) {
					return true;
				}
				// ���ݣ������
				visited[i] = false;
			}
		}
		return false;
	}

	// ��ʱ
	public boolean canPartitionKSubsets1(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		int max = sum / k;
		for (int num : nums) {
			if (num > max) {
				return false;
			}
		}
		// DFS
		int[] bucks = new int[k];
		// boolean[] used = new boolean[nums.length];
		boolean flag = dfs(bucks, nums, max, 0);
		return flag;
	}

	private boolean dfs(int[] bucks, int[] nums, int max, int index) {
		if (index == nums.length) {
			return true;
		}
		int num = nums[index];
		boolean flag = false;
		for (int i = 0; i < bucks.length; i++) {
			if (bucks[i] + num <= max) {
				bucks[i] += num;
				flag = dfs(bucks, nums, max, index + 1);
				if (flag) {
					return true;
				} else {
					bucks[i] -= num;
				}
			}
		}
		return false;
	}
}
