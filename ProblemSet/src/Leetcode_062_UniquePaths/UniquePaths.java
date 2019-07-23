package Leetcode_062_UniquePaths;

import java.util.Arrays;

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
		System.out.println(up.uniquePaths(3, 2));
	}

	// 62. ��ͬ��·��
	// �ݹ�(��ʱ)
	int m;
	int n;
	int[][] d = { { 0, 1 }, { 1, 0 } };

	private boolean isValid(int x, int y) {
		return x >= 0 && x <= m && y >= 0 && y <= n;
	}

	public int uniquePaths2(int m, int n) {
		this.m = m;
		this.n = n;
		return getPath(1, 1);

	}

	// (i,j)->(m,n)�ж�����·��
	private int getPath(int x, int y) {
		if (x == m && y == n) {
			return 1;
		}

		int res = 0;
		for (int i = 0; i < 2; i++) {
			int nextx = x + d[i][0];
			int nexty = y + d[i][1];
			if (isValid(nextx, nexty)) {
				res += getPath(nextx, nexty);
			}
		}
		return res;
	}

	// ���仯����
	public int uniquePaths1(int m, int n) {
		this.m = m;
		this.n = n;
		int[][] memo = new int[m + 1][n + 1];
		for (int[] me : memo) {
			Arrays.fill(me, -1);
		}
		return getPath(1, 1, memo);

	}

	// (i,j)->(m,n)�ж�����·��
	private int getPath(int x, int y, int[][] memo) {
		if (x == m && y == n) {
			return 1;
		}

		if (memo[x][y] != -1) {
			return memo[x][y];
		}

		int res = 0;
		for (int i = 0; i < 2; i++) {
			int nextx = x + d[i][0];
			int nexty = y + d[i][1];
			if (isValid(nextx, nexty)) {
				res += getPath(nextx, nexty, memo);
			}
		}
		memo[x][y] = res;
		return res;
	}

	// ��̬�滮
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		// ���һ��
		for (int j = n; j >= 1; j--) {
			dp[m][j] = 1;
		}
		// ���һ��
		for (int i = m; i >= 1; i--) {
			dp[i][n] = 1;
		}

		// dp(i,j) = dp(i+1,j)+dp(i,j+1)
		for (int i = m - 1; i >= 1; i--) {
			for (int j = n - 1; j >= 1; j--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}
		return dp[1][1];
	}

	// 0ms:һάdp����
	public int uniquePaths0(int m, int n) {
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[j] = res[j] + res[j - 1];
			}
		}
		return res[n - 1];
	}

}
