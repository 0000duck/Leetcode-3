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
	// 76ms
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// ÿ����һ�����Ӧһ��map
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (j == i)
					continue;
				int d = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
						+ (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
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

	// O(N^2)
	public int numberOfBoomerangs3(int[][] points) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			map.clear();
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				} else {
					int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
							+ (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
					map.put(dis, map.getOrDefault(dis, 0) + 1);
				}
			}
			for (int key : map.keySet()) {
				int j = map.get(key);
				res += j * (j - 1);
			}
		}
		return res;
	}
}
