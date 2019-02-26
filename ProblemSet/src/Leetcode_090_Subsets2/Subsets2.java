package Leetcode_090_Subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����	
	˵�����⼯���ܰ����ظ����Ӽ���	
	ʾ��:
		����:
			[1,2,2]
		���:
			[
			  [2],
			  [1],
			  [1,2,2],
			  [2,2],
			  [1,2],
			  []
			]
 */

//90. �Ӽ� II
public class Subsets2 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		Subsets2 s2 = new Subsets2();
		s2.subsetsWithDup(nums);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backtrack(nums, result, new ArrayList<Integer>(), used, 0);
		return result;
	}

	private void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> templist, boolean[] used,
			int start) {
		result.add(new ArrayList<Integer>(templist));
		for (int i = start; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1] && !(used[i] ^ used[i - 1])) {
				continue;
			}
			used[i] = true;
			templist.add(nums[i]);
			backtrack(nums, result, templist, used, i + 1);
			used[i] = false;
			templist.remove(templist.size() - 1);
		}

	}
}
