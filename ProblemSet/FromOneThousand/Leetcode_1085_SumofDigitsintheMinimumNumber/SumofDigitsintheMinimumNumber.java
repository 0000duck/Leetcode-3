package Leetcode_1085_SumofDigitsintheMinimumNumber;

/*
	����һ�������������� A��	
	Ȼ����� S��ʹ��������� A ������С���Ǹ�Ԫ�ظ�����λ������֮�͡�	
	��󣬼��� S ���ü������� ���� �����㷵�� 0�������뷵�� 1��	 
	
	ʾ�� 1:	
		���룺[34,23,1,24,75,33,54,8]
		�����0
		���ͣ�
			��СԪ��Ϊ 1����Ԫ�ظ�����λ�ϵ�����֮�� S = 1�����������Դ�Ϊ 0��
	ʾ�� 2��	
		���룺[99,77,33,66,55]
		�����1
		���ͣ�
			��СԪ��Ϊ 33����Ԫ�ظ�����λ�ϵ�����֮�� S = 3 + 3 = 6����ż�����Դ�Ϊ 1��
	 
	��ʾ��	
		1 <= A.length <= 100
		1 <= A[i].length <= 100
 */

//1085.��СԪ�ظ���λ֮��
public class SumofDigitsintheMinimumNumber {
	public int sumOfDigits(int[] A) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			min = Math.min(A[i], min);
		}
		int sum = 0;
		while (min > 0) {
			sum += min % 10;
			min /= 10;
		}
		if (sum % 2 == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
