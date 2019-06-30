package Leetcode_1101_TheEarliestMomentWhenEveryoneBecomeFriends;

import java.util.Arrays;
import java.util.Comparator;

/*
	��һ���罻Ȧ�ӵ��У��� N ���ˡ�ÿ���˶���һ���� 0 �� N-1 Ψһ�� id ��š�
	
	������һ����־�б� logs������ÿ����¼������һ���Ǹ�������ʱ�����
	�Լ����������˵Ĳ�ͬ id��logs[i] = [timestamp, id_A, id_B]��
	
	ÿ����־��ʶ�������˳�Ϊ���ѵ�ʱ�䣬�������໥�ģ���� A �� B �Ǻ��ѣ���ô B �� A Ҳ�Ǻ��ѡ�
	
	��� A �� B �ĺ��ѣ����� A �� B �ĺ��ѵĺ��ѣ���ô�Ϳ�����Ϊ A Ҳ�� B ��ʶ��
	
	����Ȧ����������֮�䶼��ʶ������ʱ�䡣����Ҳ�������ʱ�䣬�ͷ��� -1 �� 
	
	ʾ����
		���룺logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
		�����20190301
		���ͣ�
			��һ�νύ������ timestamp = 20190101��0 �� 1 ��Ϊ���ѣ�
				�罻����Ȧ���� [0,1], [2], [3], [4], [5]��
			�ڶ��νύ������ timestamp = 20190104��3 �� 4 ��Ϊ���ѣ�
				�罻����Ȧ���� [0,1], [2], [3,4], [5].
			�����νύ������ timestamp = 20190107��2 �� 3 ��Ϊ���ѣ�
				�罻����Ȧ���� [0,1], [2,3,4], [5].
			���Ĵνύ������ timestamp = 20190211��1 �� 5 ��Ϊ���ѣ�
				�罻����Ȧ���� [0,1,5], [2,3,4].
			����νύ������ timestamp = 20190224��2 �� 4 �Ѿ��Ǻ����ˡ�
			�����νύ������ timestamp = 20190301��0 �� 3 ��Ϊ���ѣ���Ҷ�������ʶ�ˡ�
	��ʾ��
		1 <= N <= 100
		1 <= logs.length <= 10^4
		0 <= logs[i][0] <= 10^9
		0 <= logs[i][1], logs[i][2] <= N - 1
		��֤ logs[i][0] �е�����ʱ�������ͬ
		Logs ��һ����ĳһ��׼����
		logs[i][1] != logs[i][2]
 */
public class TheEarliestMomentWhenEveryoneBecomeFriends {
	public static void main(String[] args) {
		int[][] logs = { { 4, 2, 0 }, { 8, 3, 4 }, { 10, 2, 4 }, { 11, 3, 2 }, { 3, 0, 1 }, { 5, 3, 2 }, { 2, 2, 0 },
				{ 1, 3, 1 }, { 0, 3, 1 }, { 12, 3, 1 }, { 9, 3, 2 }, { 7, 2, 0 }, { 6, 1, 0 } };
		int N = 5;
		new TheEarliestMomentWhenEveryoneBecomeFriends().earliestAcq(logs, N);
	}

	// 1101.�˴���ʶ������ʱ��
	public int earliestAcq(int[][] logs, int N) {
		Arrays.sort(logs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int[] map = new int[N];
		int[] size = new int[N];
		for (int i = 0; i < N; i++) {
			map[i] = i;
			size[i] = 1;
		}

		for (int[] log : logs) {
			if (jion(log[1], log[2], map, size) == N) {
				return log[0];
			}
		}
		return -1;
	}

	private int jion(int a, int b, int[] map, int[] size) {
		int fa = find(a, map);
		int fb = find(b, map);
		if (fa == fb) {
			return size[fa];
		} else if (size[fa] >= size[fb]) {
			map[fb] = fa;
			size[fa] += size[fb];
		} else {
			map[fa] = fb;
			size[fb] += size[fa];
		}
		return Math.max(size[fa], size[fb]);

	}

	private int find(int a, int[] map) {
		int fa = map[a];
		while (fa != map[fa]) {
			fa = find(fa, map);
		}
		map[a] = fa;
		return fa;
	}
}
