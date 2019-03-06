package Leetcode_322_CoinChange;

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
	public int coinChange(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		int[] dp = new int[amount + 1];// dp[sum]��ʾ��coins���sumԪ��Ҫ�����ٵ�Ӳ��
		int sum = 0;

		while (++sum <= amount) {
			int min = -1;// ��С��Ӳ����
			for (int coin : coins) {
				// coin��ǰӲ����ֵ��Ѱ��һ����Ҫ�����ٵ���ֵ
				if (sum >= coin && dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;// �����sum-coinԪ��Ҫ�����ٵ�Ӳ��+1ö
					min = min < 0 ? temp : (temp < min ? temp : min);
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
	}

}
