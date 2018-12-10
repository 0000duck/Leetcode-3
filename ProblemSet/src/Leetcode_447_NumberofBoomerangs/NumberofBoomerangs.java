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
		;
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
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (j == i)
					continue;
				int d = getDistance(points[i], points[j]);
				int tmp = map.containsKey(d) ? map.get(d) : 0;
				res += 2 * tmp;
				map.put(d, tmp + 1);
			}
			map.clear();
		}
		return res;
	}

	// ��ʱ
	public int numberOfBoomerangs2(int[][] points) {
		// ��������
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				for (int k = 0; k < points.length; k++) {
					if ((j == k) || (k == i)) {
						continue;
					}
					if (getDistance(points[i], points[j]) == getDistance(points[i], points[k])) {
						count++;
					}
				}
			}
		}
		return count;
	}

	// ����
	public int getDistance(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}
}
