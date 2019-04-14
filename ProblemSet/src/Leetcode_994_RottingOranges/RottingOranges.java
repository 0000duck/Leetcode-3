package Leetcode_994_RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

/*
	�ڸ����������У�ÿ����Ԫ���������������ֵ֮һ��	
		ֵ 0 ����յ�Ԫ��
		ֵ 1 �����������ӣ�
		ֵ 2 �����õ����ӡ�
		ÿ���ӣ��κ��븯�õ����ӣ��� 4 ���������ϣ����ڵ��������Ӷ��ḯ�á�
	
	����ֱ����Ԫ����û����������Ϊֹ�����뾭������С����������������ܣ����� -1�� 
	
	ʾ�� 1��	
		���룺[ 	[2,1,1],
				[1,1,0],
				[0,1,1]]
		�����4
	ʾ�� 2��	
		���룺[	[2,1,1],
				[0,1,1],
				[1,0,1]]
		�����-1
		���ͣ����½ǵ����ӣ��� 2 �У� �� 0 �У���Զ���ḯ�ã���Ϊ����ֻ�ᷢ���� 4 �������ϡ�
	ʾ�� 3��	
		���룺[[0,2]]
		�����0
		���ͣ���Ϊ 0 ����ʱ�Ѿ�û�����������ˣ����Դ𰸾��� 0 ��	 
	
	��ʾ��	
		1 <= grid.length <= 10
		1 <= grid[0].length <= 10
		grid[i][j] ��Ϊ 0��1 �� 2
 */

//994. ���õ�����
public class RottingOranges {
	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		RottingOranges ro = new RottingOranges();
		System.out.println(ro.orangesRotting(grid));

	}

	public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
			}
		}
		int res = 0;
		// ��������
		int[][] round = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		res = orangesRotting(grid, queue, round, res);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return res;
	}

	private int orangesRotting(int[][] grid, Queue<int[]> queue, int[][] round, int res) {
		int size = queue.size();
		if (size == 0) {
			return res;
		}
		// res+=1;
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			int[] cur = queue.poll();
			for (int j = 0; j < round.length; j++) {
				int x = cur[0] + round[j][0];
				int y = cur[1] + round[j][1];
				if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
					grid[x][y] = 2;
					queue.offer(new int[] { x, y });
					flag = true;
				}
			}
		}
		if (flag) {
			res += 1;
		}
		res = orangesRotting(grid, queue, round, res);
		return res;
	}

	// ����
	public int orangesRotting0(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int count_fresh = 0;
		// Put the position of all rotten oranges in queue
		// count the number of fresh oranges
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					count_fresh++;
				}
			}
		}
		// if count of fresh oranges is zero --> return 0
		if (count_fresh == 0)
			return 0;
		int count = 0;
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		// bfs starting from initially rotten oranges
		while (!queue.isEmpty()) {
			++count;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				for (int dir[] : dirs) {
					int x = point[0] + dir[0];
					int y = point[1] + dir[1];
					// if x or y is out of bound
					// or the orange at (x , y) is already rotten
					// or the cell at (x , y) is empty
					// we do nothing
					if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
						continue;
					// mark the orange at (x , y) as rotten
					grid[x][y] = 2;
					// put the new rotten orange at (x , y) in queue
					queue.offer(new int[] { x, y });
					// decrease the count of fresh oranges by 1
					count_fresh--;
				}
			}
		}
		return count_fresh == 0 ? count - 1 : -1;
	}
}
