package Leetcode_219_ContainsDuplicate2;

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
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// ������
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
