package Leetcode_1134_ArmstrongNumber;

/*
	�������һ�� k λ�� N����ÿһλ�ϵ����ֵ� k ���ݵ��ܺ�Ҳ�� N����ô������ǰ�ķ˹��������
	����һ�������� N���������ж����Ƿ��ǰ�ķ˹�����������򷵻� true�������򷵻� false��
	
	ʾ�� 1��
		���룺153
		�����true
		���ͣ� 
			153 ��һ�� 3 λ������ 153 = 1^3 + 5^3 + 3^3��
	ʾ�� 2��
		���룺123
		�����false
		���ͣ� 
		123 ��һ�� 3 λ������ 123 != 1^3 + 2^3 + 3^3 = 36��
	
	��ʾ��
	1 <= N <= 10^8
 */

//1134.��ķ˹������
public class ArmstrongNumber {
	public boolean isArmstrong(int N) {
		String str = String.valueOf(N);
		int k = str.length();
		long res = 0;
		for (char ch : str.toCharArray()) {
			int temp = ch - '0';
			res += Math.pow(temp, k);
		}
		return String.valueOf(res).equals(str);
	}
}
