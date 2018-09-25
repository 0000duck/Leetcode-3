package Leetcode_788_RotatedDigits;

/*
	���ǳ�һ���� X Ϊ����, �������ÿλ��������ر���ת 180 �Ⱥ������Կ��Եõ�һ����Ч�ģ��Һ� X ��ͬ������Ҫ��ÿλ���ֶ�Ҫ����ת��
	
	���һ������ÿλ���ֱ���ת�Ժ���Ȼ����һ�����֣� �����������Ч�ġ�
	0, 1, �� 8 ����ת����Ȼ�������Լ���
	2 �� 5 ���Ի�����ת�ɶԷ���
	6 �� 9 ͬ��������Щ����������������ת�Ժ󶼲�������Ч�����֡�
	
	����������һ�������� N, ����� 1 �� N ���ж��ٸ��� X �Ǻ�����
	
	ʾ��:
		����: 10
		���: 4
	����: 
		��[1, 10]�����ĸ������� 2, 5, 6, 9��
		ע�� 1 �� 10 ���Ǻ���, ��Ϊ��������ת֮�󲻱䡣
	
	ע��:	
		N ��ȡֵ��Χ�� [1, 10000]��
*/
public class RotatedDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotatedDigits rd = new RotatedDigits();
		System.out.println(rd.rotatedDigits(10));		
	}

	// 788.��ת����
	public int rotatedDigits(int N) {
		// ͳ��
		int count = 0;
		// �ж��Ƿ��Ǻ���
		for (int i = 1; i <= N; i++) {
			if (isGoodNumber(i)) {
				System.out.println(i);
				count++;
			}
		}
		return count;
	}

	// �ж��Ƿ��Ǻ���
	public boolean isGoodNumber(int i) {
		String str = String.valueOf(i);
		char[] chs = str.toCharArray();
		int length = chs.length;
		int count = 0;
		for(int j =0;j<length;j++) {
			if((chs[j]!='0')&(chs[j]!='1')&(chs[j]!='2')&(chs[j]!='5')&(chs[j]!='6')&(chs[j]!='8')&(chs[j]!='9')) {
				return false;
			}
			if((chs[j]=='0')||(chs[j]=='1')||(chs[j]=='8')) {
				count++;
			}
		}
		if(count==length) {
			return false;
		}
		return true;
	}
}
