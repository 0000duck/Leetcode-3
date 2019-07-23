package Leetcode_322_CoinChange;

import java.util.Arrays;

/*
	������ͬ����Ӳ�� coins ��һ���ܽ�� amount��
	��дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ�����
	���û���κ�һ��Ӳ�����������ܽ����� -1��
	
	ʾ�� 1:	
		����: coins = [1, 2, 5], amount = 11
		���: 3 
		����: 11 = 5 + 5 + 1
	ʾ�� 2:	
		����: coins = [2], amount = 3
		���: -1
	˵��:
		�������Ϊÿ��Ӳ�ҵ����������޵ġ�
 */

//322.��Ǯ�һ�
public class CoinChange {
	public static void main(String[] args) {
		new CoinChange().coinChange1(new int[] { 474, 83, 404, 3 }, 264);
	}

	// �ݹ�(��ʱ)
	int[] coins;

	public int coinChange2(int[] coins, int amount) {
		Arrays.sort(coins);
		this.coins = coins;
		if (amount <= 0) {
			return 0;
		}
		if (coins[0] > amount) {
			return -1;
		}
		return coinChange(amount);
	}

	private int coinChange(int amount) {
		if (amount == 0) {
			return 0;
		}
		int res = -1;
		for (int i = 0; i < coins.length; i++) {
			int nextAmount = amount - coins[i];
			if (nextAmount >= 0) {
				int nextcount = coinChange(nextAmount);
				if (nextcount != -1) {
					if (res == -1) {
						res = nextcount + 1;
					} else {
						res = Math.min(res, nextcount + 1);
					}
				}
			}
		}
		return res;
	}

	// ���仯����
	public int coinChange1(int[] coins, int amount) {
		Arrays.sort(coins);
		this.coins = coins;
		if (amount <= 0) {
			return 0;
		}
		if (coins[0] > amount) {
			return -1;
		}
		int[] memo = new int[amount + 1];
		Arrays.fill(memo, -2);
		return coinChange(amount, memo);

	}

	private int coinChange(int amount, int[] memo) {
		if (amount == 0) {
			return 0;
		}
		if (memo[amount] != -2) {
			return memo[amount];
		}
		int res = -1;
		for (int i = 0; i < coins.length; i++) {
			int nextAmount = amount - coins[i];
			if (nextAmount >= 0) {
				int nextcount = coinChange(nextAmount, memo);
				if (nextcount != -1) {
					if (res == -1) {
						res = nextcount + 1;
					} else {
						res = Math.min(res, nextcount + 1);
					}
				}
			}
		}
		memo[amount] = res;
		return res;
	}

	// ��̬�滮
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount < 0) {
			return -1;
		}
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			int res = -1;
			for (int j = 0; j < coins.length; j++) {
				int pre_amount = i - coins[j];
				if (pre_amount >= 0 && dp[pre_amount] != -1) {
					if (res == -1) {
						res = dp[pre_amount] + 1;
					} else {
						res = Math.min(res, dp[pre_amount] + 1);
					}
				}
			}
			dp[i] = res;
		}
		return dp[amount];
	}
}
