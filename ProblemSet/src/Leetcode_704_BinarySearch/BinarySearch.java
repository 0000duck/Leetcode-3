package Leetcode_704_BinarySearch;
/*
	����һ�� n ��Ԫ������ģ������������� nums ��һ��Ŀ��ֵ target  ��
	дһ���������� nums �е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��
	
	ʾ�� 1:
		����: nums = [-1,0,3,5,9,12], target = 9
		���: 4
	����: 9 ������ nums �в����±�Ϊ 4
	
	ʾ�� 2:
		����: nums = [-1,0,3,5,9,12], target = 2
		���: -1
	����: 2 ������ nums ����˷��� -1 
	
	��ʾ��
		����Լ��� nums �е�����Ԫ���ǲ��ظ��ġ�
		n ���� [1, 10000]֮�䡣
		nums ��ÿ��Ԫ�ض����� [-9999, 9999]֮�䡣
*/
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch bs = new BinarySearch();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		bs.binarySearch3(nums, target);
	}

	// ģ��1
	public int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;
		while (left <= right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		// End Condition: left > right
		return -1;
	}

	// ģ��2:���ڲ�����Ҫ���������е�ǰ��������ֱ�����ھ�������Ԫ�ػ�������
	//
	public int binarySearch2(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length;
		while (left < right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		// Post-processing:
		// End Condition: left == right
		if (left != nums.length && nums[left] == target)
			return left;
		return -1;
	}
	//ģ��3:����������Ҫ���ʵ�ǰ���������������е�ֱ�������ھ�������Ԫ�ػ�������
	public int binarySearch3(int[] nums, int target) {
	    if (nums == null || nums.length == 0)
	        return -1;

	    int left = 0;
	    int right = nums.length - 1;
	    while (left + 1 < right){
	        // Prevent (left + right) overflow
	        int mid = left + (right - left) / 2;
	        if (nums[mid] == target) {
	            return mid;
	        } else if (nums[mid] < target) {
	            left = mid;
	        } else {
	            right = mid;
	        }
	    }

	    // Post-processing:
	    // End Condition: left + 1 == right
	    if(nums[left] == target) return left;
	    if(nums[right] == target) return right;
	    return -1;
	}

}
