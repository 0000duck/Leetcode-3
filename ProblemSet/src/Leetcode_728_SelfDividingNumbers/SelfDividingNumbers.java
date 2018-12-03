package Leetcode_728_SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

/*
	�Գ��� ��ָ���Ա���������ÿһλ������������	
	���磬128 ��һ���Գ�������Ϊ 128 % 1 == 0��128 % 2 == 0��128 % 8 == 0��	
	���У��Գ������������ 0 ��	
	�����ϱ߽���±߽����֣����һ���б��б��Ԫ���Ǳ߽磨���߽磩�����е��Գ�����
	
	ʾ�� 1��	
		���룺 
			�ϱ߽�left = 1, �±߽�right = 22
		�����
		 	[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
		ע�⣺		
			ÿ����������ı߽����� 1 <= left <= right <= 10000��
 */
public class SelfDividingNumbers {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SelfDividingNumbers sdn = new SelfDividingNumbers();
		int left = 9;
		int right = 22;
		sdn.selfDividingNumbers(left, right);
	}

	// 728. �Գ���
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = left; i <= right; i++) {
			if (isselfDividingNumbers(i)) {
				result.add(i);
			}
		}
		return result;
	}

	// �Գ�
	public boolean isselfDividingNumbers(int num) {
		if (num < 10) {
			return true;
		}
		int temp = num;
		while (temp > 0) {
			if (temp % 10 == 0) {
				return false;
			}
			if (num % (temp % 10) == 0) {
				temp /= 10;
			} else {
				return false;
			}

		}
		return true;
	}

	public boolean isSelfDivNum(int num) {
		int digit;
		int tmp = num;
		while (tmp != 0) {
			digit = tmp % 10;
			if (digit == 0 || num % digit != 0)
				return false;
			tmp = tmp / 10;
		}
		return true;
	}

}
