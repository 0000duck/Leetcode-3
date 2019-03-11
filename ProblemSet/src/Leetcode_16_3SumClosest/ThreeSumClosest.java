package Leetcode_16_3SumClosest;

import java.util.Arrays;

/*
	����һ������ n ������������ nums �� һ��Ŀ��ֵ target��
	�ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ���
	�������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
	
	���磬�������� nums = [-1��2��1��-4], �� target = 1.	
	�� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 8, 16, 32, 64, 128 };
		int target = 82;
		System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
	}

	// 16.��ӽ�������֮��
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = 0;
		int dis = Integer.MAX_VALUE;
		for (int x = 0; x < nums.length - 2; x++) {
			for (int y = x + 1; y < nums.length - 1; y++) {
				for (int z = y + 1; z < nums.length; z++) {
					int temp = nums[x] + nums[y] + nums[z];
					// System.out.println(nums[x] + "+" + nums[y] + "+" + nums[z] + ":" + temp);
					if (Math.abs(temp - target) <= dis) {
						sum = temp;
						dis = Math.abs(temp - target);
					} else if (temp <= target) {
						continue;
					} else {
						break;
					}
				}
				// System.out.println();
			}
		}
		return sum;
	}

	// O(n^2)
	public int threeSumClosest0(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}
}
