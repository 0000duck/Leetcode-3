package Leetcode_746_MinCostClimbingStairs;

/*
	�����ÿ��������Ϊһ�����ݣ��� i�����ݶ�Ӧ��һ���Ǹ�������������ֵ cost[i](������0��ʼ)��
	ÿ��������һ�������㶼Ҫ���Ѷ�Ӧ����������ֵ��Ȼ�������ѡ�������һ�����ݻ������������ݡ�
	����Ҫ�ҵ��ﵽ¥�㶥������ͻ��ѡ��ڿ�ʼʱ�������ѡ�������Ϊ 0 �� 1 ��Ԫ����Ϊ��ʼ���ݡ�
	
	ʾ�� 1:
		����: cost = [10, 15, 20]
		���: 15
	����: ��ͻ����Ǵ�cost[1]��ʼ��Ȼ�����������ɵ����ݶ���һ������15��
	
	 ʾ�� 2:
		����: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
		���: 6
	����: ��ͻ��ѷ�ʽ�Ǵ�cost[0]��ʼ�����������Щ1������cost[3]��һ������6��
	ע�⣺
		cost �ĳ��Ƚ����� [2, 1000]��
		ÿһ�� cost[i] ������һ��Integer���ͣ���ΧΪ [0, 999]��
*/
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCostClimbingStairs mccs = new MinCostClimbingStairs();
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(mccs.minCostClimbingStairs(cost));
	}

	// 746. ʹ����С������¥��
	public int minCostClimbingStairs(int[] cost) {
		// ��̬�滮
		int length = cost.length;
		int[] sumcost = new int[length + 1];
		// �ϵ�һ��̨��
		sumcost[0] = cost[0];
		// �ϵڶ���̨��
		sumcost[1] = cost[1];
		// �����̨��
		for (int i = 2; i < cost.length + 1; i++) {
			int temp = 0;
			if (i != cost.length ) {
				temp = cost[i];
			}
			// ��i-1��i��Ҫ����cost[i];
			sumcost[i] = Math.min(sumcost[i - 2], sumcost[i - 1]) + temp;
		}
		return sumcost[length];
	}
}
