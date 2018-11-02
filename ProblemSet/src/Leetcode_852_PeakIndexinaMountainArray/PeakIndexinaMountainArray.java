package Leetcode_852_PeakIndexinaMountainArray;
/*
	���ǰѷ����������Ե����� A ����ɽ����
	
	A.length >= 3
	���� 0 < i < A.length - 1 ʹ��A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
	����һ��ȷ��Ϊɽ�������飬�����κ����� A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] �� i ��ֵ��
		
	ʾ�� 1��	
		���룺[0,1,0]
		�����1
	ʾ�� 2��	
		���룺[0,2,1,0]
		�����1
	 
	��ʾ��	
		3 <= A.length <= 10000
		0 <= A[i] <= 10^6
		A �����϶����ɽ��
*/
public class PeakIndexinaMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//852. ɽ������ķ嶥����
	//���ֲ���
	public int peakIndexInMountainArray(int[] A) {
		int left = 1;
		int right = A.length-1;
		while(left<right) {
			int mid = left+(right-left)/2;
			if((A[mid]>A[mid-1])&&(A[mid]>A[mid+1])) {
				return mid;
			}else if((A[mid]>A[mid-1])&&(A[mid]<A[mid+1])){
				//mid-1<mid<mid+1,���ұ�
				left = mid;				
			}else {
				right = mid;
			}
		}
		return left;
	}
	//ֱ������
    public int peakIndexInMountainArray2(int[] A) {
    	
        //ֱ���������ֵ
    	int maxindex = 0;
    	for(int i = 1;i<A.length;i++) {
    		if(A[maxindex]<A[i]) {
    			maxindex = i;
    		}
    	}
    	return maxindex;
    }

}
