package Leetcode_1029_TwoCityScheduling;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
	��˾�ƻ����� 2N �ˡ��� i �˷��� A �еķ���Ϊ costs[i][0]������ B �еķ���Ϊ costs[i][1]��	
	���ؽ�ÿ���˶��ɵ�ĳ�����е���ͷ��ã�Ҫ��ÿ�����ж��� N �˵ִ
		
	ʾ����	
		���룺[[10,20],[30,200],[400,50],[30,20]]
		�����110
		���ͣ�
		��һ����ȥ A �У�����Ϊ 10��
		�ڶ�����ȥ A �У�����Ϊ 30��
		��������ȥ B �У�����Ϊ 50��
		���ĸ���ȥ B �У�����Ϊ 20��	
		����ܷ���Ϊ 10 + 30 + 50 + 20 = 110��ÿ�����ж���һ����������ԡ�	 
	
	��ʾ��	
		1 <= costs.length <= 100
		costs.length Ϊż��
		1 <= costs[i][0], costs[i][1] <= 1000
 */

//1029. ���ص���
public class TwoCityScheduling {
	public int twoCitySchedCost(int[][] costs) {
		PriorityQueue<Integer> queueA = new PriorityQueue<>(new MyComparator());
		PriorityQueue<Integer> queueB = new PriorityQueue<>(new MyComparator());
		
		int sum = 0;		
		for (int i = 0; i < costs.length; i++) {
			if (costs[i][0] - costs[i][1] > 0) {
				//ȥB
				queueB.add(Math.abs(costs[i][0]-costs[i][1]));
			} else {
				//ȥA
				queueA.add(Math.abs(costs[i][0]-costs[i][1]));
			}
			sum+=Math.min(costs[i][0],costs[i][1]);
		}
		while(queueA.size()>costs.length/2) {
			sum+=queueA.poll();
		}
		while(queueB.size()>costs.length/2) {
			sum+=queueB.poll();
		}
		return sum;
	}
}

class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Integer arr1 = (Integer) o1;
		Integer arr2 = (Integer) o2;
		return arr1 - arr2;
	}

}