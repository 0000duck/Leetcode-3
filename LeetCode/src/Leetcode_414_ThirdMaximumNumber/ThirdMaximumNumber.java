package Leetcode_414_ThirdMaximumNumber;

/*

	����һ���ǿ����飬���ش������е������������������ڣ��򷵻���������������Ҫ���㷨ʱ�临�Ӷȱ�����O(n)��

	ʾ�� 1:	
		����: [3, 2, 1]	
		���: 1	
		����: ����������� 1.
		
	ʾ�� 2:	
		����: [1, 2]	
		���: 2	
		����: ���������������, ���Է��������� 2 .
		
	ʾ�� 3:	
		����: [2, 2, 3, 1]	
		���: 1	
		����: ע�⣬Ҫ�󷵻ص������������ָ��������Ψһ���ֵ�����
		��������ֵΪ2���������Ƕ��ŵڶ���
*/
public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		// ������
		int count = 1;
		//int max;
		// �Ӵ�С�����ҵ����������
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i]<nums[j]) {
					int temp = nums[i];
					nums[i] =nums[j];
					nums[j] = temp;
				}
			}
			//��nums[1]��ʼ���
			if(i>0) {
				if(nums[i-1]!=nums[i]) {
					//max = nums[i];
					count++;
					if(count==3) {
						return nums[i];
					}				
				}
			}

		}
		
		return nums[0];
		
	}
}
