package Leetcode_062_UniquePaths;

/*
	һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
	������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
	���ܹ��ж�������ͬ��·����
	
	���磬��ͼ��һ��7 x 3 �������ж��ٿ��ܵ�·����
	
	˵����m �� n ��ֵ�������� 100��
	
	ʾ�� 1:
		����: m = 3, n = 2
		���: 3
	����:
		�����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
		1. ���� -> ���� -> ����
		2. ���� -> ���� -> ����
		3. ���� -> ���� -> ����
	
	ʾ�� 2:
		����: m = 7, n = 3
		���: 28
*/
public class UniquePaths {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(7, 3));
	}

	// 62. ��ͬ��·��
	public int uniquePaths(int m, int n) {
		// ������ά����
		int[][] grid = new int[m][n];
		// ��һ��ֻ��һ��·
		for (int j = 0; j < n; j++) {
			grid[0][j] = 1;
		}
		// ��һ��ֻ��һ��·
		for (int i = 0; i < m; i++) {
			grid[i][0] = 1;
		}
		// dp[i][j] = dp[i-1][j]+dp[i][j-1]
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}
		return grid[m - 1][n - 1];
	}

}
