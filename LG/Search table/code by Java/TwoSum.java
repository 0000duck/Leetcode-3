package Leetcode_001_TwoSum;

import java.util.HashMap;
import java.util.Map;

/*
 	����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
	����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
	ʾ��
		���� nums = [2, 7, 11, 15], target = 9
		��Ϊ nums[0] + nums[1] = 2 + 7 = 9
		���Է��� [0, 1]
 */
public class TwoSum {
	// 1.����֮��
	// ˫������ײ
	// ������󣬺�ʹ��˫������ײ��ʱ�临�Ӷ�Ϊ��O(n log n) + O(n) = O(n log n)�� ������һ�ԣ�Ҳ�ǿ��� AC �ġ�
	public int[] twoSum3(int[] nums, int target) {
		return new int[] {-1,-1};
	}

	// ʹ�ò��ұ�
	// ������Ԫ�ط�����ұ�֮�����ÿһ��Ԫ�� a������ target - a �Ƿ���ڡ�
	public int[] twoSum2(int[] nums, int target) {
		int[] result = { -1, -1 };
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (hm.containsKey(temp)) {
				result[0] = i;
				result[1] = hm.get(temp);
				return result;
			}
			hm.put(nums[i], i);
		}
		return result;
	}

	// 1ˢ
	// �����ⷨ
	// �����������ݶԣ��ж��Ƿ���� target��ʱ�临�Ӷȶ� O(n^2)��
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

}
