package Leetcode_1030_MatrixCellsinDistanceOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/*
	���� R �� C �еľ������еĵ�Ԫ�����������Ϊ (r, c)��
	���� 0 <= r < R �� 0 <= c < C��
	
	���⣬�����ڸþ����и�����һ������Ϊ (r0, c0) �ĵ�Ԫ��
	
	���ؾ����е����е�Ԫ������꣬������ (r0, c0) �ľ������С������˳���ţ�
	���У�����Ԫ��(r1, c1) �� (r2, c2) ֮��ľ����������پ��룬|r1 - r2| + |c1 - c2|��
	������԰��κ������������˳�򷵻ش𰸡���
	
	 
	
	ʾ�� 1��	
		���룺R = 1, C = 2, r0 = 0, c0 = 0
		�����[[0,0],[0,1]]
		���ͣ��� (r0, c0) ��������Ԫ��ľ���Ϊ��[0,1]
	ʾ�� 2��	
		���룺R = 2, C = 2, r0 = 0, c0 = 1
		�����[[0,1],[0,0],[1,1],[1,0]]
		���ͣ��� (r0, c0) ��������Ԫ��ľ���Ϊ��[0,1,1,2]
		[[0,1],[1,1],[0,0],[1,0]] Ҳ�ᱻ������ȷ�𰸡�
	ʾ�� 3��	
		���룺R = 2, C = 3, r0 = 1, c0 = 2
		�����[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
		���ͣ��� (r0, c0) ��������Ԫ��ľ���Ϊ��[0,1,1,2,2,3]
		����������ĿҪ��Ĵ�Ҳ�ᱻ��Ϊ��ȷ������ [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]�� 
	
	��ʾ��	
		1 <= R <= 100
		1 <= C <= 100
		0 <= r0 < R
		0 <= c0 < C
 */

//1030. ����˳�����о���Ԫ��
public class MatrixCellsinDistanceOrder {
	// clean
	public int[][] allCellsDistOrder0(int R, int C, int r0, int c0) {
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				list.add(new int[] { i, j });
			}
		}
		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				int diff1 = Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0);
				int diff2 = Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0);
				return diff1-diff2;
			}
		});
		int[][] res= new int[list.size()][2];
		return list.toArray(res);
	}

	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		TreeMap<Integer, ArrayList<int[]>> map = new TreeMap<>();
		int count = 0;
		int Max = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				count++;
				int temp = Math.abs(i - r0) + Math.abs(j - c0);
				Max = Math.max(Max, temp);
				if (map.containsKey(temp)) {
					map.get(temp).add(new int[] { i, j });
				} else {
					ArrayList<int[]> list = new ArrayList<>();
					list.add(new int[] { i, j });
					map.put(temp, list);
				}
			}
		}
		int[][] res = new int[count][2];
		int i = 0;
		for (Integer key : map.keySet()) {
			for (int[] arr : map.get(key)) {
				res[i][0] = arr[0];
				res[i++][1] = arr[1];
			}
		}
		return res;
	}
}
