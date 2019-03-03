package Leetcode_172_FactorialTrailingZeroes;
/*
	����һ������ n������ n! ���β�������������
	
	ʾ�� 1:	
		����: 3
		���: 0
	����: 3! = 6, β����û���㡣
	ʾ�� 2:	
		����: 5
		���: 1
	����: 5! = 120, β������ 1 ����.
	˵��: ���㷨��ʱ�临�Ӷ�ӦΪ O(log n) ��
 */

//172.�׳˺����(ֻ��Ҫ����������ٸ�5)
public class FactorialTrailingZeroes {
	public static void main(String[] args) {
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(2147483647));
	}

	// 
	public int trailingZeroes(int n) {
		// int countoftwo = 0;
		int countoffive = 0;
		while (n >= 5) {
			if (n % 5 != 0) {
				n--;
				continue;
			}
			int temp5 = n;
			while (temp5 % 5 == 0) {
				countoffive++;
				temp5 /= 5;
			}
			n -= 5;
		}
		return countoffive;
	}

	// 13ms
	public int trailingZeroes0(int n) {
		if (n < 5)
			return 0;
		else
			return n / 5 + trailingZeroes(n / 5);
	}
}
