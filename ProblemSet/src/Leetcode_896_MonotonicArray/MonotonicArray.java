package Leetcode_896_MonotonicArray;

import java.util.Arrays;

/*
	��������ǵ��������򵥵��ݼ��ģ���ô���ǵ����ġ�
	����������� i <= j��A[i] <= A[j]����ô���� A �ǵ��������ġ� 
	����������� i <= j��A[i]> = A[j]����ô���� A �ǵ����ݼ��ġ�
	
	������������ A �ǵ�������ʱ���� true�����򷵻� false��
	ʾ�� 1��
		���룺[1,2,2,3]
		�����true
	ʾ�� 2��
		���룺[6,5,4,4]
		�����true
	ʾ�� 3��
		���룺[1,3,2]
		�����false
	ʾ�� 4��
		���룺[1,2,4,5]
		�����true
	ʾ�� 5��
		���룺[1,1,1]
		�����true
	��ʾ��
		1 <= A.length <= 50000
		-100000 <= A[i] <= 100000
*/
public class MonotonicArray {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MonotonicArray ma = new MonotonicArray();
		int[] A = {1,3,2};
		System.out.println(ma.isMonotonic(A));
	}
	//896.��������
    public boolean isMonotonic(int[] A) {
        //��i+1-i��ֵ��i
    	//��i��i+1���<0���ش���
    	int[] B = new int[A.length];
    	int index =0 ;
    	for(int i = 0;i<A.length-1;i++) {
    		A[i] = A[i+1]-A[i];
    		if(A[i]!=0) {
    			B[index] = A[i];    			
    			if(index>0) {
    				if(B[index-1]*B[index]<0) {
    					return false;
    				}
    			}
    			index++;
    		}
    		
    	}    	
    	return true;
    }

}
