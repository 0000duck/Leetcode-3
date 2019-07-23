package Leetcode_1122_RelativeSortArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
	�����������飬arr1 �� arr2��	
		arr2 �е�Ԫ�ظ�����ͬ
		arr2 �е�ÿ��Ԫ�ض������� arr1 ��
		�� arr1 �е�Ԫ�ؽ�������ʹ arr1 ��������˳��� arr2 �е����˳����ͬ��
		δ�� arr2 �г��ֹ���Ԫ����Ҫ����������� arr1 ��ĩβ��
	
	 
	
	ʾ����	
		���룺arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
		�����[2,2,2,1,4,3,3,9,6,7,19]
	 
	
	��ʾ��	
		arr1.length, arr2.length <= 1000
		0 <= arr1[i], arr2[i] <= 1000
		arr2 �е�Ԫ�� arr2[i] ������ͬ
		arr2 �е�ÿ��Ԫ�� arr2[i] �������� arr1 ��
 */
//1122. ������������
public class RelativeSortArray {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			map.put(arr2[i], i);
		}
		Integer[] arr = new Integer[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr[i] = arr1[i];
		}
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int score1 = map.getOrDefault(o1, arr2.length + o1);
				int score2 = map.getOrDefault(o2, arr2.length + o2);
				return score1 - score2;
			}
		});

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i];
		}
		return arr1;

	}
}
