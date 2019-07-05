package Leetcode_454_FourSum2;

import java.util.HashMap;
import java.util.Map;

/*
	�����ĸ����������������б� A , B , C , D ,�����ж��ٸ�Ԫ�� (i, j, k, l) ��ʹ�� A[i] + B[j] + C[k] + D[l] = 0��
	
	Ϊ��ʹ����򵥻������е� A, B, C, D ������ͬ�ĳ��� N���� 0 �� N �� 500 �����������ķ�Χ�� -2^28 �� 2^28 - 1 ֮�䣬���ս�����ᳬ�� 231 - 1 ��
	
	����:	
		����:
			A = [ 1, 2]
			B = [-2,-1]
			C = [-1, 2]
			D = [ 0, 2]	
		���:
			2	
		����:
			����Ԫ������:
			1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
			2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSum2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		new FourSum2().fourSumCount(A, B, C, D);
	}

	// 454. ������� II
	// ��a+b����map O(N^2)
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a : A) {
			for (int b : B) {
				map.put(a + b, map.getOrDefault(a + b, 0) + 1);
			}
		}
		int res = 0;
		for (int c : C) {
			for (int d : D) {
				res += map.getOrDefault(-c - d, 0);
			}
		}
		return res;
	}
}
