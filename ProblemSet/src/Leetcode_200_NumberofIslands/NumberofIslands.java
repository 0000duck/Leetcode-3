package Leetcode_200_NumberofIslands;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
	����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά���񣬼��㵺���������һ������ˮ��Χ����������ͨ��ˮƽ�����ֱ���������ڵ�½�����Ӷ��ɵġ�����Լ���������ĸ��߾���ˮ��Χ��
	
	ʾ�� 1:	
		����:
			11110
			11010
			11000
			00000	
		���: 1
	
	ʾ�� 2:	
		����:
			11000
			11000
			00100
			00011	
		���: 3

 */
public class NumberofIslands {
	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
		NumberofIslands ni = new NumberofIslands();
		ni.numIslands(grid);

	}

	// 200. ����ĸ��� floodfill
	boolean[][] used;
	int m;
	int n;
	char[][] grid;
	int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		this.grid = grid;
		this.m = grid.length;
		this.n = grid[0].length;

		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !used[i][j]) {
					res++;
					dfs(i, j);
				}
			}
		}
		return res;
	}

	private void dfs(int x, int y) {
		used[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int newx = x + d[i][0];
			int newy = y + d[i][1];
			if (inArea(newx, newy) && !used[newx][newy] && grid[newx][newy] == '1') {
				dfs(newx, newy);
			}
		}
	}

	private boolean inArea(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	// ��¼��
	boolean[][] bool;

	public int numIslands1(char[][] grid) {
		int result = 0;
		if ((grid.length == 0) || (grid == null)) {
			return 0;
		}
		// ��
		int col = grid.length;
		// ��
		int row = grid[0].length;
		bool = new boolean[col][row];
		// ����
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if ((grid[i][j] == '1') && (bool[i][j])) {
					bfs(i, j, grid);
					result++;
				}
			}
		}
		return result;
	}

	private void bfs(int i, int j, char[][] grid) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] cur = { i, j };
		queue.offer(cur);
		bool[i][j] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int a = 0; a < size; a++) {
				int[] temp = queue.peek();
				int x = temp[0];
				int y = temp[1];
				// ����
				if ((x - 1 >= 0) && (!bool[x - 1][y]) && (grid[x - 1][y]) == '1') {
					int[] temp2 = { x - 1, y };
					queue.offer(temp2);
					bool[x - 1][y] = true;
				}
				// ����
				if ((y - 1 >= 0) && (!bool[x][y - 1]) && (grid[x][y - 1]) == '1') {
					int[] temp2 = { x, y - 1 };
					queue.offer(temp2);
					bool[x][y - 1] = true;
				}
				// ����
				if ((y + 1 < grid[0].length) && (!bool[x][y + 1]) && (grid[x][y + 1]) == '1') {
					int[] temp2 = { x, y + 1 };
					queue.offer(temp2);
					bool[x][y + 1] = true;
				}
				// ����
				if ((x + 1 < grid.length) && (!bool[x + 1][y]) && (grid[x + 1][y]) == '1') {
					int[] temp2 = { x + 1, y };
					queue.offer(temp2);
					bool[x + 1][y] = true;
				}
				queue.poll();
			}
		}
	}

}
