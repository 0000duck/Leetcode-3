package Leetcode_977_SquaresofaSortedArray;

import java.util.Arrays;

/*
	����һ�����ǵݼ�˳��������������� A������ÿ�����ֵ�ƽ����ɵ������飬Ҫ��Ҳ���ǵݼ�˳������ 
	
	ʾ�� 1��
		���룺[-4,-1,0,3,10]
		�����[0,1,9,16,100]
	
	ʾ�� 2��
		���룺[-7,-3,2,3,11]
		�����[4,9,9,49,121]
	
	��ʾ��
		1 <= A.length <= 10000
		-10000 <= A[i] <= 10000
		A �Ѱ��ǵݼ�˳������
 */

//���������ƽ��
public class SquaresofaSortedArray {
	public int[] sortedSquares(int[] A) {
		// ArrayList<Integer> list = new ArrayList();
		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			result[i] = A[i] * A[i];
		}
		Arrays.sort(result);
		return result;
	}

	// O(N)
	public int[] sortedSquares0(int[] A) {
		int n = A.length;// ����
		int[] result = new int[n];
		int i = 0;// ͷָ��
		int j = n - 1;// βָ��
		for (int p = n - 1; p >= 0; p--) {
			// ����ֵԽ��ƽ��Խ��
			if (Math.abs(A[i]) > Math.abs(A[j])) {
				// ǰ��Ĵ�
				result[p] = A[i] * A[i];
				i++;
			} else {
				// ����Ĵ�
				result[p] = A[j] * A[j];
				j--;
			}
		}
		return result;
	}
}
