package Leetcode_153_FindMinimuminRotatedSortedArray;
/*
	���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��	
	( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��	
	���ҳ�������С��Ԫ�ء�
	
	����Լ��������в������ظ�Ԫ�ء�
	
	ʾ�� 1:
		����: [3,4,5,1,2]
		���: 1
	ʾ�� 2:	
		����: [4,5,6,7,0,1,2]
		���: 0
*/
public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//153. Ѱ����ת���������е���Сֵ
    public int findMin(int[] nums) {
        //���ֲ���,�ҵ����������Ķ˵㣬�Ƚ������˵�    	
    	int min=0;
    	int max=nums.length-1;
    	int mid = (min+max)/2;
    	while(min<max) {
    		//�м��������ߵĴ���Сֵ���ұ�
    		if(nums[mid]>nums[mid]) {
    			min = mid+1;
    		}else {
    			max
    		}
    	}
        
    }

}
