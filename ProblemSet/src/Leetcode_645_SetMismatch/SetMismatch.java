package Leetcode_645_SetMismatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
	���� S ������1�� n ��������
	���ҵ��ǣ���Ϊ���ݴ��󣬵��¼�������ĳһ��Ԫ�ظ����˳��˼������������һ��Ԫ�ص�ֵ�����¼��϶�ʧ��һ������������һ��Ԫ���ظ���	
	����һ������ nums �����˼��� S ���������Ľ����
	�������������Ѱ�ҵ��ظ����ֵ����������ҵ���ʧ�����������������������ʽ���ء�
	
	ʾ�� 1:	
		����: nums = [1,2,2,4]
		���: [2,3]
	
	ע��:	
		��������ĳ��ȷ�Χ�� [2, 10000]��
		����������������ġ�
 */
public class SetMismatch {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] nums = { 1, 2, 2, 4 };
		new SetMismatch().findErrorNums(nums);
	}

	// 645. ����ļ���
	public int[] findErrorNums(int[] nums) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int key : nums) {
			if (map.containsKey(key)) {
				result[0] = key;
			} else {
				map.put(key, key);
			}
		}
		for (int i = 1; i <= nums.length; i++) {
			if (!map.containsKey(i)) {
				result[1] = i;
				break;
			}
		}

		return result;

	}

	// 5ms
	public int[] findErrorNums0(int[] nums) {
		int[] nums2 = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			nums2[nums[i]]++;
		}
		int repeat = 0, lose = 0;
		for (int i = 1; i < nums2.length; i++) {
			if (nums2[i] == 2)
				repeat = i;
			else if (nums2[i] == 0)
				lose = i;
			if (repeat != 0 && lose != 0)
				break;
		}
		return new int[] { repeat, lose };
	}

}
