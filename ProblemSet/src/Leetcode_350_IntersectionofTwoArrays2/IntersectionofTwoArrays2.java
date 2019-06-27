package Leetcode_350_IntersectionofTwoArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// 1ms
	public int[] intersect0(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}

		int[] ret1 = new int[Math.max(nums1.length, nums2.length)];
		int len1 = 0;
		boolean[] bl1 = new boolean[ret1.length];
		for (int i = 0; i < nums2.length; i++) {
			int start = 0;
			while ((start = find(nums1, nums2[i], start)) != -1) {
				if (bl1[start] == false) {
					ret1[len1++] = nums2[i];
					bl1[start] = true;
					break;
				}
				start++;
			}
		}

		int[] ret = new int[len1];
		for (int i = 0; i < len1; i++) {
			ret[i] = ret1[i];
		}

		return ret;

	}

	public int find(int[] nums, int val, int i) {
		for (; i < nums.length; i++) {
			if (nums[i] == val) {
				return i;
			}
		}
		return -1;

	}

	// 1ˢ
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

	//
	public int[] intersect3(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map1 = new HashMap<>();
		for (int i : nums1) {
			map1.put(i, map1.getOrDefault(i, 0) + 1);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : nums2) {
			if (map1.containsKey(i) && map1.get(i) > 0) {
				list.add(i);
				map1.put(i, map1.get(i) - 1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}
