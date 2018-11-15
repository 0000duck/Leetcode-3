package Leetcode_461_HammingDistance;
/*
	��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��	
	������������ x �� y����������֮��ĺ������롣
	
	ע�⣺
		0 �� x, y < 2^31.
	
	ʾ��:	
		����: x = 1, y = 4		
		���: 2
		
		����:
			1   (0 0 0 1)
			4   (0 1 0 0)
			       ��   ��		
		����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
 */
public class HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HammingDistance hd= new HammingDistance();
		hd.hammingDistance(1, 4);
	}
	//461. ��������
    public int hammingDistance(int x, int y) {
    	//x^y:��ͬ��Ϊ0,��ͬΪ1
    	int temp = x^y;
    	//����temp���ж��ٸ�1
    	int count = 0;
    	while(temp>0) {
    		count += temp&1;
    		//����1λ
    		temp >>>= 1;    		
    	}
        return count;
    }

}
