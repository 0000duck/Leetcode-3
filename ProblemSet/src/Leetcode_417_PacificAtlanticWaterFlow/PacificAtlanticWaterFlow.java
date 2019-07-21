package Leetcode_417_PacificAtlanticWaterFlow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
	����һ�� m x n �ķǸ�������������ʾһƬ��½�ϸ�����Ԫ��ĸ߶ȡ�
	��̫ƽ�󡱴��ڴ�½����߽���ϱ߽磬���������󡱴��ڴ�½���ұ߽���±߽硣
	�涨ˮ��ֻ�ܰ����ϡ��¡������ĸ�������������ֻ�ܴӸߵ��ͻ�����ͬ�ȸ߶���������
	���ҳ���Щˮ���ȿ�����������̫ƽ�󡱣������������������󡱵�½�ص�Ԫ�����ꡣ
	
	��ʾ��
		��������˳����Ҫ
		m �� n ��С��150
	
	ʾ����
		��������� 5x5 ����:		
			  ̫ƽ��	  ~   ~   ~   ~   ~ 
			       ~  1   2   2   3  (5) *
			       ~  3   2   3  (4) (4) *
			       ~  2   4  (5)  3   1  *
			       ~ (6) (7)  1   4   5  *
			       ~ (5)  1   1   2   4  *
			          *   *   *   *   * ������		
		����:
			[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (��ͼ�д����ŵĵ�Ԫ).
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/pacific-atlantic-water-flow
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

//417. ̫ƽ�������ˮ������
public class PacificAtlanticWaterFlow {
	int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	int n;
	int m;
	int[][] matrix;
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		this.matrix = matrix;
		this.m = matrix.length;
		this.n = matrix[0].length;

		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];

		Queue<int[]> pQueue = new LinkedList<>();
		Queue<int[]> aQueue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			pQueue.offer(new int[] { i, 0 });
			aQueue.offer(new int[] { i, n - 1 });
			pacific[i][0] = true;
			atlantic[i][n - 1] = true;
		}
		for (int i = 0; i < n; i++) {
			pQueue.offer(new int[] { 0, i });
			aQueue.offer(new int[] { m - 1, i });
			pacific[0][i] = true;
			atlantic[m - 1][i] = true;
		}
		bfs(pQueue, pacific);
		bfs(aQueue, atlantic);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j] && atlantic[i][j])
					res.add(Arrays.asList(new Integer[] { i, j }));
			}
		}
		return res;
	}

	public void bfs(Queue<int[]> queue, boolean[][] visited) {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int[] d : dir) {
				int x = cur[0] + d[0];
				int y = cur[1] + d[1];
				if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
					continue;
				}
				visited[x][y] = true;
				queue.offer(new int[] { x, y });
			}
		}
	}

	public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
		List<List<Integer>> res = new LinkedList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		this.m = matrix.length;
		this.n = matrix[0].length;
		this.matrix = matrix;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			dfs(pacific, Integer.MIN_VALUE, i, 0);
			dfs(atlantic, Integer.MIN_VALUE, i, n - 1);
		}
		for (int i = 0; i < n; i++) {
			dfs(pacific, Integer.MIN_VALUE, 0, i);
			dfs(atlantic, Integer.MIN_VALUE, m - 1, i);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					res.add(Arrays.asList(new Integer[] { i, j }));
				}
			}
		}
		return res;
	}

	public void dfs(boolean[][] visited, int height, int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < height) {
			return;
		}
		visited[x][y] = true;
		for (int[] d : dir) {
			dfs(visited, matrix[x][y], x + d[0], y + d[1]);
		}
	}
}
