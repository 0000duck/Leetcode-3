package Leetcode_35_SearchInsertPosition;

/*
	����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
	����Լ������������ظ�Ԫ�ء�
	
	ʾ�� 1:	
		����: [1,3,5,6], 5
		���: 2
		
	ʾ�� 2:	
		����: [1,3,5,6], 2
		���: 1
		
	ʾ�� 3:	
		����: [1,3,5,6], 7
		���: 4
		
	ʾ�� 4:	
		����: [1,3,5,6], 0
		���: 0
*/
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		 if(target <= nums[0]) {
			 return 0;
		 }else if(target>nums[nums.length-1]) {
			 return nums.length;
		 }
		 int i;
		 for(i = 1;i<nums.length-1;i++) {
			 if((target < nums[i])&(target > nums[i-1])){
				  return i;
			 }
			 if(target == nums[i]) {
				 return i;
			 }
			 if((target > nums[i])&(target<nums[i+1])){
				 return i+1;
			 }
		 }
		 return i;
	 }
}
