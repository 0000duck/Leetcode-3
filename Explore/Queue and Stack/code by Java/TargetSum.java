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

	public int findTargetSumWays(int[] nums, int s) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		// Ԫ�غ�sum�ﲻ��Ŀ��ֵs��
		// Ԫ�غ�sum��Ŀ��ֵs����ż�Բ�ͬ
		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
	}

	/**
	 * s:��Ŀ��ֵ=��s+num��/ 2.
	 */

	public int subsetSum(int[] nums, int s) {
		// dp[i]��nums���Ӽ����Ŀ��ֵi�ķ�����
		int[] dp = new int[s + 1];
		// �ռ���������ֻ��1��
		dp[0] = 1;
		// ��������Ԫ��
		for (int n : nums) {
			for (int i = s; i >= n; i--) {
				// Ŀ��ֵΪi�ķ�����=��ǰ������+Ŀ��ֵΪi-n�ķ�����
				dp[i] += dp[i - n];
			}
		}
		return dp[s];
	}
}
