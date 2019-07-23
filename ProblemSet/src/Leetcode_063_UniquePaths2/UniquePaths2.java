package Leetcode_063_UniquePaths2;

/*
	һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
	������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
	���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
	
	�����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
	˵����m �� n ��ֵ�������� 100��
	
	ʾ�� 1:
	����:
		[
		  [0,0,0],
		  [0,1,0],
		  [0,0,0]
		]
	���: 2
	����:
		3x3 ��������м���һ���ϰ��
		�����Ͻǵ����½�һ���� 2 ����ͬ��·����
		1. ���� -> ���� -> ���� -> ����
		2. ���� -> ���� -> ���� -> ����
*/
public class UniquePaths2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		UniquePaths2 up2 = new UniquePaths2();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int num = up2.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(num);
	}

	// 63. ��ͬ·�� II
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] dp = new int[m][n];
		if (obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		} else {
			dp[m - 1][n - 1] = 1;
		}
		// ���һ��
		for (int j = n - 2; j >= 0; j--) {
			if (obstacleGrid[m - 1][j] != 1) {
				dp[m - 1][j] = dp[m-1][j + 1];
			}
		}
		// ���һ��
		for (int i = m - 2; i >= 0; i--) {
			if (obstacleGrid[i][n - 1] != 1) {
				dp[i][n - 1] = dp[i + 1][n - 1];
			}
		}
		// ������������
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] != 1) {
					dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
				}
			}
		}
		return dp[0][0];
	}

}
