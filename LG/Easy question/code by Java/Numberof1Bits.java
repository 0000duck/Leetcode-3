package Leetcode_191_Numberof1Bits;

/*
	��дһ��������������һ���޷�������������������Ʊ��ʽ������λ��Ϊ ��1�� �ĸ�����Ҳ����Ϊ������������
	
	ʾ�� :	
		����: 11
		���: 3
		����: ���� 11 �Ķ����Ʊ�ʾΪ 00000000000000000000000000001011	 
	
	ʾ�� 2:	
		����: 128
		���: 1
		����: ���� 128 �Ķ����Ʊ�ʾΪ 00000000000000000000000010000000
 */
public class Numberof1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//java��û�� �޷�������
		//System.out.println(new Numberof1Bits().hammingWeight(2147483648));
	}

	// 191. λ1�ĸ���
	// you need to treat n as an unsigned value
	// ��ΪnΪ�޷�����ֵ
	public int hammingWeight(int n) {
		int count = 0;
		
//		���Ϊ0
//		while (n != 0) {
//			if (n % 2 == 1) {
//				count++;
//			}
//			n /= 2;			
//			//The literal 2147483648 of type int is out of range
//		}
//		
		while(n!=0) {
			count += n&1;
			n >>>= 1;
		}
		return count;
	}

}
