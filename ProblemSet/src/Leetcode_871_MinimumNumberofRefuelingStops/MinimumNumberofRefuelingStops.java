package Leetcode_871_MinimumNumberofRefuelingStops;

/*
	������������ʻ��Ŀ�ĵأ���Ŀ�ĵ�λ�ڳ���λ�ö��� target Ӣ�ﴦ��
	��;�м���վ��ÿ�� station[i] ����һ������վ����λ�ڳ���λ�ö��� station[i][0] Ӣ�ﴦ�������� station[i][1] �����͡�
	����������������������޵ģ���������� startFuel ��ȼ�ϡ���ÿ��ʻ 1 Ӣ��ͻ��õ� 1 �����͡�
	�������������վʱ��������ͣ�������ͣ����������ʹӼ���վת�Ƶ������С�
	Ϊ�˵���Ŀ�ĵأ���������Ҫ����ͼ��ʹ����Ƕ��٣�����޷�����Ŀ�ĵأ��򷵻� -1 ��
	ע�⣺��������������վʱʣ��ȼ��Ϊ 0������Ȼ������������͡������������Ŀ�ĵ�ʱʣ��ȼ��Ϊ 0����Ȼ��Ϊ���Ѿ�����Ŀ�ĵء�
	
	ʾ�� 1��
		���룺target = 1, startFuel = 1, stations = []
		�����0
		���ͣ����ǿ����ڲ����͵�����µ���Ŀ�ĵء�
	ʾ�� 2��
		���룺target = 100, startFuel = 1, stations = [[10,100]]
		�����-1
		���ͣ������޷��ִ�Ŀ�ĵأ������޷������һ������վ��
	ʾ�� 3��
		���룺target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
		�����2
		���ͣ�
		���ǳ���ʱ�� 10 ��ȼ�ϡ�
		���ǿ������������ 10 Ӣ�ﴦ�ļ���վ������ 10 ��ȼ�ϡ������ʹ� 0 ���ӵ� 60 ����
		Ȼ�����Ǵ� 10 Ӣ�ﴦ�ļ���վ���� 60 Ӣ�ﴦ�ļ���վ������ 50 ��ȼ�ϣ���
		�������ʹ� 10 ���ӵ� 50 ����Ȼ�����ǿ����ִ�Ŀ�ĵء�
		������;��1��������վͣ�������Է��� 2 ��
	 
	
	��ʾ��	
		1 <= target, startFuel, stations[i][1] <= 10^9
		0 <= stations.length <= 500
		0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 */
public class MinimumNumberofRefuelingStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		// dp[i]��ͨ����i�μ��ͺ�ɴ��������
		int numOfGS = stations.length;
		long[] dp = new long[numOfGS + 1];
		// ����ʱ�ɴ��������
		dp[0] = startFuel;
		for (int i = 0; i < numOfGS; i++) {
			// dp[j] >= stations[i][0]������j�μ��Ϳ��Ե����i������վ,������Լ�һ���ͣ�dp[j+1]����
			for (int j = i; j >= 0 && dp[j] >= stations[i][0]; j--) {
				dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
			}
		}
		for (int i = 0; i <= numOfGS; i++) {
			if (dp[i] >= target) {
				return i;
			}
		}
		return -1;
	}
}
