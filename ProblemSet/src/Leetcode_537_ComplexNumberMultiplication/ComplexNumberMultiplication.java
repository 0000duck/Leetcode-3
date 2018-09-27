package Leetcode_537_ComplexNumberMultiplication;
/*
	����������ʾ�������ַ�����
	���ر�ʾ���ǳ˻����ַ�����ע�⣬���ݶ��� i2 = -1 ��
	
	ʾ�� 1:
		����: "1+1i", "1+1i"
		���: "0+2i"
	����: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ������Ҫ����ת��Ϊ 0+2i ����ʽ��
	ʾ�� 2:
		����: "1+-1i", "1+-1i"
		���: "0+-2i"
	����: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ������Ҫ����ת��Ϊ 0+-2i ����ʽ�� 
*/
public class ComplexNumberMultiplication {

	//537.�����˷�
    public  String complexNumberMultiply(String a, String b) {
        //��a��bת������
    	String[] arr = a.split("\\+");
    	arr[1] = arr[1].substring(0, arr[1].length()-1);
    	String[] brr = b.split("\\+");//�����ַ���Ҫת��
    	brr[1] = brr[1].substring(0, brr[1].length()-1);
    	//���ַ�������ת����������
    	int[] ant = {Integer.parseInt(arr[0]),Integer.parseInt(arr[1])};
    	int[] bnt = {Integer.parseInt(brr[0]),Integer.parseInt(brr[1])};
    	//�˷�����
    	int m = ant[0]*bnt[0]-ant[1]*bnt[1];
    	int n = ant[0]*bnt[1]+bnt[0]*ant[1];   
    	String result = m+"+"+n+"i";
    	return result;
    }

}
