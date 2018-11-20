package Leetcode_088_MergeSortedArray;

import UsualMethod.ArrayUtil;

/*

	�������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣

	˵��:	
		��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
		����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
		ʾ��:
	
	����:
		nums1 = [1,2,3,0,0,0], m = 3
		nums2 = [2,5,6],       n = 3	
	���: [1,2,2,3,5,6]
*/
public class MergeSortedArray {
	
	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = {4,5,6,0,0,0};
		int m = 3;
		int[] nums2 = {1,2,3};
		int n = 3;
		msa.merge(nums1, m, nums2, n);
	}
	// 88.�ϲ�������������
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for(int i = m;i<nums1.length;i++) {			
			nums1[i] = nums2[i-m];
			int j = i;
			while((m>0)&&(j>0)&&(nums1[j]<nums1[j-1])) {
				ArrayUtil.exchange(nums1, j, j-1);
				j--;
			}
		}
	}
	
	
	//ð������
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		// �������������·���һ����������
		for (int i = 0; i < n; i++) {
			nums1[m + i] = nums2[i];
		}
		for (int i = 1; i < nums1.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums1[i] < nums1[j]) {
					int temp = nums1[i];
					nums1[i] = nums1[j];
					nums1[j] = temp;
				}
			}
		}
	}
}
