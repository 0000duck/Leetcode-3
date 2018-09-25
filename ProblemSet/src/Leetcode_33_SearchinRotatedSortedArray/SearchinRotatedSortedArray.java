package Leetcode_33_SearchinRotatedSortedArray;
/*
	���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
	( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
	����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
		
	����Լ��������в������ظ���Ԫ�ء�	
	����㷨ʱ�临�Ӷȱ����� O(log n) ����
	
	ʾ�� 1:
		����: nums = [4,5,6,7,0,1,2], target = 0
		���: 4
	
	ʾ�� 2:
		����: nums = [4,5,6,7,0,1,2], target = 3
		���: -1
*/
public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(srsa.search(nums, target));
	}
	//33. ������ת��������
    public int search(int[] nums, int target) {
    	if((nums==null)||(nums.length==0)) {
    		return -1;
    	}
    	//�������Ϊ[first,second]��ת��[second,first]
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
        	int mid = left + (right-left)/2;
        	if(nums[mid]==target) {
        		return mid;
        	}else if(nums[mid]<nums[right]) {
        		//mid���ں󲿷�
        		//mid��targetС����rightС��
        		if((nums[mid]<target)&&(nums[right]>=target)) {
        			//���ұ�
        			left = mid +1;
        		}else {
        			//�����
        			right = mid -1;
        		}
        	}else {
        		//mid����ǰ����
        		//left��targetС����mid��target��
        		if((nums[left]<=target)&&(nums[mid]>target)) {
        			//�����
        			right = mid -1;
        		}else {
        			//���ұ�
        			left = mid + 1;
        		}
        	}
        }
        return -1;
    }

}
