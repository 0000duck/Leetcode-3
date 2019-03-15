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
		// ��ߵĳ˻�
		int[] front = new int[nums.length];
		front[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			front[i] = front[i - 1] * nums[i];
		}
		// �ұߵĳ˻�
		int[] behind = new int[nums.length];
		behind[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			behind[i] = behind[i + 1] * nums[i];
		}
		// �������
		nums[0] = behind[1];
		nums[nums.length - 1] = front[nums.length - 2];
		for (int i = 1; i < nums.length - 1; i++) {
			nums[i] = front[i - 1] * behind[i + 1];
		}
		return nums;
	}

	// O(n) without extra space
	public int[] productExceptSelf0(int[] nums) {

		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
}
