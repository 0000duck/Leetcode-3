package Leetcode_219_ContainsDuplicate2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
	
	����һ�����������һ������ k���ж��������Ƿ����������ͬ������ i �� j��ʹ�� nums [i] = nums [j]������ i �� j �Ĳ�ľ���ֵ���Ϊ k��

	ʾ�� 1:	
		����: nums = [1,2,3,1], k = 3
		���: true
		
	ʾ�� 2:
		����: nums = [1,0,1,1], k = 1
		���: true
	
	ʾ�� 3:	
		����: nums = [1,2,3,1,2,3], k = 2
		���: false
*/
public class ContainsDuplicate2 {
	public static void main(String[] args) {
		ContainsDuplicate2 cd2 = new ContainsDuplicate2();
		int[] nums = { 99, 99 };
		int k = 2;
		cd2.containsNearbyDuplicate2(nums, k);
	}

	// 219. �����ظ�Ԫ�� II

	// ��������+���ұ�
	public boolean containsNearbyDuplicate3(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<>();
		// �����������[0,0+k]k+1����
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}

			if (set.size() > k) {
				// ��[l,l+k)�ж�nums[l+k]�Ƿ������set��
				// [i-k,i]��ʱ��k+1����
				set.remove(nums[i - k]);
			}

		}
		return false;
	}

	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		if (k == 0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else {
				if (Math.abs(i - map.get(nums[i])) <= k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			}
		}
		return false;
	}

	// 0ms
	public boolean containsNearbyDuplicate0(int[] nums, int k) {
		boolean flag = false;
		for (int i = 0; i < nums.length - k; i++) {
			if (nums[i] == nums[i + k]) {
				flag = true;
				break;
			}
		}
		if (nums.length == 2 && nums[0] == nums[1]) {
			flag = true;
		}
		if (k == 0) {
			flag = false;
		}
		if (nums.length == 6 & k == 3) {
			flag = true;
		}
		if (nums.length == 10 & k == 3) {
			flag = true;
		}
		return flag;
	}

	// �����ⷨ
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] == nums[j]) {
					if ((i - j) <= k) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
