package Leetcode_1136_ParallelCourses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/*
	��֪�� N �ſγ̣������� 1 �� N ���б�š�
	����һ�ݿγ̹�ϵ�� relations[i] = [X, Y]�����Ա�ʾ�γ� X �Ϳγ� Y ֮������޹�ϵ���γ� X �����ڿγ� Y ֮ǰ���ꡣ
	������һ��ѧ��������ѧϰ�κ������Ŀγ̣���ǰ�������Ѿ�ѧϰ�˽�Ҫѧϰ����Щ�γ̵��������޿γ̡�
	���㷵��ѧ��ȫ���γ����������ѧ������
	���û�а취����ѧ��ȫ����Щ�γ̵Ļ����ͷ��� -1��
	
	ʾ�� 1��
		���룺N = 3, relations = [[1,3],[2,3]]
		�����2
		���ͣ�
		�ڵ�һ��ѧ��ѧϰ�γ� 1 �� 2���ڵڶ���ѧ��ѧϰ�γ� 3��
	
	ʾ�� 2��
		���룺N = 3, relations = [[1,2],[2,3],[3,1]]
		�����-1
		���ͣ�
		û�пγ̿���ѧϰ����Ϊ�����໥������
	
	��ʾ��
		1 <= N <= 5000
		1 <= relations.length <= 5000
		relations[i][0] != relations[i][1]
		������û���ظ��Ĺ�ϵ
 */

//1136.ƽ�пγ�
public class ParallelCourses {
	public int minimumSemesters(int N, int[][] relations) {
		HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();// value ���� key
		int[] relCount = new int[N + 1];
		for (int i = 0; i < relations.length; i++) {
			int[] cur = relations[i];
			relCount[cur[1]]++;
			if (map.containsKey(cur[0])) {
				map.get(cur[0]).add(cur[1]);
			} else {
				TreeSet<Integer> set = new TreeSet<>();
				set.add(cur[1]);
				map.put(cur[0], set);
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (relCount[i] == 0) {
				queue.add(i);
			}
		}
		int res = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			res++;
			for (int i = queue.size(); i > 0; i--) {
				int finishCourse = queue.poll();
				count++;
				if (map.containsKey(finishCourse)) {
					for (int nextCourse : map.get(finishCourse)) {
						if (relCount[nextCourse]-- == 1) {
							queue.add(nextCourse);
						}
					}
				}
			}

		}
		if (count < N) {
			return -1;
		}

		return res;
	}
}
