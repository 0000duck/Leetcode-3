package Leetcode_015_ThreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	����һ������ n ������������ nums��
	�ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ����
	���������������Ҳ��ظ�����Ԫ�顣
	
	ע�⣺���в����԰����ظ�����Ԫ�顣
	
	����, �������� nums = [-1, 0, 1, 2, -1, -4]��
	
	����Ҫ�����Ԫ�鼯��Ϊ��
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	// 15. ����֮��
	public List<List<Integer>> threeSum(int[] nums) {		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int temp:nums) {
			map.put(temp, map.getOrDefault(temp, 0)+1);
		}
		
		return result;
	}

}
