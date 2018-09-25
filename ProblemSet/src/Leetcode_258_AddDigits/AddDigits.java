package Leetcode_258_AddDigits;

/*
	����һ���Ǹ����� num������������λ�ϵ�������ӣ�ֱ�����Ϊһλ����
	
	ʾ��:	
		����: 38
		���: 2 
		����: ��λ��ӵĹ���Ϊ��3 + 8 = 11, 1 + 1 = 2�� ���� 2 ��һλ�������Է��� 2��
	����:
		����Բ�ʹ��ѭ�����ߵݹ飬���� O(1) ʱ�临�Ӷ��ڽ�����������
*/
public class AddDigits {
	//�ݹ�
	public int addDigits(int num) {
		int sum = 0;
		// ��num�ĸ�λ��ȡ���������
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		if (sum >= 10) {			
			return addDigits(sum);
		}
		return sum;
	}

}
