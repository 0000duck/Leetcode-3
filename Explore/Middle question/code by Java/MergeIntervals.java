package Leetcode_056_MergeIntervals;

import java.util.ArrayList;
import java.util.List;

import Interval.Interval;

/*
	����һ������ļ��ϣ���ϲ������ص������䡣
	
	ʾ�� 1:	
		����: [[1,3],[2,6],[8,10],[15,18]]
		���: [[1,6],[8,10],[15,18]]
		����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
	ʾ�� 2:	
		����: [[1,4],[4,5]]
		���: [[1,5]]
		����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
 */
//56.�ϲ�����
public class MergeIntervals {
	public static void main(String[] args) {
		Interval inter1 = new Interval();
		inter1.start = 1;
		inter1.end = 3;

		Interval inter2 = new Interval();
		inter2.start = 2;
		inter2.end = 6;

		Interval inter3 = new Interval();
		inter3.start = 8;
		inter3.end = 10;

		Interval inter4 = new Interval();
		inter4.start = 15;
		inter4.end = 18;

		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(inter1);
		intervals.add(inter2);
		intervals.add(inter3);
		intervals.add(inter4);

		MergeIntervals mi = new MergeIntervals();
		mi.merge0(intervals);

	}

	public List<Interval> merge(List<Interval> intervals) {
		for (int i = 0; i < intervals.size(); i++) {
			Interval inter = intervals.get(i);
			for (int j = i + 1; j < intervals.size(); j++) {
				Interval res = intervals.get(j);
				// �Ƚ�start
				if (inter.start < res.start) {
					if (inter.end >= res.start && inter.end <= res.end) {
						res.start = inter.start;
						intervals.remove(i);
						i = i - 1;
						break;
					} else if (inter.end > res.end) {
						res.start = inter.start;
						res.end = inter.end;
						intervals.remove(i);
						i = i - 1;
						break;
					}
				} else if (inter.start >= res.start && inter.start <= res.end) {
					if (inter.end <= res.end) {
						intervals.remove(i);
						i = i - 1;
						break;
					} else if (inter.end > res.end) {
						res.end = inter.end;
						intervals.remove(i);
						i = i - 1;
						break;
					}
				}
			}
		}

		return intervals;
	}

	// 10ms
	public List<Interval> merge0(List<Interval> intervals) {
		List<Interval> list = new ArrayList<Interval>();
		Interval L = new Interval();// һ��ѭ���������
		Interval R = new Interval();// ����ѭ���������
		// ������ϲ��������һ��
		for (int i = 0; i < intervals.size(); i++) {
			L = intervals.get(i);
			int j = i + 1;
			for (; j < intervals.size(); j++) {
				R = intervals.get(j);
				// ��������˵����
				if (R.start == L.start) {
					// ��jλ�õ���������Ϊ��start,maxEnd��
					intervals.set(j, new Interval(L.start, Math.max(L.end, R.end)));
					break;
					// ��˵���С�Ҵ�
				} else if (L.start < R.start) {
					// �Ƚ��Ҷ˵����˵�
					if (L.end >= R.start) {
						Interval inter = new Interval(L.start, Math.max(L.end, R.end));
						intervals.set(j, inter);
						break;
					}

				} else {
					if (R.end >= L.start) {
						Interval inter = new Interval(R.start, Math.max(L.end, R.end));
						intervals.set(j, inter);
						break;
					}
				}
			}

			if (j >= intervals.size()) {
				list.add(intervals.get(i));
			}
		}
		return list;
	}
}
