package Leetcode_059_SpiralMatrix2;

/*
	����һ�������� n������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���
	ʾ��
		����: 3
		���:
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]
 */
public class SpiralMatrix2 {
	public static void main(String[] args) {
		SpiralMatrix2 sm2 = new SpiralMatrix2();
		sm2.generateMatrix(3);
	}

	// 59.�������� II
	public int[][] generateMatrix(int n) {
		// ������ά���
		int[][] result = new int[n][n];
		// �߽�ֵ
		int rowbegin = 0;
		int rowend = n - 1;
		int colbegin = 0;
		int colend = n - 1;
		// ��ʼֵ
		int num = 1;
		while (num <= n * n) {
			// �в���������(��)
			for (int j = colbegin; j <= colend; j++) {
				result[rowbegin][j] = num;
				num++;
			}
			// ��ʼ������
			rowbegin++;
			// �в���������(��)
			for (int i = rowbegin; i <= rowend; i++) {
				result[i][colend] = num;
				num++;
			}
			// �����м���
			colend--;
			// �в����м���(��)
			for (int j = colend; j >= colbegin; j--) {
				result[rowend][j] = num;
				num++;
			}
			// �����м���
			rowend--;
			// �в����м���
			for (int i = rowend; i >= rowbegin; i--) {
				result[i][colbegin] = num;
				num++;
			}
			// ��ʼ������
			colbegin++;
		}

		return result;
	}

	//
	public int[][] generateMatrix0(int n) {
		// Declaration
		int[][] matrix = new int[n][n];

		// Edge Case
		if (n == 0) {
			return matrix;
		}

		// Normal Case
		int rowStart = 0;// ��ͷ
		int rowEnd = n - 1;// ��β
		int colStart = 0;// ��ͷ
		int colEnd = n - 1;// ��β
		int num = 1; // change

		while (rowStart <= rowEnd && colStart <= colEnd) {
			// ����
			for (int i = colStart; i <= colEnd; i++) {
				matrix[rowStart][i] = num++; // change
			}
			rowStart++;// ��ͷ����
			// ����
			for (int i = rowStart; i <= rowEnd; i++) {
				matrix[i][colEnd] = num++; // change
			}
			colEnd--;// ��β��ǰ
			// ����
			for (int i = colEnd; i >= colStart; i--) {
				if (rowStart <= rowEnd)
					matrix[rowEnd][i] = num++; // change
			}
			rowEnd--;// ��β����
			// ����
			for (int i = rowEnd; i >= rowStart; i--) {
				if (colStart <= colEnd)
					matrix[i][colStart] = num++; // change
			}
			colStart++;// ��ͷ���
		}

		return matrix;
	}

}
