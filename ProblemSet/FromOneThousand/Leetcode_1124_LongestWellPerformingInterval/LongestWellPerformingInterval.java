package Leetcode_1124_LongestWellPerformingInterval;

/*
	����һ�ݹ���ʱ��� hours�������¼��ĳһλԱ��ÿ��Ĺ���Сʱ����	
	������Ϊ��Ա��һ���еĹ���Сʱ������ 8 Сʱ��ʱ����ô��һ����ǡ����۵�һ�졹��	
	��ν���������õ�ʱ��Ρ�����ζ�����ʱ���ڣ������۵����������ϸ� ���ڡ������۵���������	
	���㷵�ء���������ʱ��Ρ�����󳤶ȡ�	 
	
	ʾ�� 1��	
		���룺hours = [9,9,6,0,6,6,9]
		�����3
		���ͣ���ı�������ʱ����� [9,9,6]��
	 
	
	��ʾ��	
		1 <= hours.length <= 10000
		0 <= hours[i] <= 16
 */
//1124.�������õ��ʱ���
public class LongestWellPerformingInterval {
	// ��ʱ
	public int longestWPI2(int[] hours) {
		int[] dp = new int[hours.length];
		for (int i = 0; i < hours.length; i++) {
			int tired = 0;
			int normal = 0;
			for (int j = i; j >= 0; j--) {
				if (hours[j] > 8) {
					tired++;
				} else {
					normal++;
				}
				if (tired > normal) {
					dp[i] = Math.max(dp[i], i - j + 1);
				}
			}
		}
		int res = 0;
		for (int i : dp) {
			res = Math.max(i, res);
		}
		return res;
	}

	public int longestWPI(int[] hours) {
		int len = hours.length;
		int[] sum = new int[len + 1];

		// sum[i] : 0-i��sum[i]�쳬��8Сʱ
		for (int i = 0; i < len; i++) {
			sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : 0);
		}

		for (int k = len; k > 0; k--) {
			for (int i = len; i - k >= 0; i--) {
				// [i-k+1,i] ��k��һ������
				if (sum[i] - sum[i - k] > k / 2) {
					return k;
				}
			}
		}
		return 0;
	}
}
