package Leetcode_941_ValidMountainArray;

/*
	����һ���������� A�����������Ч��ɽ������ͷ��� true�����򷵻� false��	
	�����ǻع�һ�£���� A ����������������ô����һ��ɽ�����飺	
		A.length >= 3
		�� 0 < i < A.length - 1 �����£����� i ʹ�ã�
			A[0] < A[1] < ... A[i-1] < A[i]
			A[i] > A[i+1] > ... > A[B.length - 1]	 
	
	ʾ�� 1��	
		���룺[2,1]
		�����false
	
	ʾ�� 2��	
		���룺[3,5,5]
		�����false
	
	ʾ�� 3��	
		���룺[0,3,2,1]
		�����true	 
	
	��ʾ��	
		0 <= A.length <= 10000
		0 <= A[i] <= 10000 
 */
public class ValidMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidMountainArray vma = new ValidMountainArray();
		int[] A = { 0, 3, 2, 1 };
		System.out.println(vma.validMountainArray(A));
	}

	// 941. ��Ч��ɽ������(4ms)
	public boolean validMountainArray(int[] A) {
		int srcIndex = 0;
		if (A == null || A.length < 3) {
			return false;
		}
		// ��ɽ
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] < A[i + 1]) {
				continue;
			}
			if (A[i] == A[i + 1]) {
				return false;
			}
			srcIndex = i;
			break;
		}
		// ����
		if (srcIndex == 0 || srcIndex == A.length - 1) {
			return false;
		}
		// ��ɽ
		for (int i = srcIndex + 1; i < A.length - 1; i++) {
			if (A[i] <= A[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// 5ms
	public boolean validMountainArray2(int[] A) {
		if (A.length < 3) {
			return false;
		}
		// �����ֵ������
		int index = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[index] <= A[i]) {
				index = i;
			}
		}
		if ((index == 0) || (index == A.length - 1)) {
			return false;
		}
		for (int i = 0; i < index; i++) {
			if (A[i] > A[i + 1]) {
				return false;
			}
		}
		for (int i = index + 1; i < A.length; i++) {
			if (A[i - 1] < A[i]) {
				return false;
			}
		}
		return true;

	}

}
