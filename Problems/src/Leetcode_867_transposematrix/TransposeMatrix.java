package Leetcode_867_transposematrix;

/*
	����һ������ A�� ���� A ��ת�þ���
	�����ת����ָ����������Խ��߷�ת���������������������������
	ʾ��1��
		���룺[[1,2,3],
			 [4,5,6],
			 [7,8,9]]
		�����[[1,4,7],
			[2,5,8],
			[3,6,9]]
	ʾ�� 2��
		���룺[[1,2,3],
			[4,5,6]]
		�����[[1,4],
			[2,5],
			[3,6]]
*/
public class TransposeMatrix {

	public int[][] transpose(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		int[][] C= new int[col][row];
		for (int i = 0; i < col ; i++) {
			for (int j = 0; j < row; j++) {
				C[i][j] = A[j][i];
			}
		}
		return C;
	}
	
}
