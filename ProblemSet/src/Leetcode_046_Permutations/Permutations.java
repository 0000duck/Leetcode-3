package Leetcode_046_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
	����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�
	
	ʾ��:	
		����: [1,2,3]
		���:
			[
			  [1,2,3],
			  [1,3,2],
			  [2,1,3],
			  [2,3,1],
			  [3,1,2],
			  [3,2,1]
			]
 */

//46. ȫ����
public class Permutations {
	List<List<Integer>> res = new ArrayList<>();
	boolean[] used;

	public List<List<Integer>> permute(int[] nums) {
		used = new boolean[nums.length];
		if (nums == null || nums.length == 0) {
			return res;
		}
		generatePermutations(nums, 0, new LinkedList<Integer>());
		return res;
	}

	private void generatePermutations(int[] nums, int index, LinkedList<Integer> list) {
		if (index == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				list.add(nums[i]);
				generatePermutations(nums, index + 1, list);
				list.removeLast();
				used[i] = false;
			}
		}

	}

}
