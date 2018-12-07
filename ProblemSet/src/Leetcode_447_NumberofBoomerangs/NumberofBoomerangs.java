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
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i+1; j < points.length; j++) {
				int distance = squaredistance(points[i], points[j]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
		}
		for (Integer key : map.keySet()) {
			count += map.get(key) / 2;
		}
		return count;
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
					if (squaredistance(points[i], points[j]) == squaredistance(points[i], points[k])) {
						count++;
					}
				}
			}
		}
		return count;
	}

	// ����
	public int squaredistance(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}
}
