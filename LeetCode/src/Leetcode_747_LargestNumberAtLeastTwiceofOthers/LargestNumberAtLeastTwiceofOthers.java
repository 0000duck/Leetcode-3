package Leetcode_747_LargestNumberAtLeastTwiceofOthers;

/*
 
	��һ������������nums�У����Ǵ���һ�����Ԫ�� ��
	���������е����Ԫ���Ƿ�������������ÿ���������ֵ�������	
	����ǣ��򷵻����Ԫ�ص����������򷵻�-1��
	
	ʾ�� 1:	
		����: nums = [3, 6, 1, 0]
		���: 1
		����: 6����������, ���������е���������,
		6��������������Ԫ�ص�������6��������1, �������Ƿ���1.	 
	
	ʾ�� 2:	
		����: nums = [1, 2, 3, 4]
		���: -1
		����: 4û�г���3��������, �������Ƿ��� -1.
*/
public class LargestNumberAtLeastTwiceofOthers {
	public int dominantIndex(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int index = 0;
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
				index = i;
			}
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}

		}
		if (nums[0] >= 2 * nums[1]) {
			return index;
		}
		return -1;
	}
}
