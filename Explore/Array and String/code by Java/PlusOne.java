package Leetcode_066_PlusOne;

/*

����һ���Ǹ�������ɵķǿ����飬�ڸ����Ļ����ϼ�һ������һ���µ����顣
���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�	
����Լ���������� 0 ֮�⣬��������������㿪ͷ��

ʾ�� 1:	
	����: [1,2,3]
	���: [1,2,4]
	����: ���������ʾ���� 123��
	
ʾ�� 2:	
	����: [4,3,2,1]
	���: [4,3,2,2]
	����: ���������ʾ���� 4321��
*/
public class PlusOne {
	//66.��һ
	public int[] plusOne(int[] digits) {
		// ��ȡ���ֵ�λ��
		int length = digits.length;
		digits[length - 1]++;
		for (int i = length - 1; i >= 0; i--) {
			if (digits[i] == 10) {
				if (i == 0) {
					int[] newdigits = new int[length + 1];
					newdigits[0] = 1;
					return newdigits;
				}
				digits[i] = 0;
				digits[i - 1]++;
			}
		}
		return digits;
	}
}
