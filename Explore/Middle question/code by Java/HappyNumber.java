package Leetcode_202_HappyNumber;

import java.util.HashSet;

/*
	��дһ���㷨���ж�һ�����ǲ��ǡ�����������
	
	һ����������������Ϊ��
		����һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���ͣ�
		Ȼ���ظ��������ֱ���������Ϊ 1��Ҳ����������ѭ����ʼ�ձ䲻�� 1��
		������Ա�Ϊ 1����ô��������ǿ�������
	
	ʾ��: 	
		����: 19
		���: true
		����: 
			1^2 + 9^2 = 82
			8^2 + 2^2 = 68
			6^2 + 8^2 = 100
			1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappyNumber hn = new HappyNumber();
		hn.isHappy(19);
	}

	//202. ������
	public boolean isHappy(int n) {
		while (n >= 10) {
			n = toNum(n);
		}
		if (n == 1 || n == 7) {
			return true;
		} else {
			return false;
		}
	}

	public int toNum(int x) {
		int result = 0;
		while (x > 0) {
			result += (x % 10) * (x % 10);
			x /= 10;
		}
		return result;
	}

	// 0ms
	public boolean isHappy0(int num) {
		if (num < 10) {
			return num == 1 || num == 7;
		}
		int n = num;
		int b = 0;
		while (n > 0) {
			b += (n % 10) * (n % 10);
			n = n / 10;
		}
		return isHappy(b);
	}

}
