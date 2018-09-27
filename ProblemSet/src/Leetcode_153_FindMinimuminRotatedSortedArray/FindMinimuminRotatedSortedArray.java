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
		FindMinimuminRotatedSortedArray fmrsa = new FindMinimuminRotatedSortedArray();
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(fmrsa.findMin(nums));
	}

	// 153. Ѱ����ת���������е���Сֵ
	//right�Ǻ��ε����ֵ
	//left��ǰ��ε���Сֵ
	//����С������ʱС���е�ÿһ��ֵ ���ȴ������СֵС��left(�������Сֵ),right(С������ֵ),rightһ����leftһ����С��
	//��С����leftһ����rightһ����С
	public int findMin(int[] nums) {
		// ���ֲ���
		if (nums.length == 1) {
			return nums[0];
		}
		int left = 0;
		int right = nums.length - 1;
		//left<right����С����
		if(nums[left]<nums[right]) {
			return nums[left];
		}		
		//[��С]		
		while (left < right) {
			int mid = left + (right - left) / 2;
			//mid>left,mid���ڴ�
			if(nums[mid]>nums[right]) {
				//��Сֵ����
				left = mid +1;
			}else {
				//���ֵ����
				right = mid;
			}
		}
		return nums[left];

	}

}
