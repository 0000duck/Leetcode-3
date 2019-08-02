package Leetcode_1139_Largest1BorderedSquare;

/*
	����һ�������� 0 �� 1 ��ɵĶ�ά���� grid�������ҳ��߽�ȫ���� 1 ��ɵ���� ������ ������
	�����ظ��������е�Ԫ����������������ڣ��򷵻� 0�� 
	
	ʾ�� 1��
		���룺grid = [[1,1,1],[1,0,1],[1,1,1]]
		�����9
	ʾ�� 2��
		���룺grid = [[1,1,0,0]]
		�����1
	
	��ʾ��
		1 <= grid.length <= 100
		1 <= grid[0].length <= 100
		grid[i][j] Ϊ 0 �� 1
 */

//1139.������ 1 Ϊ�߽��������
public class Largest1BorderedSquare {
	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		new Largest1BorderedSquare().largest1BorderedSquare(grid);
	}

	public int largest1BorderedSquare(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] sumOfRow = new int[m][n];
		int[][] sumOfCol = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0) {
					sumOfCol[i][j] = grid[i][j];
				} else {
					sumOfCol[i][j] = grid[i][j] + sumOfCol[i - 1][j];
				}

				if (j == 0) {
					sumOfRow[i][j] = grid[i][j];
				} else {
					sumOfRow[i][j] = grid[i][j] + sumOfRow[i][j - 1];
				}
			}
		}
		int max = Math.min(m, n);
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int l = max; l > res; l--) {
					int x = i + l - 1;
					int y = j + l - 1;

					if (x < m && y < n) {
						if (sumOfRow[i][y] - sumOfRow[i][j] + grid[i][j] == l
								&& sumOfCol[x][y] - sumOfCol[i][y] + grid[i][y] == l
								&& sumOfRow[x][y] - sumOfRow[x][j] + grid[x][j] == l
								&& sumOfCol[x][j] - sumOfCol[i][j] + grid[i][j] == l) {
							res = l;
						}
					}
				}
			}
		}
		return res * res;

	}
}
