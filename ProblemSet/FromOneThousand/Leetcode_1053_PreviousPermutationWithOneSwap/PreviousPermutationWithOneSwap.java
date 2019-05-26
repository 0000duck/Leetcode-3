package Leetcode_1053_PreviousPermutationWithOneSwap;

import java.util.Arrays;
import java.util.Stack;
/*
	����һ�������������� A�����е�Ԫ�ز�һ����ȫ��ͬ����
	���㷵�ؿ��� һ�ν��������������� A[i] �� A[j] ��λ�ã���õ��ġ����ֵ�������С�� A �����������С�
	
	����޷���ô���������뷵��ԭ���顣
	
	ʾ�� 1��	
		���룺[3,2,1]
		�����[3,1,2]
		���ͣ�
			���� 2 �� 1	
	ʾ�� 2��	
		���룺[1,1,5]
		�����[1,1,5]
		���ͣ� 
			���Ѿ�����С����	
	ʾ�� 3��	
		���룺[1,9,4,6,7]
		�����[1,7,4,6,9]
		���ͣ�
			���� 9 �� 7	
	ʾ�� 4��	
		���룺[3,1,1,3]
		�����[1,1,3,3]
	
	��ʾ��	
		1 <= A.length <= 10000
		1 <= A[i] <= 10000
 */

//1053. ����һ�ε���ǰ����
public class PreviousPermutationWithOneSwap {

	public static void main(String[] args) {
		
	}

	public int[] prevPermOpt12(int[] A) {
		if (A.length == 1) {
			return A;
		}		
		for (int i = A.length - 2; i >= 0 ; i--) {
			for(int j = A.length-1;j>i;j--) {
				if (A[i] > A[j]) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
					return A;
				} 
			}
			
		}
		return A;
	}

	public int[] prevPermOpt1(int[] A) {
		int[] arr = Arrays.copyOf(A, A.length);
		Stack<int[]> sta = new Stack<int[]>();
		for (int i = A.length - 1; i >= 0; i--) {
			if (sta.isEmpty() || A[i] <= sta.peek()[0]) {
				sta.push(new int[] { A[i], i });
			} else {
				int[] tem = new int[2];
				while (!sta.isEmpty() && A[i] > sta.peek()[0]) {
					tem = sta.pop();
				}
				int temp = arr[i];
				arr[i] = arr[tem[1]];
				arr[tem[1]]=temp;
				return arr;
			}
		}
		return arr;
	}

}
