package Leetcode_070_ClimbingStairs;

/*
	������������¥�ݡ���Ҫ n ������ܵ���¥����	
	ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
		
	ע�⣺���� n ��һ����������
	
	ʾ�� 1��	
		���룺 2
		����� 2
		���ͣ� �����ַ�����������¥����
		1.  1 �� + 1 ��
		2.  2 ��
		
	ʾ�� 2��	
		���룺 3
		����� 3
		���ͣ� �����ַ�����������¥����
		1.  1 �� + 1 �� + 1 ��
		2.  1 �� + 2 ��
		3.  2 �� + 1 ��
*/
public class ClimbingStairs {
	// 70.��¥��
	public static int climbStairs(int n) {
		int[] Stairs = new int[n];
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		Stairs[0] = 1;
		Stairs[1] = 2;
		for (int i = 2; i < n; i++) {
			Stairs[i] = Stairs[i - 1] + Stairs[i - 2];
		}
		return Stairs[n - 1];
	}
}
