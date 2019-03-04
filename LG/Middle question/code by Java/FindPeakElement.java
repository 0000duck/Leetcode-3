package Leetcode_162_FindPeakElement;

/*
	��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�
	����һ���������� nums������ nums[i] �� nums[i+1]���ҵ���ֵԪ�ز�������������
	������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�
	
	����Լ��� nums[-1] = nums[n] = -�ޡ�
	
	ʾ�� 1:
		����: nums = [1,2,3,1]
		���: 2
	����: 
		3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
	
	ʾ�� 2:
		����: nums = [1,2,1,3,5,6,4]
		���: 1 �� 5 
	����: 
		��ĺ������Է������� 1�����ֵԪ��Ϊ 2��
	 	���߷������� 5�� ���ֵԪ��Ϊ 6��
	     
	˵��:	
		��ĽⷨӦ���� O(logN) ʱ�临�Ӷȵġ�
*/
public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement fpe = new FindPeakElement();
		int[] nums = { 1,2,3,1 };
		System.out.println(fpe.findPeakElement2(nums));
	}

	// 162. Ѱ�ҷ�ֵ
	public int findPeakElement(int[] nums) {
		// ����Ϊ1
		if (nums.length == 1) {
			return 0;
		}
		// ����Ϊ2
		if (nums.length == 2) {
			if (nums[0] > nums[1]) {
				return 0;
			} else {
				return 1;
			}
		}
		// ����>=3
		int left = 0;
		int right = nums.length-1;		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if ((mid - 1 >= 0) && (nums[mid] > nums[mid - 1]) && (mid + 1 <= nums.length - 1)
					&& (nums[mid] > nums[mid + 1])) {
				return mid;
			} else if (nums[mid] < nums[mid + 1]) {
				// mid��mid+1С����ֵ���ұ�
				if(mid+1==nums.length-1) {
					return mid+1;
				}
				left = mid + 1;
			} else {
				if (mid == 0) {
					return mid;
				}
				right = mid;
			}
		}
		//�˴�����ֵ��Ӱ����
		return left;
		
	}
	
	//ģ��3
	public int findPeakElement2(int[] nums) {
		// ����Ϊ1
		if (nums.length == 1) {
			return 0;
		}		
		int left = 0;
		int right = nums.length-1;
		if(nums[left]>nums[left+1]){
			return left;
		}
		if(nums[right]>nums[right-1]) {
			return right;
		}
		
		while(left+1<right) {			
			int mid = left + (right-left)/2;
			//mid�Ƿ�ֵ
			if((mid>0)&&(nums[mid]>nums[mid-1])&&(mid<nums.length-1)&&(nums[mid]>nums[mid+1])) {
				return mid;
			}else if(nums[mid]<nums[mid+1]) {
				left = mid;
			}else  {
				right = mid;
			}			
		}
		return left;
	}

}
