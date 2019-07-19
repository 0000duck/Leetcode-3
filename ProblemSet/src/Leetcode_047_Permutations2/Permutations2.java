package Leetcode_047_Permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
	����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�
	
	ʾ��:
	����:
		[1,1,2]
	���:
		[
		  [1,1,2],
		  [1,2,1],
		  [2,1,1]
		]
 */

//47. ȫ���� II
public class Permutations2 {

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	boolean[] used;

	public List<List<Integer>> permuteUnique(int[] nums) {

		if (nums == null || nums.length == 0) {
			return result;
		}
		used = new boolean[nums.length];
		Arrays.sort(nums);
		generatePermuteUnique(nums, new LinkedList<Integer>());
		return result;

	}

	private void generatePermuteUnique(int[] nums, LinkedList<Integer> list) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			// ��ֹ�ظ�
			// nums[i] == nums[i - 1] ��nums[i-1]δ�ã�˵�������ͬ
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			used[i] = true;
			generatePermuteUnique(nums, list);
			used[i] = false;
			list.removeLast();
		}

	}
}
