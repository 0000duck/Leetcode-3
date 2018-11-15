package Leetcode_136_SingleNumber;

import java.util.Arrays;

/*
	����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
	
	˵����	
		����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
	
	ʾ�� 1:	
		����: [2,2,1]
		���: 1
	ʾ�� 2:	
		����: [4,1,2,1,2]
���: 4
 */
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1 };
		System.out.println(new SingleNumber().singleNumber(nums));
	}

	// 136. ֻ����һ�ε�����
	public int singleNumber(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		// ����
		Arrays.sort(nums);
		// ����
		for (int i = 0; i < nums.length; i++) {
			// 0
			if (i == 0) {
				if (nums[i] != nums[i + 1]) {
					return nums[i];
				} else {
					i++;
				}
			}
			// nums.length-1
			if (i == nums.length - 1) {
				if (nums[i] != nums[i - 1]) {
					return nums[i];
				}
			}
			if ((nums[i - 1] != nums[i]) && (nums[i] != nums[i + 1])) {
				return nums[i];
			}
		}
		return 0;
	}

}
