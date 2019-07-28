package Leetcode_1135_ConnectingCitiesWithMinimumCost;

import java.util.Arrays;
import java.util.Comparator;

/*
	����һ�����Ǹ����л����滮�ߣ���ͼ���� N �����У����ǰ��� 1 �� N �Ĵ����š�
	����һЩ�����ӵ�ѡ�� conections������ÿ��ѡ�� conections[i] = [city1, city2, cost]
	 ��ʾ������ city1 �ͳ��� city2 ������Ҫ�ĳɱ���
	 ��������˫��ģ�Ҳ����˵���� city1 �ͳ��� city2 ����Ҳͬ����ζ�ų��� city2 �ͳ��� city1 ��������
	
	����ʹ��ÿ�Գ��м䶼���ڽ�����������һ�����ͨ·�������ܳ���Ϊ 1 �ģ���С�ɱ���
	����С�ɱ�Ӧ��������ȫ�����Ӵ��۵��ۺϡ����������֪�����޷���ɸ������������㷵�� -1��
	
	���룺N = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
	�����6
	���ͣ�
		ѡ������ 2 ���߶������������г��У����Ǵ���ѡȡ�ɱ���С�� 2 ����
		
	���룺N = 4, conections = [[1,2,3],[3,4,4]]
	�����-1
	���ͣ� 
	��ʹ��ͨ���еıߣ�Ҳ�޷��������г��С�
	
	��ʾ��	
		1 <= N <= 10000
		1 <= conections.length <= 10000
		1 <= conections[i][0], conections[i][1] <= N
		0 <= conections[i][2] <= 10^5
		conections[i][0] != conections[i][1]
 */

//1135. ��ͳɱ���ͨ���г���
public class ConnectingCitiesWithMinimumCost {
	public int minimumCost(int N, int[][] conections) {
		int[][] map = new int[N + 1][2];
		for (int i = 0; i <= N; i++) {
			map[i][0] = i;
			map[i][1] = 1;
		}
		Arrays.sort(conections, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int res = 0;
		for (int[] cur : conections) {
			if (getF(cur[0], map) != getF(cur[1], map)) {
				addMap(cur[0], cur[1], map);
				res += cur[2];
			}
			if (map[1][1] == N) {
				return res;
			}
		}

		return -1;
	}

	private void addMap(int i, int j, int[][] map) {
		int a = getF(i, map);
		int b = getF(j, map);
		if (a != b) {
			if (a < b) {
				map[b][0] = a;
				map[a][1] += map[b][1];
			} else {
				map[a][0] = b;
				map[b][1] += map[a][1];
			}
		}

	}

	private int getF(int i, int[][] map) {
		int f = map[i][0];
		while (f != map[f][0]) {
			f = getF(f, map);
		}
		map[i][0] = f;
		return f;
	}
}
