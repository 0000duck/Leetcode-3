package Leetcode_1072_FlipColumnsForMaximumNumberofEqualRows;

import java.util.HashMap;
import java.util.Map;

/*
	���������� 0 �� 1 ��ɵľ��� matrix������ѡ�������������в���ת���ϵ� ÿ�� ��Ԫ�񡣷�ת�󣬵�Ԫ���ֵ�� 0 ��� 1�����ߴ� 1 ��Ϊ 0 ��	
	���ؾ���һЩ��ת����������ֵ����ȵ����������	 
	
	ʾ�� 1��	
		���룺[[0,1],[1,1]]
		�����1
		���ͣ������з�ת���� 1 ������ֵ����ȡ�
	ʾ�� 2��	
		���룺[[0,1],[1,0]]
		�����2
		���ͣ���ת��һ�е�ֵ֮�������ж�����ȵ�ֵ��ɡ�
	ʾ�� 3��	
		���룺[[0,0,0],[0,0,1],[1,1,0]]
		�����2
		���ͣ���תǰ���е�ֵ֮�󣬺���������ȵ�ֵ��ɡ� 
	
	��ʾ��	
		1 <= matrix.length <= 300
		1 <= matrix[i].length <= 300
		���� matrix[i].length �����
		matrix[i][j] Ϊ 0 �� 1
 */

//1072. ���з�ת�õ����ֵ������
public class FlipColumnsForMaximumNumberofEqualRows {
	public int maxEqualRowsAfterFlips(int[][] matrix) {
		Map<String, Integer> map = new HashMap<>();
		for (int[] row : matrix) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			for (int r : row) {
				sb1.append(r);
				sb2.append(1 - r);
			}
			String str1 = sb1.toString();
			String str2 = sb2.toString();

			map.put(str1, map.getOrDefault(str1, 0) + 1);
			map.put(str2, map.getOrDefault(str2, 0) + 1);
		}

		int res = 0;
		for (int v : map.values()) {
			res = Math.max(res, v);
		}

		return res;
	}
}
