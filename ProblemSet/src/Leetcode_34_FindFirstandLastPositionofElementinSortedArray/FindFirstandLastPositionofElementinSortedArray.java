package Leetcode_34_FindFirstandLastPositionofElementinSortedArray;

import java.util.Arrays;

/*
	����һ�������������е��������� nums����һ��Ŀ��ֵ target��
	�ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�	
	����㷨ʱ�临�Ӷȱ����� O(log n) ����	
	��������в�����Ŀ��ֵ������ [-1, -1]��
	
	ʾ�� 1:	
		����: nums = [5,7,7,8,8,10], target = 8
		���: [3,4]
	
	ʾ�� 2:	
		����: nums = [5,7,7,8,8,10], target = 6
		���: [-1,-1]
*/
public class FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstandLastPositionofElementinSortedArray fflpesa = new FindFirstandLastPositionofElementinSortedArray();
		int[] nums = { 1 };
		int target = 0;
		System.out.println(Arrays.toString(fflpesa.searchRange(nums, target)));
	}

	// 34. �����������в���Ԫ�صĵ�һ�������һ��λ��
	public int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		if ((nums.length == 0) || (nums == null)) {
			return result;
		}		
		int left = 0;
		int right = nums.length - 1;		
		while (left < right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid+1;
			} else if (nums[mid] > target) {
				right = mid;
			} else {
				break;
			}
		}
		while(left<=right) {
			if((left<=nums.length-1)&&(nums[left]!=target)) {
				left++;
			}
			if((right>=0)&&(nums[right]!=target)) {
				right--;
			}
			if(left>right) {
				return result;
			}
			if((nums[left]==target)&&(nums[right]==target)) {
				result[0] = left;
				result[1] =  right ;
				return result;
			}
		}
		return result;
		
		
	}

}
