package Leetcode_055_JumpGame;

/*
	����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�	
	�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�	
	�ж����Ƿ��ܹ��������һ��λ�á�	
	
	ʾ�� 1:	
		����: [2,3,1,1,4]
		���: true
		����: ��λ�� 0 �� 1 �� 1 ��, Ȼ���� 3 ���������һ��λ�á�
	ʾ�� 2:	
		����: [3,2,1,0,4]
		���: false
		����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�
 */

//55.��Ծ��Ϸ
public class JumpGame {
	public boolean canJump(int[] nums) {
		// ����ܵ���λ��
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			// ��ǰλ�ò��ܵ���
			if (i > max) {
				return false;
			}
			// ��i��λ���ܵ������Զ�ĵط�
			max = Math.max(nums[i] + i, max);
			if (max >= nums.length - 1) {
				return true;
			}
		}
		return true;
	}

	// 4ms
	public boolean canJump0(int[] nums) {
		int index = nums.length - 2;
		int min = nums.length - 1;
		while (index >= 0) {
			if (index + nums[index] >= min)
				min = index;
			index--;
		}
		return min == 0;
	}
}
