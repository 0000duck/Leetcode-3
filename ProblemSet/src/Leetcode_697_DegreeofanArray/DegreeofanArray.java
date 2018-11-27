package Leetcode_697_DegreeofanArray;

import java.util.HashMap;
import java.util.Set;

/*
	����һ���ǿ���ֻ�����Ǹ������������� nums, ����ĶȵĶ�����ָ��������һԪ�س���Ƶ�������ֵ��	
	����������ҵ��� nums ӵ����ͬ��С�Ķȵ�������������飬�����䳤�ȡ�
	
	ʾ�� 1:	
		����: [1, 2, 2, 3, 1]
		���: 2
		����: 
		��������Ķ���2����ΪԪ��1��2�ĳ���Ƶ����󣬾�Ϊ2.
		��������������ӵ����ͬ�ȵ���������ʾ:
		[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
		�������������[2, 2]�ĳ���Ϊ2�����Է���2.
	
	ʾ�� 2:	
		����: [1,2,2,3,1,4,2]
		���: 6
		
	ע��:	
		nums.length ��1��50,000���䷶Χ�ڡ�
		nums[i] ��һ����0��49,999��Χ�ڵ�������
 */
public class DegreeofanArray {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		DegreeofanArray da = new DegreeofanArray();
		int[] nums = { 1 };
		da.findShortestSubArray(nums);
	}

	// 697. ����Ķ�
	public int findShortestSubArray(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int result = Integer.MAX_VALUE;
		int maxCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int temp = map.get(nums[i]);
				temp++;
				map.put(nums[i], temp);
				maxCount = Math.max(maxCount, temp);
			} else {
				map.put(nums[i], 1);
				maxCount = Math.max(maxCount, 1);
			}
		}
		Set<Integer> set = map.keySet();
		int maxCountNum = 0;
		for (Integer temp : set) {
			if (map.get(temp) == maxCount) {
				maxCountNum = temp;
				int minindex = 0;
				int maxindex = 0;
				for (int i = 0; i < nums.length; i++) {
					if (nums[i] == maxCountNum) {
						minindex = i;
						break;
					}
				}
				for (int j = nums.length - 1; j >= 0; j--) {
					if (nums[j] == maxCountNum) {
						maxindex = j;
						break;
					}
				}
				result = Math.min(result, maxindex - minindex + 1);
			}
		}
		return result;
	}

}
