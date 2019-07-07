package Leetcode_1109_CorporateFlightBookings;

import java.util.Arrays;

/*
	������ n �����࣬���Ƿֱ�� 1 �� n ���б�š�
	
	���������һ�ݺ���Ԥ����
	���е� i ��Ԥ����¼ bookings[i] = [i, j, k] 
	��ζ�������ڴ� i �� j ��ÿ��������Ԥ���� k ����λ��
	
	���㷵��һ������Ϊ n ������ answer��
	��������˳�򷵻�ÿ��������Ԥ������λ���� 
	
	ʾ����
		���룺bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
		�����[10,55,45,25,25]
	
	��ʾ��
		1 <= bookings.length <= 20000
		1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
		1 <= bookings[i][2] <= 10000
 */
public class CorporateFlightBookings {
	// 1109.����Ԥ��ͳ��

	// �����ⷨ����ʱ��
	public int[] corpFlightBookings(int[][] bookings, int n) {
		int[] res = new int[n];
		for (int[] booking : bookings) {
			int i = booking[0];
			int j = booking[1];
			int k = booking[2];

			for (int x = i; x <= j; x++) {
				res[x - 1] += k;
			}
		}
		return res;
	}

	// ���ֺ�
	public int[] corpFlightBookings2(int[][] bookings, int n) {
		int[] res = new int[n + 1];

		for (int[] book : bookings) {
			res[book[0] - 1] += book[2];
			res[book[1]] -= book[2];
		}

		for (int i = 1; i < n; i++) {
			res[i] += res[i - 1];
		}
		return Arrays.copyOf(res, n);
	}
}
