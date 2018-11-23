package Leetcode_009_PalindromeNumber;

/*
	�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
	
	ʾ�� 1:	
		����: 121
		���: true
	
	ʾ�� 2:	
		����: -121
		���: false
		����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
	
	ʾ�� 3:	
		����: 10
		���: false
		����: ���������, Ϊ 01 �����������һ����������
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber pn = new PalindromeNumber();
		pn.isPalindrome(-121);
	}

	// 9.������
	public boolean isPalindrome(int x) {
		String s = x + "";
		StringBuilder sb = new StringBuilder(s);

		int res = sb.toString().compareTo(sb.reverse().toString());
		if (res == 0) {
			return true;
		} else {
			return false;
		}
	}

	// 86ms
	public boolean isPalindrome2(int x) {
		// ������10�ı���һ�����ǻ��Ĵ�
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int s = 0;
		while (s <= x) {
			s = s * 10 + x % 10;
			// ż�����Ȼ���ȡ���������Ϊ����
			if (s == x || s == x / 10) {
				return true;
			}
			x /= 10;
		}
		return false;
	}

}
