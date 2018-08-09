package Leetcode_561_ArrayPartition1;
//ʧ��
/*
	��������Ϊ 2n ������, ��������ǽ���Щ���ֳ� n��, 
	���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ�ô�1 �� n �� min(ai, bi) �ܺ����

	ʾ�� 1:
		����: [1,4,3,2]		
		���: 4
		����: n ���� 2, ����ܺ�Ϊ 4 = min(1, 2) + min(3, 4).
*/

public class ArrayPartition1 {
	public int arrayPairSum(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}				
			}
			if (i % 2 == 0) {
				sum += nums[i];
			}
		}
		return sum;
	}
}
