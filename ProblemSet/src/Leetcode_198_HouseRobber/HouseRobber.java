package Leetcode_198_HouseRobber;

import java.util.Arrays;

/*
	����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�
	ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
	
	����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
	
	ʾ�� 1:	
		����: [1,2,3,1]
		���: 4
		����: ͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
		     ͵�Ե�����߽�� = 1 + 3 = 4 ��
	     
	ʾ�� 2:	
		����: [2,7,9,3,1]
		���: 12
		����: ͵�� 1 �ŷ��� (��� = 2), ͵�� 3 �ŷ��� (��� = 9)������͵�� 5 �ŷ��� (��� = 1)��
		     ͵�Ե�����߽�� = 2 + 9 + 1 = 12 ��
 */
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 198. ��ҽ���
	public int rob(int[] nums) {
		// ��ȡ���ݵ�����
		int n = nums.length;

		// 0
		if (n == 0) {
			return 0;
		}

		// ���������������洢��ǰ��͵�������ֵ
		int[] f = new int[n];

		// 1
		if (n == 1) {
			return nums[0];
		}

		// 2->����������
		int a = Math.max(nums[0], nums[1]);
		if (n == 2) {
			return a;
		}

		// nums->f nums[0]��max[0][1]
		f[0] = nums[0];
		f[1] = a;

		for (int i = 2; i < f.length; i++) {
			// i-2�Ľ���͵�i�Һ�i-1�Ľ�������ֵ
			f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
		}
		return f[n - 1];
	}

	// �ݹ飨��ʱ��
	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return rob(nums, 0);
	}

	// [i,nums.length-1]�ܻ�õ����Ƹ�
	private int rob(int[] nums, int start) {
		if (start >= nums.length) {
			return 0;
		}
		int res = Math.max(nums[start] + rob(nums, start + 2), rob(nums, start + 1));
		return res;
	}

	// ���仯����
	public int rob1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return rob(nums, 0, memo);
	}

	// [i,nums.length-1]�ܻ�õ����Ƹ�
	private int rob(int[] nums, int start, int[] memo) {
		if (start >= nums.length) {
			return 0;
		}
		if (memo[start] != -1) {
			return memo[start];
		}
		int res = Math.max(nums[start] + rob(nums, start + 2, memo), rob(nums, start + 1, memo));
		memo[start] = res;
		return res;
	}

	// ��̬�滮
	public int rob0(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int length = nums.length;
		if (length == 1) {
			return nums[0];
		}
		nums[length - 2] = Math.max(nums[length - 2], nums[length - 1]);
		for (int i = length - 3; i >= 0; i--) {
			nums[i] = Math.max(nums[i + 1], nums[i] + nums[i + 2]);
		}
		return nums[0];
	}
}
