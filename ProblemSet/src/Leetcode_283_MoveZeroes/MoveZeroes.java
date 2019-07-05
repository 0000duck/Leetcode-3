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
	// �Ľ�
	public void moveZeroes0(int[] nums) {
		// ��ȷ��������
		int i = 0;// С����
		int j = 0;// ������
		// ѭ��������
		int temp;
		while (j < nums.length) {
			if (nums[j] != 0) {
				if (i != j) {
					temp = nums[i];
					nums[i++] = nums[j];
					nums[j] = temp;
				} else {
					i++;
				}
			}
			j++;
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

	// �Ľ�
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
