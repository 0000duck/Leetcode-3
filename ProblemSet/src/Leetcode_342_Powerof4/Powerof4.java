package Leetcode_342_Powerof4;

/*
	����һ������ (32 λ�з�������)�����дһ���������ж����Ƿ��� 4 ���ݴη���
	
	ʾ�� 1:	
		����: 16
		���: true
	
	ʾ�� 2:	
		����: 5
		���: false
	
	���ף�
		���ܲ�ʹ��ѭ�����ߵݹ�����ɱ�����


 */
public class Powerof4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Powerof4 p4 = new Powerof4();
		p4.isPowerOfFour(16);
	}

	// 342.4���ݣ�λ���㣩
	public boolean isPowerOfFour(int num) {
		//�����ж��Ƿ���2����
		if((num <= 0) || (num & (num - 1)) != 0) {
			return false;
		}
		//
		int temp = 0x55555555;
		return ((num & temp)==num);
	}

}
