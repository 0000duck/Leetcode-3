package Leetcode_888_FairCandySwap;

/*
	����˿�ͱ����в�ͬ��С���ǹ�����A[i] �ǰ���˿ӵ�еĵ� i ���ǵĴ�С��B[j] �Ǳ���ӵ�еĵ� j ���ǵĴ�С��	
	��Ϊ���������ѣ����������뽻��һ���ǹ������������������Ƕ�����ͬ���ǹ���������һ����ӵ�е��ǹ�����������ӵ�е��ǹ�����С���ܺ͡���	
	����һ���������� ans������ ans[0] �ǰ���˿���뽻�����ǹ����Ĵ�С��ans[1] �� Bob ���뽻�����ǹ����Ĵ�С��	
	����ж���𰸣�����Է��������κ�һ������֤�𰸴��ڡ�	 
	
	ʾ�� 1��	
		���룺A = [1,1], B = [2,2]
		�����[1,2]
	ʾ�� 2��	
		���룺A = [1,2], B = [2,3]
		�����[1,2]
	ʾ�� 3��	
		���룺A = [2], B = [1,3]
		�����[2,3]
	ʾ�� 4��	
		���룺A = [1,2,5], B = [2,4]
		�����[5,4]	 
	
	��ʾ��	
		1 <= A.length <= 10000
		1 <= B.length <= 10000
		1 <= A[i] <= 100000
		1 <= B[i] <= 100000
		��֤����˿�뱫�����ǹ�������ͬ��
		�𰸿϶����ڡ�
 */
public class FairCandySwap {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		FairCandySwap fcs = new FairCandySwap();
		int[] A = { 1, 1 };
		int[] B = { 2, 2 };
		// System.out.println(fcs.fairCandySwap(A, B));
	}

	// 888. ��ƽ���ǹ�����
	public int[] fairCandySwap(int[] A, int[] B) {
		int[] result = new int[2];
		// A���ǹ�����
		int sumA = 0;
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
		}
		// B���ǹ�����
		int sumB = 0;
		for (int i = 0; i < B.length; i++) {
			sumB += B[i];
		}
		//
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (sumA - sumB == 2 * (A[i] - B[j])) {
					result[0] = A[i];
					result[1] = B[j];
					break;
				}
			}
		}
		return result;
	}

}
