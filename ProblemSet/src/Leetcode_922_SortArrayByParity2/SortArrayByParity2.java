package Leetcode_922_SortArrayByParity2;

import java.util.Arrays;

/*
	����һ���Ǹ��������� A�� A ��һ��������������һ��������ż����	
	��������������Ա㵱 A[i] Ϊ����ʱ��i Ҳ���������� A[i] Ϊż��ʱ�� i Ҳ��ż����	
	����Է����κ���������������������Ϊ�𰸡� 
	
	ʾ����	
		���룺[4,2,5,7]
		�����[4,5,2,7]
		���ͣ�[4,7,2,5]��[2,5,4,7]��[2,7,4,5] Ҳ�ᱻ���ܡ�	 
	
	��ʾ��	
		2 <= A.length <= 20000
		A.length % 2 == 0
		0 <= A[i] <= 1000
 */
public class SortArrayByParity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortArrayByParity2 sab2 = new SortArrayByParity2();
		int[] A = { 4,2,5,7 };
		sab2.sortArrayByParityII(A);
		System.out.println(Arrays.toString(A));
	}

	// 922. ����ż�������� II
	public int[] sortArrayByParityII(int[] A) {
		// iֻ�ж�ż��λ
		int j = 1;// jֻ�ж�����λ
		for (int i = 0; i < A.length - 1; i = i + 2) {
			// ���A[i]������
			if (A[i] % 2 == 1) {
				while (j < A.length) {
					// ���A[j]��ż��
					if (A[j] % 2 == 0) {
						int temp = A[i];
						A[i] = A[j];
						A[j] = temp;
						break;
					} else {
						j += 2;
					}
				}
			}
		}
		return A;
	}

	// 5ms
	public int[] sortArrayByParityII2(int[] A) {
		int j = 1;
		// ֻ�ж�ż��λ
		for (int i = 0; i < A.length - 1; i = i + 2) {
			// ���������
			if ((A[i] & 1) != 0) {
				// ֻ�ж�����λ
				while ((A[j] & 1) != 0) {
					// ���������
					j = j + 2;
				}
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		return A;
	}

}
