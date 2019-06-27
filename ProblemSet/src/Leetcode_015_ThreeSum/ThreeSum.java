package Leetcode_015_ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
	����һ������ n ������������ nums��
	�ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ����
	���������������Ҳ��ظ�����Ԫ�顣
	
	ע�⣺���в����԰����ظ�����Ԫ�顣
	
	����, �������� nums = [-1, 0, 1, 2, -1, -4]��
	
	����Ҫ�����Ԫ�鼯��Ϊ��
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 */
public class ThreeSum {	

	// 15. ����֮��
	public List<List<Integer>> threeSum(int[] nums) {
		// ����
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			// ��һ����nums[i]
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				// �ж��������ǰһ�����Ƿ����
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						// ����Ҫ����������
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						// ȥ��
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						// С��Ŀ��ֵ������Ų
						lo++;
					else
						// ����Ŀ��ֵ������Ų
						hi--;
				}
			}
		}
		return res;
	}
	
	

}
