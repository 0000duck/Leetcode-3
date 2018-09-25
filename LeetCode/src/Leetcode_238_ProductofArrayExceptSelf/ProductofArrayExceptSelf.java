package Leetcode_238_ProductofArrayExceptSelf;

/*	
	��������Ϊ n ���������� nums������ n > 1������������� output ������ output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���
	
	ʾ��:	
		����: [1,2,3,4]
		���: [24,12,8,6]
	˵��: �벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣
	
	���ף�
		������ڳ����ռ临�Ӷ�����������Ŀ�𣿣� ���ڶԿռ临�Ӷȷ�����Ŀ�ģ�������鲻����Ϊ����ռ䡣��
*/
public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 238. ��������������ĳ˻�
	public int[] productExceptSelf(int[] nums) {
		//��ߵĳ˻�
		int[] front = new int[nums.length];
		front[0] = nums[0];
		for(int i = 1;i<nums.length;i++) {
			front[i] = front[i-1]*nums[i];
		}
		//�ұߵĳ˻�
		int[] behind = new int[nums.length];
		behind[nums.length-1] = nums[nums.length-1];
		for(int i = nums.length-2;i>=0;i--) {
			behind[i] = behind[i+1]*nums[i];
		}
		//�������
		nums[0] = behind[1];
		nums[nums.length-1] = front[nums.length-2];
		for(int i = 1;i<nums.length-1;i++) {
			nums[i] = front[i-1]*behind[i+1];			
		}
		return nums;
//		��ʱ		
//		int[] result = new int[nums.length];
//		// ǰ���ֺͺ󲿷�
//		for (int i = 0; i < nums.length; i++) {
//			result[i] = 1;
//			// i��ǰ�벿��
//			for (int m = 0; m < i; m++) {
//				result[i] *= nums[m];
//			}
//			// i�ĺ�벿��
//			for (int m = i+1; m < nums.length; m++) {
//				result[i] *= nums[m];
//			}
//		}
//		return result;
	}
}
