package Leetcode_347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
	
	ʾ�� 1:	
		����: nums = [1,1,1,2,2,3], k = 2
		���: [1,2]
	
	ʾ�� 2:	
		����: nums = [1], k = 1
		���: [1]
	˵����	
		����Լ�������� k ���Ǻ���ģ��� 1 �� k �� �����в���ͬ��Ԫ�صĸ�����
		����㷨��ʱ�临�Ӷȱ������� O(n log n) , n ������Ĵ�С��
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentElements tfe = new TopKFrequentElements();
		int[] nums = { 1 };
		int k = 1;
		tfe.topKFrequent(nums, k);
	}

	// 347. ǰK����ƵԪ��
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int value = map.get(nums[i]) + 1;
				map.put(nums[i], value);
			} else {
				map.put(nums[i], 1);
			}

		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = nums.length; i >= 1; i--) {
			for (Integer num : map.keySet()) {
				if (map.get(num) == i) {
					list.add(num);
					if (list.size() == k) {
						return list;
					}
				}
			}
		}
		return list;
	}

	// 2ms
	public List<Integer> topKFrequent0(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return null;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i : nums) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;
		}

		int[] count = new int[max - min + 1]; // �������ֳ��ֵ�Ƶ��

		for (int i : nums) {
			count[i - min]++;
		}

		int max_count = Integer.MIN_VALUE;

		for (int i : count) {
			if (i > max_count)
				max_count = i;
		}

		int[] aid = new int[max_count + 1]; // ����Ƶ����������key��

		for (int i : count) {
			if (i > 0) {
				aid[i]++;
			}
		}

		int min_count = 1;
		int curr = 0;
		for (int i = aid.length - 1; i >= 1; i--) {
			if (aid[i] > 0) {
				curr += aid[i];
				if (curr >= k) {
					min_count = i;
					break;
				}
			}
		}

		List<Integer> ans = new ArrayList<>(k);
		for (int i = 0; i < count.length; i++) {
			if (count[i] >= min_count) {
				ans.add(i + min);
			}
		}
		return ans;

	}

}
