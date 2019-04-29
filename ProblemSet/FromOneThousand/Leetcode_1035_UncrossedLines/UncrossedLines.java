package Leetcode_1035_UncrossedLines;

/*
	����������������ˮƽ���ϰ�������˳��д�� A �� B �е�������
	
	���ڣ����ǿ��Ի���һЩ������������ A[i] �� B[j] ��ֱ�ߣ�
	ֻҪ A[i] == B[j]�������ǻ��Ƶ�ֱ�߲����κ��������ߣ���ˮƽ�ߣ��ཻ��
	
	�����ַ����������������������ǿ��Ի��Ƶ������������
	
	 
	
	ʾ�� 1��	
		���룺A = [1,4,2], B = [1,2,4]
		�����2
		���ͣ�
		���ǿ��Ի���������������ߣ�����ͼ��ʾ��
		�����޷��������������ཻ��ֱ�ߣ���Ϊ�� A[1]=4 �� B[2]=4 ��ֱ�߽���� A[2]=2 �� B[1]=2 ��ֱ���ཻ��
	ʾ�� 2��	
		���룺A = [2,5,1,2,5], B = [10,5,2,1,5,2]
		�����3
	ʾ�� 3��	
		���룺A = [1,3,7,1,7,5], B = [1,9,2,5,1]
		�����2 
	
	��ʾ��	
		1 <= A.length <= 500
		1 <= B.length <= 500
		1 <= A[i], B[i] <= 2000
 */

//1035.���ཻ����
public class UncrossedLines {
	public static void main(String[] args) {
		int[] A = { 1, 4, 2 };
		int[] B = { 1, 2, 4 };
		new UncrossedLines().maxUncrossedLines(A, B);
	}

	public int maxUncrossedLines(int[] A, int[] B) {
		int len1 = A.length;
		int len2 = B.length;
		// (i,j) A��i������B��j��������ɵ����Ĳ��ཻ����
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				int tem = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, tem);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], tem);
				}
			}
		}
		return dp[len1][len2];
	}

}
