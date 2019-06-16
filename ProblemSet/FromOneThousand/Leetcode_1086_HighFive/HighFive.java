package Leetcode_1086_HighFive;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
	����һ����ͬѧ���ķ����б��밴 ѧ���� id ˳�� ����ÿ��ѧ�� ��ߵ���� �ɼ��� ƽ���֡�	
	����ÿ�� items[i] ��¼�� items[i][0] Ϊѧ���� id��items[i][1] Ϊѧ���ķ�����ƽ��������������������㡣	 
	
	ʾ����	
		���룺[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
		�����[[1,87],[2,88]]
		���ͣ�
		id = 1 ��ѧ��ƽ����Ϊ 87��
		id = 2 ��ѧ��ƽ����Ϊ 88.6������������������Ե�ʣ�ƽ���ֻᱻת��Ϊ 88�� 
	
	��ʾ��	
		1 <= items.length <= 1000
		items[i].length == 2
		ѧ���� ID �� 1 �� 1000 ֮��
		ѧ���ķ����� 1 �� 100 ֮��
		ÿ��ѧ���������������
 */
//1086. ǰ��Ƶľ���
public class HighFive {
	public int[][] highFive(int[][] items) {
		Arrays.sort(items, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// return 0;
				int a = o1[0] - o2[0];
				int b = (a == 0 ? o2[1] - o1[1] : a);
				return b;
			}
		});

		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int[] item : items) {
			int id = item[0];
			int score = item[1];
			if (map.containsKey(id) && count < 5) {
				count++;
				map.put(id, map.get(id) + score);
			} else if (!map.containsKey(id)) {
				count = 1;
				map.put(id, score);
			}
		}

		int[][] res = new int[map.keySet().size()][2];
		int i = 0;
		for (int key : map.keySet()) {
			res[i][0] = key;
			res[i++][1] = map.get(key) / 5;
		}
		return res;
	}
}
