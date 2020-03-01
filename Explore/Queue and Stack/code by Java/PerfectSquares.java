package Leetcode_279_PerfectSquares;

import java.util.LinkedList;
import java.util.Queue;

/*
	���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n��
	����Ҫ����ɺ͵���ȫƽ�����ĸ������١�
	
	ʾ�� 1:	
		����: n = 12
		���: 3 
		����: 12 = 4 + 4 + 4.
	
	ʾ�� 2:	
		����: n = 13
		���: 2
		����: 13 = 4 + 9.
 */
public class PerfectSquares {
	public static void main(String[] args) {
		int n = 7186;
		PerfectSquares ps = new PerfectSquares();
		System.out.println(ps.numSquares0(n));
	}

	// 279. ��ȫƽ����
	// Lagrange ��ƽ������ �κ�һ�������������Ա�ʾ�ɲ������ĸ�������ƽ��֮�͡�
	// ���ֻ��1,2,3,4�����ֿ��ܡ�
	// ���ۣ���������ƽ���Ͷ������n�������������ĸ������ɣ����ض����� n=4^a*(8^b+7)
	// 1ms
	public int numSquares0(int n) {
		while (n % 4 == 0) {
			n /= 4;
		}
		if (n % 8 == 7) // �������� ˵����4����ȫƽ��������
			return 4;
		int a = 0;
		while (a * a <= n) {
			// �ж������С������Ƿ����ͨ������ƽ�����ĺͻ�һ��ƽ�������
			int b = (int) (Math.sqrt((n - a * a)));// ���n=a^2 ��ôb=0
			// if (a * a == n)
			// return 1;
			if (a * a + b * b == n)
				// ���� a��b�з�0�ĸ�����
				return (a != 0 ? 1 : 0) + (b != 0 ? 1 : 0);
			a += 1;
		}
		return 3;
	}

	public int numSquares(int n) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] first = { n, 0 };
		queue.offer(first);
		while (!queue.isEmpty()) {
			int num = queue.peek()[0];
			int step = queue.peek()[1];
			for (int i = Close(num); i > 0; i--) {
				int[] temp = { num - i * i, step + 1 };
				if (temp[0] == 0) {
					return temp[1];
				}
				queue.offer(temp);
			}
			queue.poll();
		}
		return -1;
	}

	// ���Ľӽ�����
	private int Close(int n) {
		for (int i = (int) Math.ceil(Math.sqrt(n)); i >= 0; i--) {
			if (i * i <= n) {
				return i;
			}
		}
		return 0;
	}

}
