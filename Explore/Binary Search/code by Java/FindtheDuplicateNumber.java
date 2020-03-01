package Leetcode_287_FindtheDuplicateNumber;

/*
	����һ������ n + 1 ������������ nums�������ֶ��� 1 �� n ֮�䣨���� 1 �� n������֪���ٴ���һ���ظ���������
	����ֻ��һ���ظ����������ҳ�����ظ�������
	
	ʾ�� 1:
		����: [1,3,4,2,2]
		���: 2
	ʾ�� 2:	
		����: [3,1,3,4,2]
		���: 3
	˵����	
		���ܸ���ԭ���飨����������ֻ���ģ���
		ֻ��ʹ�ö���� O(1) �Ŀռ䡣
		ʱ�临�Ӷ�С�� O(n^2) ��
		������ֻ��һ���ظ������֣��������ܲ�ֹ�ظ�����һ�Ρ�
*/
public class FindtheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindtheDuplicateNumber fdn = new FindtheDuplicateNumber();
		int[] nums = { 0, 1, 3, 4, 4 };
		System.out.println(fdn.findDuplicate(nums));
	}

	// 287. Ѱ���ظ���
	public int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			// �ö�Ӧ�����ֽ������Լ����ֶ�Ӧ��λ��
			while (nums[i] != i) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				swap(nums, i, nums[i]);
			}
		}
		return -1;
	}

	public void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

	// ��������
	public int findDuplicate2(int[] nums) {
		int result = -1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] == nums[j]) {
					return nums[i];
				}
			}
		}
		return result;
	}
}
