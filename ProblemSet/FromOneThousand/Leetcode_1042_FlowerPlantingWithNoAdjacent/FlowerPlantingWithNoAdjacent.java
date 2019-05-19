package Leetcode_1042_FlowerPlantingWithNoAdjacent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/*
	�� N ����԰������ 1 �� N ��ǡ���ÿ����԰�У�������������ֻ�֮һ��	
	paths[i] = [x, y] �����˻�԰ x ����԰ y ��˫��·����	
	���⣬û�л�԰�� 3 �����ϵ�·�����Խ�������뿪��	
	����ҪΪÿ����԰ѡ��һ�ֻ���ʹ��ͨ��·���������κ�������԰�еĻ������໥����ͬ��	
	��������ʽ����ѡ��ķ�����Ϊ�� answer������ answer[i] Ϊ�ڵ� (i+1) ����԰����ֲ�Ļ������ࡣ����������  1, 2, 3, 4 ��ʾ����֤���ڴ𰸡�
	
	ʾ�� 1��	
		���룺N = 3, paths = [[1,2],[2,3],[3,1]]
		�����[1,2,3]
	ʾ�� 2��	
		���룺N = 4, paths = [[1,2],[3,4]]
		�����[1,2,1,2]
	ʾ�� 3��	
		���룺N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
		�����[1,2,3,4]
	
	��ʾ��	
		1 <= N <= 10000
		0 <= paths.size <= 20000
		�����ڻ�԰�� 4 �����߸���·�����Խ�����뿪��
		��֤���ڴ𰸡�
 */
//1042. ���ڽ�ֲ��
public class FlowerPlantingWithNoAdjacent {
	public int[] gardenNoAdj(int N, int[][] paths) {
		int[] gardens = new int[N];
		// boolean[] flag = new boolean[N];
		Arrays.fill(gardens, -1);
		//
		HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
		int min = 0;
		int max = 0;
		for (int i = 0; i < paths.length; i++) {
			min = Math.min(paths[i][0], paths[i][1]);
			max = Math.max(paths[i][0], paths[i][1]);
			if (map.containsKey(min)) {
				map.get(min).add(max);
			} else {
				TreeSet<Integer> set = new TreeSet<>();
				set.add(max);
				map.put(min, set);
			}
		}

		for (int i = 1; i <= N; i++) {
			if (gardens[i - 1] == -1) {
				gardens[i - 1] = 1;
			}
			if (map.containsKey(i)) {
				for (Integer j : map.get(i)) {
					if (gardens[j - 1] == -1) {
						if (gardens[i - 1] == 1) {
							gardens[j - 1] = gardens[i - 1] + 1;
						} else {
							gardens[j - 1] = 1;
						}

					} else if (gardens[i - 1] == gardens[j - 1]) {
						if (gardens[j - 1] - 2 > 0) {
							gardens[j - 1] = 1;
						} else {
							gardens[j - 1] = gardens[i - 1] + 1;
						}
					}

				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(gardens[i]);
		}
		return gardens;
	}

	public static void main(String[] args) {
		int N = 8;

		int[][] paths = { { 1, 4 }, { 1, 5 }, { 6, 8 }, { 3, 5 }, { 7, 5 }, { 3, 2 }, { 3, 6 }, { 2, 7 }, { 7, 8 },
				{ 1, 2 }, { 4, 6 } };
		new FlowerPlantingWithNoAdjacent().gardenNoAdj(N, paths);
	}
}
