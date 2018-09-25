package Leetcode_628_MaximumProductofThreeNumbers;

/*
	����һ���������飬���������ҳ�����������ɵ����˻������������˻���
	
	ʾ�� 1:	
		����: [1,2,3]
		���: 6
		
	ʾ�� 2:	
		����: [1,2,3,4]
		���: 24
		
	ע��:	
		�������������鳤�ȷ�Χ��[3,104]�����������е�Ԫ�ط�Χ��[-1000, 1000]��
		����������������������ĳ˻����ᳬ��32λ�з��������ķ�Χ��
*/
public class MaximumProductofThreeNumbers {
	public int maximumProduct(int[] nums) {
		//����������������С��������������������
		//�ҵ�����������
		for(int i = 0;i<3;i++) {
			for(int j =i+1;j<nums.length;j++) {
				if(nums[i]<nums[j]) {
					int temp = nums[i];
					nums[i]= nums[j];
					nums[j]= temp;
				}
			}
		}
		//�ҵ���С����������
		for(int i = nums.length-1;i>nums.length-3;i--) {
			for(int j = i-1;j>=0;j-- ) {
				if(nums[i]>nums[j]) {
					int temp = nums[i];
					nums[i]= nums[j];
					nums[j]= temp;
				}
			}
		}
		
		return Math.max(nums[0]*nums[1]*nums[2], nums[0]*nums[nums.length-2]*nums[nums.length-1]);
	}
}
