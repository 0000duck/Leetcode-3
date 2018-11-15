package Leetcode_561_ArrayPartition1;

import java.util.Arrays;

/*
	��������Ϊ 2n ������, ��������ǽ���Щ���ֳ� n��, 
	���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ�ô�1 �� n �� min(ai, bi) �ܺ����

	ʾ�� 1:
		����: [1,4,3,2]		
		���: 4
		����: n ���� 2, ����ܺ�Ϊ 4 = min(1, 2) + min(3, 4).
*/

public class ArrayPartition1 {
	public static void main(String[] args) {
		ArrayPartition1 ap = new ArrayPartition1();
		int[] nums = { 1, 4, 3, 2 };
		System.out.println(ap.arrayPairSum(nums));
	}
	//561. ������ I
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] >= nums[i + 1]) {
				sum += nums[i + 1];
			} else {
				sum += nums[i];
			}
			i++;
		}
		return sum;
	}
}
