package Leetcode_496_NextGreaterElementI;

import java.util.HashMap;
import java.util.Stack;

/*
	��������û���ظ�Ԫ�ص����� nums1 �� nums2 ��
	����nums1 �� nums2 ���Ӽ���
	�ҵ� nums1 ��ÿ��Ԫ���� nums2 �е���һ��������ֵ��
	
	nums1 ������ x ����һ������Ԫ����ָ x �� nums2 �ж�Ӧλ�õ��ұߵĵ�һ���� x ���Ԫ�ء���������ڣ���Ӧλ�����-1��
	
	ʾ�� 1:	
		����: nums1 = [4,1,2], nums2 = [1,3,4,2].
		���: [-1,3,-1]
	����:
		����num1�е�����4�����޷��ڵڶ����������ҵ���һ����������֣������� -1��
		����num1�е�����1���ڶ�������������1�ұߵ���һ���ϴ������� 3��
		����num1�е�����2���ڶ���������û����һ����������֣������� -1��
	ʾ�� 2:	
		����: nums1 = [2,4], nums2 = [1,2,3,4].
		���: [3,-1]
	����:
	  	����num1�е�����2���ڶ��������е���һ���ϴ�������3��
	 	����num1�е�����4���ڶ���������û����һ����������֣������� -1��
	ע��:	
		nums1��nums2������Ԫ����Ψһ�ġ�
		nums1��nums2 �������С��������1000��
 */
//496. ��һ������Ԫ�� I
public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int length = nums1.length;
		int[] res = new int[length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums2.length - 1; i++) {
			for (int j = i + 1; j < nums2.length; j++) {
				if (nums2[j] > nums2[i]) {
					map.put(nums2[i], nums2[j]);
					break;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			if (map.containsKey(nums1[i])) {
				res[i] = map.get(nums1[i]);
			} else {
				res[i] = -1;
			}
		}
		return res;
	}
}
