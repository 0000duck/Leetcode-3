package Leetcode_048_RotateImage;

/*
	����һ�� n �� n �Ķ�ά�����ʾһ��ͼ��
	��ͼ��˳ʱ����ת 90 �ȡ�
	˵����
		�������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
	
	ʾ�� 1:
		���� matrix = 
		[
		  [1,2,3],
		  [4,5,6],
		  [7,8,9]
		],
		
		ԭ����ת�������ʹ���Ϊ:
		[
		  [7,4,1],
		  [8,5,2],
		  [9,6,3]
		]
		
	ʾ�� 2:
		���� matrix =
		[
		  [ 5, 1, 9,11],
		  [ 2, 4, 8,10],
		  [13, 3, 6, 7],
		  [15,14,12,16]
		], 
		
		ԭ����ת�������ʹ���Ϊ:
		[
		  [15,13, 2, 5],
		  [14, 3, 4, 1],
		  [12, 6, 8, 9],
		  [16, 7,10,11]
		]
*/
public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 48. ��תͼ��
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n == 1) {
			return;
		}
		// ת��
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		// ������
		for (int j = 0; j < n / 2; j++) {
			for (int i = 0; i < n; i++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}

	// ��ת�߿�
	public static void rotateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length <= 1) {
			return;
		}
		// n*n�ķ���
		int n = matrix.length;
		// �����м��һ���㲻�ö�
		// (i,i)��ʾ�߿�����
		for (int i = 0; i < n / 2; i++) {
			rotateEdge(matrix, i);
		}
	}

	private static void rotateEdge(int[][] matrix, int i) {
		int n = matrix.length;
		// ��i,i������>(i,n-2-i)��Ҫ�ƶ��ı߿���ƶ��켣
		for (int j = 0; j < n - 1 - 2 * i; j++) {
			int tmp = matrix[i][i + j];
			matrix[i][i + j] = matrix[n - 1 - i - j][i];
			matrix[n - 1 - i - j][i] = matrix[n - 1 - i][n - 1 - i - j];
			matrix[n - 1 - i][n - 1 - i - j] = matrix[i + j][n - 1 - i];
			matrix[i + j][n - 1 - i] = tmp;
		}
	}

}
