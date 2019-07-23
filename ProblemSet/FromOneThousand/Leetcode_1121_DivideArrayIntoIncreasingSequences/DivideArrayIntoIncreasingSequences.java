package Leetcode_1121_DivideArrayIntoIncreasingSequences;

import java.util.Arrays;
import java.util.HashMap;

/*
	����һ�� �ǵݼ� ������������ nums ������ K���жϸ������Ƿ���Ա��ֳ�һ���򼸸� �������� Ϊ K �� ���ཻ�ĵ��������С� 
	
	ʾ�� 1��
		���룺nums = [1,2,2,3,3,4,4], K = 3
		�����true
		���ͣ�
			��������Էֳ����������� [1,2,3,4] �� [2,3,4]��ÿ�������еĳ��ȶ������� 3��
	ʾ�� 2��
		���룺nums = [5,6,6,7,8], K = 3
		�����false
		���ͣ�
			û�а취�����������������顣
	
	��ʾ��
		1 <= nums.length <= 10^5
		1 <= K <= nums.length
		1 <= nums[i] <= 10^5
 */

//1121. ������ֳɼ�����������
public class DivideArrayIntoIncreasingSequences {
	public boolean canDivideIntoSubsequences2(int[] nums, int K) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxCount = Integer.MIN_VALUE;
		for (int i : nums) {
			int count = map.getOrDefault(i, 0) + 1;
			map.put(i, count);
			maxCount = Math.max(maxCount, count);
		}
		return nums.length >= maxCount * K;
	}
}
