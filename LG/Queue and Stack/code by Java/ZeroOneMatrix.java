package Leetcode_542_01Matrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import UsualMethod.ArrayUtil;

/*
	����һ���� 0 �� 1 ��ɵľ����ҳ�ÿ��Ԫ�ص������ 0 �ľ��롣
	
	��������Ԫ�ؼ�ľ���Ϊ 1 ��
	
	ʾ�� 1: 
		����:	
			0 0 0
			0 1 0
			0 0 0
		���:		
			0 0 0
			0 1 0
			0 0 0
		
	ʾ�� 2: 
		����:		
			0 0 0
			0 1 0
			1 1 1
		���:		
			0 0 0
			0 1 0
			1 2 1
		
	ע��:		
		���������Ԫ�ظ��������� 10000��
		����������������һ��Ԫ���� 0��
		�����е�Ԫ��ֻ���ĸ�����������: �ϡ��¡����ҡ�
 */
public class ZeroOneMatrix {
	public static void main(String[] args) {
		ZeroOneMatrix zom = new ZeroOneMatrix();
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		zom.updateMatrix(matrix);
		ArrayUtil.ArrayOutput(matrix);

	}

	// 542. 01 ����
	public int[][] updateMatrix(int[][] matrix) {
		// ��
		int m = matrix.length;
		// ��
		int n = matrix[0].length;
		// ����+BFS
		Queue<int[]> queue = new LinkedList<int[]>();
		// ����
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 0��ӣ�1��Ϊ���ֵ
				if (matrix[i][j] == 0) {
					queue.offer(new int[] { i, j });
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		// ���ϣ����£���������
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int[] d : dirs) {
				int r = cur[0] + d[0];
				int c = cur[1] + d[1];
				// ���������ϡ��¡����ҵ��ھӽڵ�[r][c]���ھӽڵ�Ϊ�Ѹ�ֵ
				if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[cur[0]][cur[1]] + 1) {
					continue;
				}
				// �����ھӽڵ�[r][c]���ھӽڵ�Ϊ1
				queue.add(new int[] { r, c });
				matrix[r][c] = matrix[cur[0]][cur[1]] + 1;
			}
		}

		return matrix;
	}

}
