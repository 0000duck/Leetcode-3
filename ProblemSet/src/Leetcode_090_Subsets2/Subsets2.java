package Leetcode_090_Subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

	List<List<Integer>> res = new ArrayList<>();
	int[] nums;

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null || nums.length == 0) {
			res.add(new ArrayList<>());
			return res;
		}
		Arrays.sort(nums);
		this.nums = nums;

		getSubsetsWithDup(0, new LinkedList<Integer>());
		return res;
	}

	private void getSubsetsWithDup(int start, LinkedList<Integer> list) {
		res.add(new ArrayList<>(list));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			getSubsetsWithDup(i + 1, list);
			list.removeLast();
		}

	}

}
