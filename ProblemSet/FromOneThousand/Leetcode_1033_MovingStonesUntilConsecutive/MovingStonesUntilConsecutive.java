package Leetcode_1033_MovingStonesUntilConsecutive;

import java.util.Arrays;

/*
	��öʯ�ӷ����������ϣ�λ�÷ֱ�Ϊ a��b��c��
	
	ÿһ�غϣ����Ǽ�������öʯ�ӵ�ǰ�ֱ�λ��λ�� x, y, z �� x < y < z��
	��λ�� x ������λ�� z ����һöʯ�ӣ�������ʯ���ƶ���ĳһ����λ�� k �������� x < k < z �� k != y��
	
	�����޷������κ��ƶ�ʱ��������Щʯ�ӵ�λ������ʱ����Ϸ������
	
	����Ϸ����ʱ�������ִ�е���С������ƶ������ֱ��Ƕ��٣� 
	�Գ���Ϊ 2 ��������ʽ���أ�answer = [minimum_moves, maximum_moves]	 
	
	ʾ�� 1��	
		���룺a = 1, b = 2, c = 5
		�����[1, 2]
		���ͣ���ʯ�Ӵ� 5 �ƶ��� 4 ���ƶ��� 3���������ǿ���ֱ�ӽ�ʯ���ƶ��� 3��
	ʾ�� 2��	
		���룺a = 4, b = 3, c = 2
		�����[0, 0]
		���ͣ������޷������κ��ƶ���	 
	
	��ʾ��	
		1 <= a <= 100
		1 <= b <= 100
		1 <= c <= 100
		a != b, b != c, c != a

 */

//1033.�ƶ�ʯ��ֱ������
public class MovingStonesUntilConsecutive {
	public int[] numMovesStones(int a, int b, int c) {
		int[] res = new int[2];
		// x < y < z
		int x = a < b ? (a < c ? a : c) : (b < c ? b : c);
		int z = a > b ? (a > c ? a : c) : (b > c ? b : c);
		int y = a + b + c - x - z;

		res[0] = Math.min(1, z - y - 1) + Math.min(1, y - x - 1);
		if (z - y == 2 || y - x == 2) {
			res[0] = 1;
		}
		res[1] = z - y - 1 + y - x - 1;
		return res;

	}
}
