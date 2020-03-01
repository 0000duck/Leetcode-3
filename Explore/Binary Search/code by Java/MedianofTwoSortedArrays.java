package Leetcode_004_MedianofTwoSortedArrays;

import Leetcode_448_FindAllNumbersDisappearedinanArray.FindAllNumbersDisappearedinanArray;

/*
	����������СΪ m �� n ���������� nums1 �� nums2 ��
	���ҳ������������������λ����Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log (m+n)) ��
	����Լ��� nums1 �� nums2 ��ͬʱΪ�ա�
	
	ʾ�� 1:
		nums1 = [1, 3]
		nums2 = [2]
		��λ���� 2.0
		
	ʾ�� 2:
		nums1 = [1, 2]
		nums2 = [3, 4]
		��λ���� (2 + 3)/2 = 2.5
*/
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1,3 };
		int[] nums2 = { 2};
		MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
		System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
	}

	// 4.���������������λ��
	/*
	 * ˼·�� ��������ĳ��Ⱥͣ�size�� �����ż����Ӧ���ҵ���size/2�͵�size/2+1������������ƽ��
	 * �����������Ӧ���ҵ���size/2+1������������λ�� ����ת��Ϊ���ҵ�˫�����еĵ�k���� �����������зֱ�ȡ��ǰk/2������
	 * �Ƚ������ֵ��С����һ�飬һ������ǰk������ ���������
	 * �϶̵�һ���Ѿ�ȫ������ǰk�����У���ʱlen1-start1==0,��k��Ϊnums2[k-1]; ���k ==
	 * 1,���ʾǰk-1С�����Ѿ��ҹ��ˣ����k�����϶���nums1[start1]��nums2[start2]�н�С���Ǹ�����
	 *  
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// ��ȡnums1�ĳ���
		int length1 = nums1.length;
		// ��ȡnums2�ĳ���
		int length2 = nums2.length;
		// �ܳ���
		int size = length1 + length2;
		// �ܳ���Ϊż��
		if (size % 2 == 0) {
			// �ܳ���Ϊż��
			return (findKth(nums1, 0, length1, nums2, 0, length2, size / 2) + findKth(nums1, 0, length1, nums2, 0, length2, size / 2 + 1)) / 2;
		} else {
			// �ܳ���Ϊ����
			return findKth(nums1, 0, length1, nums2, 0, length2, size / 2 + 1);
		}
	}

	public double findKth(int[] nums1, int start1, int len1, int[] nums2, int start2, int len2, int k) {
		// ��֤�϶̵���ǰ��
		if (len1 - start1 > len2 - start2) {
			return findKth(nums2, start2, len2, nums1, start1, len1, k);
		}
		// len1-start1==0,��k��Ϊnums2[k-1];
		if (len1 - start1 == 0) {
			return nums2[k - 1];
		}
		// k==1
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		// ��Ҫ�Ƚϵ�λ,p1=start1+k/2,p2=start2+k-k/2
		int p1 = start1 + Math.min(len1 - start1, k / 2);// ��ֹnums1����
		int p2 = start2 + k - (p1 - start1);
		if (nums1[p1 - 1] > nums2[p2 - 1]) {
			return findKth(nums1, start1, len1, nums2, p2, len2, k - p2 + start2);
		} else if (nums1[p1 - 1] < nums2[p2 - 1]) {
			return findKth(nums1, p1, len1, nums2, start2, len2, k - p1 + start1);
		} else {
			return nums1[p1 - 1];
		}
	}

}
