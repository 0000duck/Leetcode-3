package Leetcode_384_ShuffleanArray;

import java.util.Arrays;

/*
	����һ��û���ظ�Ԫ�ص����顣
	
	ʾ��:	
		// �����ּ��� 1, 2 �� 3 ��ʼ�����顣
		int[] nums = {1,2,3};
		Solution solution = new Solution(nums);
		
		// �������� [1,2,3] �����ؽ�����κ� [1,2,3]�����з��صĸ���Ӧ����ͬ��
		solution.shuffle();
		
		// �������鵽���ĳ�ʼ״̬[1,2,3]��
		solution.reset();
		
		// �����������[1,2,3]���Һ�Ľ����
		solution.shuffle();
 */
public class ShuffleanArray {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	
	//��ʼ������
	private int[] orgn;//���ڱ��������ԭʼ˳��	
	private int[] cur;
	
	// 384. ��������
	public Solution(int[] nums) {
        orgn = nums;
    }

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return orgn;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		
	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
