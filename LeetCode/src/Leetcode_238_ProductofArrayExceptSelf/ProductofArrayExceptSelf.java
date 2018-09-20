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
		
		int[] result = new int[nums.length];
		// ǰ���ֺͺ󲿷�
		for (int i = 0; i < nums.length; i++) {
			result[i] = 1;
			// i��ǰ�벿��
			for (int m = 0; m < i; m++) {
				result[i] *= nums[m];
			}
			// i�ĺ�벿��
			for (int m = i+1; m < nums.length; m++) {
				result[i] *= nums[m];
			}
		}
		return result;
	}
}
