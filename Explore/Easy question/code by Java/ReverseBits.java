package Leetcode_190_ReverseBits;

/*
	�ߵ������� 32 λ�޷��������Ķ�����λ��
	
	ʾ��:	
		����: 43261596
		���: 964176192
	����:
		     43261596 �Ķ����Ʊ�ʾ��ʽΪ 00000010100101000001111010011100 ��
	 	���� 964176192��������Ʊ�ʾ��ʽΪ 00111001011110000010100101000000 ��
	
	����:
	�����ε�������������㽫����Ż�����㷨��
 */
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  //2147483648 (10000000000000000000000000000000)
		  ReverseBits rb = new ReverseBits();
		  //rb.reverseBits(2147483648);
	}

	// 190. �ߵ�������λ
	
	//���ν�n��ĩβλ��result��ĩβλ������result������31��
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int i = 0;
        while (i < 32) {
        	//ȡ��n�ĵ�0λ
            int temp = n & 0x01;//0x01 ʮ������
            //����������1λ
            n = n >> 1;//<<�����ƣ���>>�����������ƣ���>>>���޷������ƣ�
        	//result*2+temp
            result = (result << 1) | temp;
            i++;
        }
        return result;
    }
    
    

}
