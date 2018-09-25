package Leetcode_840_MagicSquaresInGrid;

/*
3 x 3 �Ļ÷���һ������д� 1 �� 9 �Ĳ�ͬ���ֵ� 3 x 3 ����
����ÿ�У�ÿ���Լ������Խ����ϵĸ���֮�Ͷ���ȡ�	
����һ����������ɵ� N �� N ���������ж��ٸ� 3 �� 3 �� ���÷��� �Ӿ��󣿣�ÿ���Ӿ����������ģ���

ʾ�� 1:	
	����: [[4,3,8,4],
	      [9,5,1,9],
	      [2,7,6,2]]
	���: 1
	����: 
		������Ӿ�����һ�� 3 x 3 �Ļ÷���
		438
		951
		276
	
		����һ�����ǣ�
		384
		519
		762
	
�ܵ���˵���ڱ�ʾ���������ľ�����ֻ��һ�� 3 x 3 �Ļ÷��Ӿ���
*/
//3�׻÷��С��С��Խ��ߺͶ���15
//�м������5
//1-9
public class MagicSquaresInGrid {
	public int numMagicSquaresInside(int[][] grid) {
		// ������
		int count = 0;
		// ��ȡ�������
		int row = grid.length;
		// ��ȡ�������
		int col = grid[0].length;

		// �к���С��3
		if (row < 3 | col < 3) {
			return 0;
		} else if ((row == 3) & (col == 3)) {
			// �к��ж�Ϊ3
			if (MagicSquares(grid, 1, 1)) {
				return 1;
			} else {
				return 0;
			}
		} else if (row == 3) {
			// ��Ϊ3��ֻ����
			for (int j = 1; j < col - 1; j++) {
				if (MagicSquares(grid, 1, j)) {
					count++;
				}
			}
		} else if (col == 3) {
			// ��Ϊ3��ֻ����
			for (int i = 1; i < row - 1; i++) {
				if (MagicSquares(grid, i, 1)) {
					count++;
				}
			}
		} else {
			for (int i = 1; i < row - 1; i++) {
				for (int j = 1; j < col - 1; j++) {
					if (MagicSquares(grid, i, j)) {
						count++;
					}
				}
			}

		}

		return count;
	}

	public boolean MagicSquares(int[][] grid, int i, int j) {
		// �ж��Ƿ���3�׻÷�
		// ����ij�ǲ���5
		if (grid[i][j] != 5) {
			return false;
		}
		// �ж��Ƿ���1����10��
		int[] nums = new int[9];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if ((grid[i - 1 + x][j - 1 + y] < 1) || (grid[i - 1 + x][j - 1 + y] > 9)) {
					return false;
				} else {
					nums[grid[i - 1 + x][j - 1 + y] - 1] = grid[i - 1 + x][j - 1 + y];
				}
			}
		}
		for(int x= 0;x<9;x++) {
			if(nums[x]!=x+1) {
				return false;
			}
		}
		// �ж�ÿ��ÿ�еĺ��ǲ���15
		int sum;
		// �ж���
		for (int x = 0; x < 3; x++) {
			sum = 0;
			for (int y = 0; y < 3; y++) {
				sum += grid[i - 1 + x][j - 1 + y];
			}
			if (sum != 15) {
				return false;
			}
		}
		// �ж���
		for (int y = 0; y < 3; y++) {
			sum = 0;
			for (int x = 0; x < 3; x++) {
				sum += grid[i - 1 + x][j - 1 + y];
			}
			if (sum != 15) {
				return false;
			}
		}
		// �ж����Խ���
		sum = 0;
		for (int x = 0; x < 3; x++) {
			sum += grid[i - 1 + x][j - 1 + x];
		}
		if (sum != 15) {
			return false;
		}
		// �жϸ��Խ���
		sum = 0;
		for (int x = 0; x < 3; x++) {
			sum += grid[i - 1 + x][j + 1 - x];
		}
		if (sum != 15) {
			return false;
		}
		//
		return true;
	}
}
