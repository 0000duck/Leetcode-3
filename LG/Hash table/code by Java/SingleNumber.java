package Leetcode_136_SingleNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/*
	����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
	
	˵����	
		����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
	
	ʾ�� 1:	
		����: [2,2,1]
		���: 1
	ʾ�� 2:	
		����: [4,1,2,1,2]
		���: 4
 */
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1 };
		System.out.println(new SingleNumber().singleNumber(nums));
	}

	// 136. ֻ����һ�ε�����
	public int singleNumber(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				int value = hm.get(nums[i]) + 1;
				hm.put(nums[i], value);
			} else {
				hm.put(nums[i], 1);
			}
		}
		Set<Integer> set = hm.keySet();
		for (Integer key : set) {
			if (hm.get(key) == 1) {
				return key;
			}
		}
		return nums[0];

	}

	// 0ms
	public int singleNumber0(int[] nums) {
		int result = 0;
		for (int i = 0, length = nums.length; i < length; i++) {
			result ^= nums[i];
		}
		return result;
	}


	//1ˢ
	public int singleNumber2(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		// ����
		Arrays.sort(nums);
		// ����
		for (int i = 0; i < nums.length; i++) {
			// 0
			if (i == 0) {
				if (nums[i] != nums[i + 1]) {
					return nums[i];
				} else {
					i++;
				}
			}
			// nums.length-1
			if (i == nums.length - 1) {
				if (nums[i] != nums[i - 1]) {
					return nums[i];
				}
			}
			if ((nums[i - 1] != nums[i]) && (nums[i] != nums[i + 1])) {
				return nums[i];
			}
		}
		return 0;
	}

}
