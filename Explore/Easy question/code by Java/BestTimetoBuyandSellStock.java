package Leetcode_121_BestTimetoBuyandSellStock;

/*
 	ֻ����һ�齻��
 	
	����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
	��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������	
	ע���㲻���������Ʊǰ������Ʊ��
	
	ʾ�� 1:	
		����: [7,1,5,3,6,4]
		���: 5
		����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
		     ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
	
	ʾ�� 2:	
		����: [7,6,4,3,1]
		���: 0
		����: �����������, û�н������, �����������Ϊ 0��
*/
//��1�������Ƕ�ÿһ��ļ۸�ͺ���ļ۸�Ƚϣ�ȡ�����ֵ��ȡ��n�����ֵ���ڴ���n�����ֵ��ȡ�����ֵ��ʱ�临�Ӷ�O��n�� 
//��2����̬�滮������ǰ���������飬��¼��ǰ���ֹ�����ͼ۸���Ϊ����۸񣬲������Ե���۸���۵����棬��Ϊ���ܵ�������棬�������������У����ֹ�����������������

public class BestTimetoBuyandSellStock {
	// �㷨1
	public int maxProfit(int[] prices) {
		// ����ĳ���
		if (prices.length < 2) {
			return 0;
		}

		int maxprofit = 0;
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				// ÿ����������
				max = Math.max(max, prices[j] - prices[i]);
			}
			if (max > maxprofit) {
				maxprofit = max;
			}
		}
		return maxprofit;
	}

	// �㷨2
	public int maxProfit2(int[] prices) {
		// ����ĳ���
		if (prices.length < 2) {
			return 0;
		}

		// �������ֵ
		int min = prices[0];
		// �����������
		int max = 0;
		// ��ǰ�����������
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return max;

	}
}
