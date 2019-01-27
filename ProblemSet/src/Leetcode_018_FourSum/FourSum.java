package Leetcode_018_FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	����һ������ n ������������ nums ��һ��Ŀ��ֵ target��
	�ж� nums ���Ƿ�����ĸ�Ԫ�� a��b��c �� d ��
	ʹ�� a + b + c + d ��ֵ�� target ��ȣ�
	�ҳ��������������Ҳ��ظ�����Ԫ�顣
	
	ע�⣺	
		���в����԰����ظ�����Ԫ�顣
	
	ʾ����	
		�������� nums = [1, 0, -1, 0, -2, 2]���� target = 0��
	
	����Ҫ�����Ԫ�鼯��Ϊ��
		[
		  [-1,  0, 0, 1],
		  [-2, -1, 1, 2],
		  [-2,  0, 0, 2]
		]
 */
public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 18. ����֮��
	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4) {
			return res;
		}

		Arrays.sort(nums);
		// ���ֵ
		int max = nums[len - 1];
		// ��Сֵ̫�����ֵ̫С
		if (4 * nums[0] > target || 4 * max < target) {
			return res;
		}

		int i;// ��һ����������i
		int z;// ��һ����nums[i]
		for (i = 0; i < len; i++) {
			z = nums[i];
			// ��ǰһ�����ظ�
			if (i > 0 && z == nums[i - 1])
				continue;
			// z̫С
			if (z + 3 * max < target)
				continue;
			// z̫��
			if (4 * z > target)
				break;
			// ����4����ͬ��z����������
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			// ������nums���ҵ�3������Ϊtarget-z,����λ��Ϊ��i+1,len-1,�ҵ������һ����z���ص�res
			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target in
	 * sorted array nums[] between indices low and high. If there are, add all of
	 * them into the ArrayList fourSumList, using fourSumList.add(Arrays.asList(z1,
	 * the three numbers))
	 */
	public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		// ���Ȳ���3
		if (low + 1 >= high) {
			return;
		}
		// ���ֵ��max
		int max = nums[high];
		// ��Сֵ̫�����ֵ̫С
		if (3 * nums[low] > target || 3 * max < target) {
			return;
		}
		int i;// �ڶ�����������
		int z;// �ڶ�����z
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			// avoid duplicate
			if (i > low && z == nums[i - 1]) {
				continue;
			}
			// z is too small
			if (z + 2 * max < target) {
				continue;
			}
			// z is too large
			if (3 * z > target) {
				break;
			}
			// z is the boundary
			if (3 * z == target) {
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}
			// ��nums��[i+1,high]�ķ�Χ���ҵ��������ĺ�Ϊtarget-z,��һ����Ϊz1,�ڶ�����Ϊz,��ӵ����fourSumList��
			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target in sorted
	 * array nums[] between indices low and high. If there are, add all of them into
	 * the ArrayList fourSumList, using fourSumList.add(Arrays.asList(z1, z2, the
	 * two numbers))
	 */
	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {
		// ���Ȳ���2
		if (low >= high) {
			return;
		}
		// ��Сֵ̫�����ֵ̫С
		if (2 * nums[low] > target || 2 * nums[high] < target) {
			return;
		}
		int i = low;// ��Сֵ������
		int j = high;// ���ֵ������
		int sum;// ����֮��
		int x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));
				// avoid duplicate
				x = nums[i];
				while (++i < j && x == nums[i])
					;
				// avoid duplicate
				x = nums[j];
				while (i < --j && x == nums[j])
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}

}
