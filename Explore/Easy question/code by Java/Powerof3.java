package Leetcode_326_Powerof3;

/*
	����һ��������дһ���������ж����Ƿ��� 3 ���ݴη���
	
	ʾ�� 1:	
		����: 27
		���: true
	
	ʾ�� 2:	
		����: 0
		���: false
	
	ʾ�� 3:	
		����: 9
		���: true
	
	ʾ�� 4:	
		����: 45
		���: false
	
	���ף�
		���ܲ�ʹ��ѭ�����ߵݹ�����ɱ�����

 */
public class Powerof3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Powerof3().isPowerOfThree(27));
	}

	// 326. 3����

	public boolean isPowerOfThree1(int n) {
		// �����㷨
		if (n == 0) {
			return false;
		}
		while (n != 1) {
			if (n % 3 != 0) {
				return false;
			} else {
				n /= 3;
			}

		}
		return true;
	}
	
	//�����ķ�����һ������3�Ĵη�����ô��3Ϊ��n�Ķ���һ���Ǹ� ������
	public boolean isPowerOfThree2(int n) {		
		double temp = Math.log10(n)/Math.log10(3);//��3Ϊ��n�Ķ���,������10Ϊ��
		if((temp - (int)temp)==0) {
			return true;
		}else {
			return false;
		}		
	}
	
	

}
