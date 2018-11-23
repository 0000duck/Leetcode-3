package Leetcode_350_IntersectionofTwoArrays2;

import java.util.Arrays;



/*
	�����������飬��дһ���������������ǵĽ�����
	
	ʾ�� 1:	
		����: nums1 = [1,2,2,1], nums2 = [2,2]
		���: [2,2]
	ʾ�� 2:	
		����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		���: [4,9]
	˵����	
		��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡�
		���ǿ��Բ�������������˳��
	����:	
		��������������Ѿ��ź����أ��㽫����Ż�����㷨��
		��� nums1 �Ĵ�С�� nums2 С�ܶ࣬���ַ������ţ�
		��� nums2 ��Ԫ�ش洢�ڴ����ϣ������ڴ������޵ģ������㲻��һ�μ������е�Ԫ�ص��ڴ��У������ô�죿
*/
public class IntersectionofTwoArrays2 {

	public static void main(String[] args) {
		
	}

	// 350. ��������Ľ��� II
	public int[] intersect(int[] nums1, int[] nums2) {
		// nums2��nums1С
		int length1 = nums1.length;
		int length2 = nums2.length;
		if (length1 > length2) {
			return intersect(nums2, nums1);
		}
		// �����������
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		int count = 0;
		// ����С����
		for (; i < length1; i++) {
			// ��������
			for (; j < length2; j++) {
				if (nums1[i] == nums2[j]) {
					nums1[count++] = nums2[j];
					j++;
					break;
				}
				if (nums1[i] < nums2[j]) {
					break;
				}

			}
		}
		// ��������
		int[] result = new int[count];
		for (int x = 0; x < count; x++) {
			result[x] = nums1[x];
		}
		return result;

	}

}
