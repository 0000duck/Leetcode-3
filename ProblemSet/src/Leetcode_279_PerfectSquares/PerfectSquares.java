package Leetcode_279_PerfectSquares;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
	���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n��
	����Ҫ����ɺ͵���ȫƽ�����ĸ������١�
	
	ʾ�� 1:	
		����: n = 12
		���: 3 
		����: 12 = 4 + 4 + 4.
	
	ʾ�� 2:	
		����: n = 13
		���: 2
		����: 13 = 4 + 9.
 */
public class PerfectSquares {
	public static void main(String[] args) {
		int n = 12;
		PerfectSquares ps = new PerfectSquares();
		ps.numSquares1(n);
	}

	// 279. ��ȫƽ����
	
	//�ݹ� DFS(��ʱ)
	public int numSquares2(int n) {
		return getNumSquares(n,0);
	}

	private int getNumSquares(int n,int count) {
		if(n==0) {
			return count;
		}
		int res = Integer.MAX_VALUE;
		for(int i = 1;n-i*i>=0;i++) {
			res = Math.min(res, getNumSquares(n-i*i,count+1));
		}
		return res;
	}
	
	//���仯����
	public int numSquares1(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		for(int i = 1;i*i<=n;i++) {
			memo[i*i] = 1;
		}
		return getNumSquares(n,memo);
	}

	private int getNumSquares(int n, int[] memo) {
		if(memo[n]!=-1) {
			return memo[n];
		}
		int res = Integer.MAX_VALUE;
		for(int i = 1;n-i*i>=0;i++) {
			res = Math.min(res, getNumSquares(n-i*i,memo)+1);
		}
		memo[n] = res;
		return memo[n];
		
	}
	
	//��̬�滮
	public int numSquares(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1;i*i<=n;i++) {
			dp[i*i] = 1;
		}
		for(int i = 1;i<=n;i++) {			
			for(int j = 1;j*j<i;j++) {
				dp[i] = Math.min(dp[i], 1+dp[i-j*j]);
			}
		}
		return dp[n];
	}

	// ������ȱ���
	public int numSquares4(int n) {
		boolean[] used = new boolean[n + 1];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { n, 0 });
		used[n] = true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int num = temp[0];
			int step = temp[1];
			for (int i = 1;; i++) {
				int a = num - i * i;
				if (a == 0) {
					return step + 1;
				} else if (a < 0) {
					break;
				}
				if (!used[a]) {
					queue.add(new int[] { a, step + 1 });
					used[a] = true;
				}
			}
		}
		return n;
	}

	// Lagrange ��ƽ������ �κ�һ�������������Ա�ʾ�ɲ������ĸ�������ƽ��֮�͡�
	// ���ֻ��1,2,3,4�����ֿ��ܡ�
	// ���ۣ���������ƽ���Ͷ������n�������������ĸ������ɣ����ض����� n=4^a*(8^b+7)
	// 1ms
	public int numSquares0(int n) {
		while (n % 4 == 0) {
			n /= 4;
		}
		if (n % 8 == 7) // �������� ˵����4����ȫƽ��������
			return 4;
		int a = 0;
		while (a * a <= n) {
			// �ж������С������Ƿ����ͨ������ƽ�����ĺͻ�һ��ƽ�������
			int b = (int) (Math.sqrt((n - a * a)));// ���n=a^2 ��ôb=0
			// if (a * a == n)
			// return 1;
			if (a * a + b * b == n)
				// ���� a��b�з�0�ĸ�����
				return (a != 0 ? 1 : 0) + (b != 0 ? 1 : 0);
			a += 1;
		}
		return 3;
	}
}
