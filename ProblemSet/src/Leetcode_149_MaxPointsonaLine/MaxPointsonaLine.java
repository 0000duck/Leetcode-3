package Leetcode_149_MaxPointsonaLine;

import java.util.HashMap;
import java.util.Map;

import Point.Point;

/*
	����һ����άƽ�棬ƽ������ n ���㣬������ж��ٸ�����ͬһ��ֱ���ϡ�
	
	ʾ�� 1:	
		����: [[1,1],[2,2],[3,3]]
		���: 3
		����:
		^
		|
		|        o
		|     o
		|  o  
		+------------->
		0  1  2  3  4
	
	ʾ�� 2:	
		����: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
		���: 4
		����:
		^
		|
		|  o
		|     o        o
		|        o
		|  o        o
		+------------------->
		0  1  2  3  4  5  6
 */
public class MaxPointsonaLine {
	public static void main(String[] args) {
		int[][] p = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
		Point[] points = new Point[p.length];
		int i = 0;
		for (int[] temp : p) {
			int x = temp[0];
			int y = temp[1];
			points[i++] = new Point(x, y);
		}
		MaxPointsonaLine mpl = new MaxPointsonaLine();
		mpl.maxPoints(points);
	}

	// 149. ֱ�������ĵ���
	public int maxPoints(Point[] points) {
		// û�е�
		if (points == null) {
			return 0;
		}
		// 0��1��2����϶���ͬһ��ֱ����
		if (points.length <= 2) {
			return points.length;
		}
		// <��x,<��y,count>>
		// ����ͬһ���㣬�ҡ�x,��y��ͬһ����ͬһ��ֱ����
		Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
		int result = 0;

		for (int i = 0; i < points.length; i++) {
			map.clear();
			int overlap = 0;
			int max = 0;
			for (int j = i + 1; j < points.length; j++) {
				int x = points[j].x - points[i].x;// x1-x2
				int y = points[j].y - points[i].y;// y1-y2
				if (x == 0 && y == 0) {
					// �ظ�
					overlap++;
					continue;
				}
				// Լ��
				int gcd = generateGCD(x, y);
				if (gcd != 0) {
					x /= gcd;
					y /= gcd;
				}

				if (map.containsKey(x)) {
					if (map.get(x).containsKey(y)) {
						map.get(x).put(y, map.get(x).get(y) + 1);
					} else {
						map.get(x).put(y, 1);
					}
				} else {
					Map<Integer, Integer> m = new HashMap<Integer, Integer>();
					m.put(y, 1);
					map.put(x, m);
				}
				max = Math.max(max, map.get(x).get(y));
			}
			// max + �ظ��� + ����
			result = Math.max(result, max + overlap + 1);
		}
		return result;

	}

	// ��ȡ��С��Լ��
	private int generateGCD(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return generateGCD(b, a % b);
		}
	}

	// 6ms
	public int maxPoints0(Point[] points) {
		if (points.length == 0) {
			return 0;
		}
		if (points.length <= 2) {
			return points.length;
		}

		int max = 2;
		// ��һ����point[i]
		for (int i = 0; i < points.length; i++) {
			int samePosition = 0; // �ظ�λ�õĵ� ����
			int sameSlope = 1; // б����ͬ�ĵ� ����
			// ��һ����point[j]
			for (int j = i + 1; j < points.length; j++) {
				// �ж��Ƿ�Ϊ�ظ�λ�õĵ�
				long x1 = points[j].x - points[i].x;
				long y1 = points[j].y - points[i].y;
				if (x1 == 0 && y1 == 0) {
					samePosition++;
				} else {
					// �ڶ��������һ����һ����ͬһֱ����
					sameSlope++;
					// �����ҵ���ǰ��������ͬһ��ֱ���ϵĵ�
					for (int k = j + 1; k < points.length; k++) {
						// ��һ����point[k]
						long x2 = points[k].x - points[i].x;
						long y2 = points[k].y - points[i].y;
						// б����ͬ
						if (x1 * y2 == x2 * y1) {
							sameSlope++;
						}
					}
				}
				if (max < (samePosition + sameSlope)) {
					max = samePosition + sameSlope;
				}
				sameSlope = 1;
			}
		}
		return max;

	}
}
