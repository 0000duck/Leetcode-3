package Leetcode_447_NumberofBoomerangs;

import java.util.HashMap;
import java.util.Map;

/*
	����ƽ���� n �Բ�ͬ�ĵ㣬�������ڡ� ���ɵ��ʾ��Ԫ�� (i, j, k) ������ i �� j ֮��ľ���� i �� k ֮��ľ�����ȣ���Ҫ����Ԫ���˳�򣩡�	
	�ҵ����л����ڵ�����������Լ��� n ���Ϊ 500�����е�������ڱ����� [-10000, 10000] �С�
	
	ʾ��:	
		����:
			[[0,0],[1,0],[2,0]]
		
		���:
			2
	
	����:
		����������Ϊ [[1,0],[0,0],[2,0]] �� [[1,0],[2,0],[0,0]]
 */
public class NumberofBoomerangs {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		NumberofBoomerangs nb = new NumberofBoomerangs();
		int[][] points = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
		nb.numberOfBoomerangs(points);
	}

	// 447. �����ڵ�����
	public int numberOfBoomerangs(int[][] points) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (j == i) {
					continue;
				}
				int distance = getDistance(points[i], points[j]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
			for (Integer key : map.keySet()) {
				if (map.get(key) != 1) {
					count += map.get(key) * (map.get(key) - 1);
				}
			}
			map.clear();
		}
		return count;

	}

	// 76ms
	public int numberOfBoomerangs0(int[][] points) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// ÿ����һ�����Ӧһ��map
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (j == i)
					continue;
				int d = getDistance(points[i], points[j]);
				// �����������˵�������ҵ�������points[i]Ϊ��һ����map�еĵ�Ϊ�ڶ����㣬points[j]Ϊ��������
				int tmp = map.containsKey(d) ? map.get(d) : 0;
				// map�еĵ���ǰ���ں�
				res += 2 * tmp;
				map.put(d, tmp + 1);
			}
			map.clear();
		}
		return res;
	}

	// ����
	public int getDistance(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}
}
