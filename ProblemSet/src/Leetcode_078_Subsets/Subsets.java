package Leetcode_078_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
	����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����	
	˵�����⼯���ܰ����ظ����Ӽ���	
	ʾ��:	
		����: 
			nums = [1,2,3]
		���:
			[
			  [3],
			  [1],
			  [2],
			  [1,2,3],
			  [1,3],
			  [2,3],
			  [1,2],
			  []
			]
 */

//78. �Ӽ�
public class Subsets {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		Subsets s = new Subsets();
		s.subsets0(nums);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	// 5 ms 38 MB
	List<List<Integer>> res = new ArrayList<>();
	int[] nums;

	public List<List<Integer>> subsets0(int[] nums) {
		ArrayList<Integer> kong = new ArrayList<>();
		res.add(kong);
		if (nums == null || nums.length == 0) {
			return res;
		}
		this.nums = nums;
		for (int i = 1; i <= nums.length; i++) {
			getSub(0, i, new LinkedList<Integer>());
		}
		return res;
	}

	private void getSub(int start, int count, LinkedList<Integer> list) {
		if (count == list.size()) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			getSub(i + 1, count, list);
			list.removeLast();
		}
	}
}
