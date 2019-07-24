package Leetcode_494_TargetSum;

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
		System.out.println((5 + 3) >>> 1);
	}

	// 494. Ŀ���

	// dfs
	public int findTargetSumWays2(int[] nums, int s) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return findTargetSumWays2(0, 0, nums, s);
	}

	private int findTargetSumWays2(int index, int sum, int[] nums, int s) {
		if (index == nums.length) {
			if (sum == s) {
				return 1;
			} else {
				return 0;
			}
		}
		int res = 0;
		res += findTargetSumWays2(index + 1, sum - nums[index], nums, s);
		res += findTargetSumWays2(index + 1, sum + nums[index], nums, s);
		return res;
	}

	public int findTargetSumWays(int[] nums, int s) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		// sum<s || -sum > s
		// ��ĳ������������Ϊx
		// �����͵ľ���ֵΪy
		// ��x+y=sum,x-y=S
		// ����sum+sһ����ż����x=(sum+S)/2

		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
	}

	public int subsetSum(int[] nums, int s) {
		// dp[i]��nums���Ӽ����Ŀ��ֵi�ķ�����
		int[] dp = new int[s + 1];
		// �ռ���������ֻ��1��
		dp[0] = 1;
		// ��������Ԫ��
		for (int n : nums) {
			for (int i = s; i >= n; i--) {
				// Ŀ��ֵΪi�ķ�����=��ǰ������+Ŀ��ֵΪi-n�ķ�����
				// dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i];
				dp[i] += dp[i - n];
			}
		}
		return dp[s];
	}
}
