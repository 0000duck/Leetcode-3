package Leetcode_594_LongestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

/*
	��г������ָһ��������Ԫ�ص����ֵ����Сֵ֮��Ĳ��������1��	
	���ڣ�����һ���������飬����Ҫ�����п��ܵ����������ҵ���ĺ�г�����еĳ��ȡ�
	
	ʾ�� 1:	
		����: [1,3,2,2,5,2,3,7]
		���: 5
	ԭ��:
		��ĺ�г�����ǣ�[3,2,2,2,3].
	˵��: 
		��������鳤����󲻳���20,000.
 */
public class LongestHarmoniousSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,2,2,5,2,3,7};
		System.out.println(new LongestHarmoniousSubsequence().findLHS(nums));
	}

	// 594. ���г������
	public int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int maxLength = Integer.MIN_VALUE;
		for (int i = min; i <= max; i++) {
			int count = 0;
			if(map.containsKey(i+1)&&(map.containsKey(i))) {
				count += map.get(i)+map.get(i+1);
				maxLength = Math.max(count, maxLength);
			}
		}
		return maxLength;
	}

}
