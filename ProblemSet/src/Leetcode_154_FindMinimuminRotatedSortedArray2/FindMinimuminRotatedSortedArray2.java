package Leetcode_154_FindMinimuminRotatedSortedArray2;

/*
	���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��	
	( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
	
	���ҳ�������С��Ԫ�ء�
	
	ע�������п��ܴ����ظ���Ԫ�ء�
	
	ʾ�� 1��	
		����: [1,3,5]
		���: 1
	ʾ�� 2��	
		����: [2,2,2,0,1]
		���: 0
	˵����	
		������� Ѱ����ת���������е���Сֵ ��������Ŀ��
		�����ظ���Ӱ���㷨��ʱ�临�Ӷ��𣿻����Ӱ�죬Ϊʲô��
*/
public class FindMinimuminRotatedSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,3,1,3};
		FindMinimuminRotatedSortedArray2 fmrsa2 = new FindMinimuminRotatedSortedArray2();
		System.out.println(fmrsa2.findMin(nums));
	
	}

	// 154. Ѱ����ת���������е���Сֵ II
	public int findMin(int[] nums) {
		// ���ֲ���
		if (nums.length == 1) {
			return nums[0];
		}
		int left = 0;
		int right = nums.length - 1;
		// left<right����С���󡿣�δ������ת
		if (nums[left] < nums[right]) {
			//left<mid<right
			return nums[left];
		}
		// ������ת
		while (left <= right) {
			int mid = left + (right - left) / 2;
			//mid��rightС,mid����ǰ���󣩰��
			if (nums[mid] > nums[right]) {
				//��Сֵ���ұ�
				left = mid + 1;
			} else if(nums[mid]<nums[left]) {
				// midС��left����Сֵ����ߣ�mid���ں�С�����
				right = mid;
			}else {
				//nums[left] >= nums[right];
				//nums[mid]<=nums[right] ,nums[mid]>=nums[left]
				right--;
			}
		}
		return nums[left];
	}

}
