package Leetcode_1046_LastStoneWeight;

import java.util.Comparator;
import java.util.PriorityQueue;
/*

	��һ��ʯͷ��ÿ��ʯͷ������������������
	
	ÿһ�غϣ�����ѡ���������ص�ʯͷ��Ȼ������һ����顣
	����ʯͷ�������ֱ�Ϊ x �� y���� x <= y��
	��ô����Ŀ��ܽ�����£�	
		��� x == y����ô����ʯͷ���ᱻ��ȫ���飻
		��� x != y����ô����Ϊ x ��ʯͷ������ȫ���飬������Ϊ y ��ʯͷ������Ϊ y-x��
		������ֻ��ʣ��һ��ʯͷ�����ش�ʯͷ�����������û��ʯͷʣ�£��ͷ��� 0�� 
	
	��ʾ��	
		1 <= stones.length <= 30
		1 <= stones[i] <= 1000

 */
//1046.���һ��ʯͷ������
public class LastStoneWeight {
	public static void main(String[] args) {
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		System.out.println(new LastStoneWeight().lastStoneWeight(stones));
	}

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});
		for (int i = 0; i < stones.length; i++) {
			pq.add(stones[i]);
		}
		while (pq.size() > 1) {
			int y = pq.poll();		
			int x = pq.poll();			
			if (x == y) {
				continue;
			} else {
				pq.add(y - x);
			}
		}
		if (pq.size() == 1) {			
			return pq.peek();
		} else {		
			return 0;
		}
	}
}
