package Leetcode_435_NonoverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

/*
	����һ������ļ��ϣ��ҵ���Ҫ�Ƴ��������С������ʹʣ�����以���ص���
	
	ע��:	
		������Ϊ������յ����Ǵ���������㡣
		���� [1,2] �� [2,3] �ı߽��໥���Ӵ�������û���໥�ص���
	ʾ�� 1:	
		����: [ [1,2], [2,3], [3,4], [1,3] ]	
		���: 1	
		����: �Ƴ� [1,3] ��ʣ�µ�����û���ص���
	ʾ�� 2:	
		����: [ [1,2], [1,2], [1,2] ]	
		���: 2	
		����: ����Ҫ�Ƴ����� [1,2] ��ʹʣ�µ�����û���ص���
	ʾ�� 3:	
		����: [ [1,2], [2,3] ]	
		���: 0	
		����: �㲻��Ҫ�Ƴ��κ����䣬��Ϊ�����Ѿ������ص����ˡ�
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/non-overlapping-intervals
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NonoverlappingIntervals {
	// ��̬�滮(�����������)
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
		// dp[i] =
		int[] dp = new int[intervals.length];
		Arrays.fill(dp, 1);
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < i; j++) {
				if (intervals[j][1] <= intervals[i][0]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int res = 1;
		for (int d : dp) {
			res = Math.max(d, res);
		}
		return intervals.length - res;
	}

	// ̰�� �������������
	public int eraseOverlapIntervals2(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1] == 0 ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		int res = 1;
		int pre = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= intervals[pre][1]) {
				res++;
				pre = i;
			}
		}
		return intervals.length - res;

	}

}
