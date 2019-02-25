package Leetcode_516_LongestPalindromicSubsequence;

/*
	����һ���ַ���s���ҵ�������Ļ��������С����Լ���s����󳤶�Ϊ1000��
	
	ʾ�� 1:
		����:	
			"bbbab"
		���:	
			4
		һ�����ܵ������������Ϊ "bbbb"��
	
	ʾ�� 2:
		����:	
			"cbbd"
		���:	
			2
		һ�����ܵ������������Ϊ "bb"��
 */

//516.��Ļ���������
public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String s = "bbbab";
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		lps.longestPalindromeSubseq0(s);
	}

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int l = 1; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1;
				if (i == j) {
					dp[i][j] = 1;
					continue;
				}
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}

	// dp��ά
	public int longestPalindromeSubseq0(String s) {
		int n = s.length();
		int[] dp0 = new int[n];// ����Ϊl�Ľ⣬
		int[] dp1 = new int[n];// ����Ϊl-1�Ľ�
		int[] dp2 = new int[n];// ����Ϊl-2�Ľ�

		for (int l = 1; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1;
				if (i == j) {
					dp0[i] = 1;// dp0[i],��ʼλ��Ϊi������Ϊl�Ľ�
					continue;
				}
				if (s.charAt(i) == s.charAt(j)) {
					dp0[i] = dp2[i + 1] + 2;
				} else {
					dp0[i] = Math.max(dp1[i + 1], dp1[j - 1]);
				}
			}
			swap(dp2, dp1);
			swap(dp1, dp0);
		}
		return dp1[0];
	}

	private void swap(int[] dp0, int[] dp1) {
		for (int i = 0; i < dp0.length; i++) {
			int temp = dp0[i];
			dp0[i] = dp1[i];
			dp1[i] = temp;
		}
	}
}
