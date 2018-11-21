package Leetcode_762_PrimeNumberofSetBitsinBinaryRepresentation;

/*
	������������ L �� R ���ҵ������� [L, R] ��Χ�ڣ�������λλ��Ϊ����������������
	
	��ע�⣬������λ��������Ʊ�ʾ��1�ĸ��������� 21 �Ķ����Ʊ�ʾ 10101 �� 3 ��������λ�����У�1 ������������
	
	ʾ�� 1:	
		����: 
			L = 6, R = 10
		���: 
			4
		����:
			6 -> 110 (2 ��������λ��2 ������)
			7 -> 111 (3 ��������λ��3 ������)
			9 -> 1001 (2 ��������λ��2 ������)
			10-> 1010 (2 ��������λ��2 ������)
	
	ʾ�� 2:	
		����:
			L = 10, R = 15
		���: 
			5
		����:
			10 -> 1010 (2 ��������λ, 2 ������)
			11 -> 1011 (3 ��������λ, 3 ������)
			12 -> 1100 (2 ��������λ, 2 ������)
			13 -> 1101 (3 ��������λ, 3 ������)
			14 -> 1110 (3 ��������λ, 3 ������)
			15 -> 1111 (4 ��������λ, 4 ��������)
	
	ע��:	
		L, R �� L <= R ���� [1, 10^6] �е�������
		R - L �����ֵΪ 10000��
 */
public class PrimeNumberofSetBitsinBinaryRepresentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 762. �����Ʊ�ʾ��������������λ
	public int countPrimeSetBits(int L, int R) {
		int count = 0;
		for (int i = L; i <= R; i++) {
			int primecount = 0;
			int temp = i;
			while (temp > 0) {
				if (temp % 2 == 1) {
					primecount++;
				}
			}
			// �ж�primecount�Ƿ�������
			for (int j = 2; j < primecount; j++) {
				if (primecount % j == 0) {
					continue;
				}
				if (j == primecount - 1) {
					count++;
				}
			}
		}
		return count;
	}

}
