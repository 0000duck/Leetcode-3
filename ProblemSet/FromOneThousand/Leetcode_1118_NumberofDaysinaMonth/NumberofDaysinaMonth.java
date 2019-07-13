package Leetcode_1118_NumberofDaysinaMonth;

import java.util.Arrays;
import java.util.HashSet;

/*
	ָ����� Y ���·� M�������æ���������һ���ж����졣 
	
	ʾ�� 1��
		���룺Y = 1992, M = 7
		�����31
	ʾ�� 2��
		���룺Y = 2000, M = 2
		�����29
	ʾ�� 3��
		���룺Y = 1900, M = 2
		�����28
	
	��ʾ��
		1583 <= Y <= 2100
		1 <= M <= 12
 */

//1118. һ���ж�����
public class NumberofDaysinaMonth {
	public int numberOfDays(int Y, int M) {
		HashSet<Integer> month31 = new HashSet<>(Arrays.asList(new Integer[] { 1, 3, 5, 7, 8, 10, 12 }));
		HashSet<Integer> month30 = new HashSet<>(Arrays.asList(new Integer[] { 4, 6, 9, 11 }));
		if (month31.contains(M)) {
			return 31;
		}
		if (month30.contains(M)) {
			return 30;
		}

		if ((Y % 4 == 0 && Y % 100 != 0) || (Y % 400 == 0)) {
			return 29;// ����
		} else {
			return 28;// ƽ��
		}
	}
}
