package Leetcode_674_LongestContinuousIncreasingSubsequence;

/*
	����һ��δ��������������飬�ҵ���������ĵĵ������С�
	
	ʾ�� 1:	
		����: [1,3,5,4,7]
		���: 3
		����: ��������������� [1,3,5], ����Ϊ3��
		���� [1,3,5,7] Ҳ�������������, �������������ģ���Ϊ5��7��ԭ�����ﱻ4������ 
		
	ʾ�� 2:	
		����: [2,2,2,2,2]
		���: 1
		����: ��������������� [2], ����Ϊ1��
	ע�⣺���鳤�Ȳ��ᳬ��10000��
*/
public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		// ��ȡ���鳤��
		int length = nums.length;
		// ������
		if (length == 0) {
			return 0;
		} else if (length == 1) {
			return 1;
		}
		// ������󳤶�
		int maxlength = 0;

		// ������
		int count = 1;
		// ��������
		for (int i = 1; i < length; i++) {
			if (nums[i] > nums[i - 1]) {
				count++;
			} else {
				maxlength = Math.max(count, maxlength);
				count = 1;
			}
		}
		maxlength = Math.max(count, maxlength);
		return maxlength;
	}
}
