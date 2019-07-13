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
		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (M != 2) {
			return month[M - 1];
		}
		if ((Y % 4 == 0 && Y % 100 != 0) || (Y % 400 == 0)) {
			return 29;// ����
		} else {
			return 28;// ƽ��
		}
	}
}
