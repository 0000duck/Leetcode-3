package Leetcode_693_BinaryNumberwithAlternatingBits;

/*
	����һ����������������Ƿ�Ϊ����λ�������������仰˵���������Ķ����������ڵ�����λ��������ȡ�
	
	ʾ�� 1:	
		����: 5
		���: True
		����:
		5�Ķ���������: 101
	
	ʾ�� 2:	
		����: 7
		���: False
		����:
		7�Ķ���������: 111
	
	ʾ�� 3:	
		����: 11
		���: False
		����:
		11�Ķ���������: 1011
	 
	ʾ�� 4:	
		����: 10
		���: True
		����:
		10�Ķ���������: 1010
 */
public class BinaryNumberwithAlternatingBits {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	// 693. ����λ��������
	public boolean hasAlternatingBits(int n) {
		while (n > 0) {
			int temp = n % 2;
			n /= 2;
			if (n <= 0) {
				return true;
			}
			if (n > 0) {
				if (temp == n % 2) {
					return false;
				}
			}
		}
		return true;
	}
}
