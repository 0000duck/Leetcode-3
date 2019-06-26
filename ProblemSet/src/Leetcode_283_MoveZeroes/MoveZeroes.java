package Leetcode_283_MoveZeroes;

/*
	����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

	ʾ��:	
		����: [0,1,0,3,12]
		���: [1,3,12,0,0]
	˵��:	
		������ԭ�����ϲ��������ܿ�����������顣
		�������ٲ���������
*/
public class MoveZeroes {
	// 283. �ƶ���
	public void moveZeroes(int[] nums) {
		// ͳ����ĸ���
		int count = 0;
		// �������飬ɾ��0
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				nums[i - count] = nums[i];
			}
		}

		// ��������
		for (int i = length - count; i < length; i++) {
			nums[i] = 0;
		}
	}

	// ��ȷ�������壬ѭ��������
	public void moveZeroes2(int[] nums) {
		// ��ȷ��������
		int i = 0;// С����
		int j = 0;// ������
		// ѭ��������
		while (j < nums.length) {
			if (nums[j] == 0) {
				j++;
			} else {
				nums[i++] = nums[j++];
			}
		}
		while (i < nums.length) {
			nums[i++] = 0;
		}
	}

	public void moveZeroes3(int[] nums) {
		// ��ȷ��������
		int i = 0;// С����
		int j = 0;// ������
		// ѭ��������
		int temp;
		while (j < nums.length) {
			if (nums[j] != 0) {
				temp = nums[i];
				nums[i++] = nums[j];
				nums[j] = temp;
			}
			j++;
		}

	}
}
