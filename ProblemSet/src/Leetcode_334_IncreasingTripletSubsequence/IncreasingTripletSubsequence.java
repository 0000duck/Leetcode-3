package Leetcode_334_IncreasingTripletSubsequence;

/*
	����һ��δ��������飬�ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�
	
	��ѧ���ʽ����:	
		������������� i, j, k,  ������ 0 �� i < j < k �� n-1��
		ʹ�� arr[i] < arr[j] < arr[k] ������ true ; ���򷵻� false ��
	
	˵��: Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1) ��
	
	ʾ�� 1:	
		����: [1,2,3,4,5]
		���: true
	
	ʾ�� 2:	
		����: [5,4,3,2,1]
		���: false
 */

//334.��������Ԫ������
public class IncreasingTripletSubsequence {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
		its.increasingTriplet(nums);		
	}
	public boolean increasingTriplet(int[] nums) {
		// start with two largest values, as soon as we find a number bigger than both,
		// while both have been updated, return true.
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} // update small if n is smaller than both
			else if (n <= big) {
				big = n;
			} // update big only if greater than small but smaller than big
			else
				return true; // return if you find a number bigger than both
		}
		return false;
	}
}
