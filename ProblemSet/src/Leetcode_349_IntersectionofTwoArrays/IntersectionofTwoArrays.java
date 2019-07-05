package Leetcode_349_IntersectionofTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/*
	�����������飬��дһ���������������ǵĽ�����
	
	ʾ�� 1:	
		����: nums1 = [1,2,2,1], nums2 = [2,2]
		���: [2]
	ʾ�� 2:	
		����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		���: [9,4]
	˵��:	
		�������е�ÿ��Ԫ��һ����Ψһ�ġ�
		���ǿ��Բ�������������˳��
*/
public class IntersectionofTwoArrays {

	public static void main(String[] args) {

	}

	// 349. ��������Ľ���
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				set2.add(nums2[i]);
			}
		}
		if (set2.size() == 0) {
			return new int[0];
		}
		int[] result = new int[set2.size()];
		int i = 0;
		for (Integer x : set2) {
			result[i++] = x;
		}
		return result;
	}

	// 1ms
	public int[] intersection0(int[] nums1, int[] nums2) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		// �������nums1�����ֵ ����Сֵ
		for (int i = 0; i < nums1.length; i++) {
			max = max < nums1[i] ? nums1[i] : max;
			min = min > nums1[i] ? nums1[i] : min;
		}
		// ���
		boolean[] booleanArray = new boolean[max - min + 1];
		for (int i = 0; i < nums1.length; i++) {
			booleanArray[nums1[i] - min] = true;
		}
		int index = 0;
		int[] tempArray = new int[nums2.length];
		for (int i = 0; i < nums2.length; i++) {
			// �ҳ�nums2�е�Ԫ�أ���Ǹ�Ϊfalse
			if (!(nums2[i] < min) && !(nums2[i] > max) && booleanArray[nums2[i] - min]) {
				booleanArray[nums2[i] - min] = false;
				// �ҳ���ͬ������
				tempArray[index++] = nums2[i];
			}
		}
		// ����
		return Arrays.copyOf(tempArray, index);
	}

	// 1ˢ
	// ���ϵĴ���ʽ������set��map
	// set
	public int[] intersection(int[] nums1, int[] nums2) {
		// ����set
		Set<Integer> nums = new HashSet<Integer>();
		Set<Integer> result = new HashSet<>();
		// ������nums2���뼯��nums
		for (int i = 0; i < nums2.length; i++) {
			nums.add(nums2[i]);
		}
		// ����nums1,�ҵ�����,���뼯��result
		for (int i = 0; i < nums1.length; i++) {
			if (nums.contains(nums1[i])) {
				result.add(nums1[i]);
			}
		}
		// ������ת��Ϊ���飬ʹ�õ�����
		int[] res = new int[result.size()];
		// ������
		Iterator iter = result.iterator();
		int i = 0;
		while (iter.hasNext()) {
			res[i++] = (int) iter.next();
		}
		return res;
	}

	// Map
	public int[] intersectionMap(int[] nums1, int[] nums2) {
		// ����Map:����ֵһһӳ��
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// ����һ����̬����
		Vector<Integer> ret = new Vector<>();
		// ����һ��������Ϊ��ֵ����
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], 1);
		}
		// ����nums2,�ж��Ƿ���ڼ�ֵ
		// �������ȡ����ֵ������������
		for (int i = 0; i < nums2.length; i++) {
			// �������
			if (map.containsKey(nums2[i])) {
				if (map.get(nums2[i]) == 1) {
					ret.add(nums2[i]);
					map.put(nums2[i], 0);
				}

			}
		}
		// ����������
		int[] result = new int[ret.size()];
		// ���������
		Iterator<Integer> iter = ret.iterator();
		int i = 0;
		while (iter.hasNext()) {
			result[i++] = iter.next();
		}
		return result;

	}
	
}
