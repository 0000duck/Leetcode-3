package Leetcode_231_Powerof2;

/*
	����һ����������дһ���������ж����Ƿ��� 2 ���ݴη���
	
	ʾ�� 1:	
		����: 1
		���: true
		����: 20 = 1
	
	ʾ�� 2:	
		����: 16
		���: true
		����: 24 = 16
	
	ʾ�� 3:	
		����: 218
		���: false
 */
public class Powerof2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 231. 2����
	// �� n & n-1 == 0��
	public boolean isPowerOfTwo(int n) {
		return (n > 0) && ((n & (n - 1)) == 0);
	}

}
