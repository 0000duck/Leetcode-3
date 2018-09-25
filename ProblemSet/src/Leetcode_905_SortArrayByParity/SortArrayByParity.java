package Leetcode_905_SortArrayByParity;
/*
	����һ���Ǹ��������� A������һ���� A ������ż��Ԫ����ɵ����飬����� A ����������Ԫ�ء�
	����Է���������������κ�������Ϊ�𰸡�
	ʾ����
		���룺[3,1,2,4]
		�����[2,4,3,1]
			��� [4,2,3,1]��[2,4,1,3] �� [4,2,1,3] Ҳ�ᱻ���ܡ�
	��ʾ��
		1 <= A.length <= 5000
		0 <= A[i] <= 5000
*/
public class SortArrayByParity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//905. ����żУ����������
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int begindex = 0;
        int endindex = A.length-1;
        for(int i = 0;i<A.length;i++) {
        	if(A[i]%2==0) {
        		B[begindex++] = A[i];
        	}else {
        		B[endindex--] = A[i];
        	}
        	
        }
        return B;
    }

}
