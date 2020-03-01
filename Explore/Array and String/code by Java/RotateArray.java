package Leetcode_189_RotateArray;

/*

	����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����

	ʾ�� 1:	
		����: [1,2,3,4,5,6,7] �� k = 3
		���: [5,6,7,1,2,3,4]
		����:
		������ת 1 ��: [7,1,2,3,4,5,6]
		������ת 2 ��: [6,7,1,2,3,4,5]
		������ת 3 ��: [5,6,7,1,2,3,4]
		
	ʾ�� 2:	
		����: [-1,-100,3,99] �� k = 2
		���: [3,99,-1,-100]
		����: 
		������ת 1 ��: [99,-1,-100,3]
		������ת 2 ��: [3,99,-1,-100]
		
	˵��:	
		�������������Ľ�����������������ֲ�ͬ�ķ������Խ��������⡣
		Ҫ��ʹ�ÿռ临�Ӷ�Ϊ O(1) ��ԭ���㷨��
*/
public class RotateArray {
	// 189. ��ת����
	// �㷨1
	public void rotate(int[] nums, int k) {

		// ��ȡ����ĳ���
		int length = nums.length;
		if (k > length) {
			for (int i = 0; i < k; i++) {
				// ��ת1λ
				int temp = nums[length - 1];
				for (int j = length - 1; j > 0; j--) {
					nums[j] = nums[j - 1];
				}
				nums[0] = temp;
			}
		} else {
			// ���巭ת
			for (int i = 0; i < length / 2; i++) {
				int temp = nums[i];
				nums[i] = nums[length - 1 - i];
				nums[length - 1 - i] = temp;
			}
			// ǰk����ת
			for (int i = 0; i < k / 2; i++) {
				int temp = nums[i];
				nums[i] = nums[k - 1 - i];
				nums[k - 1 - i] = temp;
			}
			// ����nums.length-k����ת
			for (int i = k; i < (k + length) / 2; i++) {
				int temp = nums[i];
				nums[i] = nums[length - 1 + k - i];
				nums[length - 1 + k - i] = temp;
			}
		}

	}

	// �㷨2
	public void rotate2(int[] nums, int k) {

	}

	// �㷨3
	public void rotate3(int[] nums, int k) {

	}
}
