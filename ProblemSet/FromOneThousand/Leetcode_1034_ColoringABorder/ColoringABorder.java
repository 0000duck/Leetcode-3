package Leetcode_1034_ColoringABorder;
/*
	����һ����ά�������� grid�������е�ÿ��ֵ��ʾ��λ�ô�����������ɫ��
	ֻ�е�������������ɫ��ͬ���������ĸ�����������һ������������ʱ����������ͬһ��ͨ������
	��ͨ�����ı߽���ָ��ͨ�����е������벻�ڷ����е����������ڣ��ĸ������ϣ������������Σ�����������ı߽��ϣ���һ��/�л����һ��/�У������������Ρ�
	����λ�� (r0, c0) ����������ɫ color��ʹ��ָ����ɫ color Ϊ������������ͨ�����ı߽������ɫ�����������յ����� grid �� 
	
	ʾ�� 1��
		���룺grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
		�����[[3, 3], [3, 2]]
	ʾ�� 2��
		���룺grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
		�����[[1, 3, 3], [2, 3, 3]]
	ʾ�� 3��
		���룺grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
		�����[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
	��ʾ��
		1 <= grid.length <= 50
		1 <= grid[0].length <= 50
		1 <= grid[i][j] <= 1000
		0 <= r0 < grid.length
		0 <= c0 < grid[0].length
		1 <= color <= 1000
 */

//1034.�߿���ɫ
public class ColoringABorder {
	public static void main(String[] args) {
		int[][] grid = { { 1, 1 }, { 1, 2 } };
		int r0 = 0;
		int c0 = 0;
		int color = 3;
		new ColoringABorder().colorBorder(grid, r0, c0, color);
	}

	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] change = new boolean[n][m];
		boolean[][] used = new boolean[n][m];
		int oldcolor = grid[r0][c0];
		dfs(r0, c0, grid, oldcolor, change, used);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (change[i][j]) {
					if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
						grid[i][j] = color;
						continue;
					}
					boolean flag = change[i - 1][j] & change[i + 1][j] & change[i][j - 1] & change[i][j + 1];
					if (!flag) {
						grid[i][j] = color;
					}

				}
			}
		}
		return grid;
	}

	private void dfs(int i, int j, int[][] grid, int oldcolor, boolean[][] change, boolean[][] used) {
		
		if (!used[i][j] && grid[i][j] == oldcolor) {
			change[i][j] = true;
			used[i][j] = true;
		}else {
			used[i][j] = true;
			return;
		}

		// ����
		if (i - 1 >= 0) {
			dfs(i - 1, j, grid, oldcolor, change, used);
		}
		// ����
		if (i + 1 <= grid.length - 1) {
			dfs(i + 1, j, grid, oldcolor, change, used);
		}
		// ����
		if (j - 1 >= 0) {
			dfs(i, j - 1, grid, oldcolor, change, used);
		}
		// ����
		if (j + 1 <= grid[0].length - 1) {
			dfs(i, j + 1, grid, oldcolor, change, used);
		}

	}
}
