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
	
	//��ʱ
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> mapa = arrToMap(A);
		Map<Integer, Integer> mapb = arrToMap(B);
		Map<Integer, Integer> mapc = arrToMap(C);
		Map<Integer, Integer> mapd = arrToMap(D);
		int count = 0;
		for (Integer a : mapa.keySet()) {
			for (Integer b : mapb.keySet()) {
				for (Integer c : mapc.keySet()) {
					for (Integer d : mapd.keySet()) {
						if (a + b + c + d == 0) {
							count += mapa.get(a) * mapb.get(b) * mapc.get(c) * mapd.get(d);
						}
					}
				}
			}
		}
		return count;
	}

	// ���������map
	public Map<Integer, Integer> arrToMap(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int value = map.get(arr[i]) + 1;
				map.put(arr[i], value);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map;
	}

}
