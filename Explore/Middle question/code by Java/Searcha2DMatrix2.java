package Leetcode_240_Searcha2DMatrix2;

/*
	��дһ����Ч���㷨������ m x n ���� matrix �е�һ��Ŀ��ֵ target���þ�������������ԣ�	
	ÿ�е�Ԫ�ش������������С�
	ÿ�е�Ԫ�ش��ϵ����������С�
	
	ʾ��:	
		���о��� matrix ���£�	
			[
			  [1,   4,  7, 11, 15],
			  [2,   5,  8, 12, 19],
			  [3,   6,  9, 16, 22],
			  [10, 13, 14, 17, 24],
			  [18, 21, 23, 26, 30]
			]
	���� target = 5������ true��	
	���� target = 20������ false��
 */

//240. ������ά���� II
public class Searcha2DMatrix2 {
	public static void main(String[] args) {
		Searcha2DMatrix2 s2dm = new Searcha2DMatrix2();

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		boolean found = false;
		if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
			int row = 0;
			int col = matrix[0].length - 1;
			while (row < matrix.length && col >= 0) {
				if (matrix[row][col] == target) {
					found = true;
					break;
				} else if (matrix[row][col] > target) {
					col--;
				} else {
					row++;
				}
			}

		}
		return found;
	}
}
