package Leetcode_384_ShuffleanArray;

import java.util.Arrays;
import java.util.Random;

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
	
	// 384. ��������	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		ShuffleanArray sa = new ShuffleanArray(nums);
		int[] reset = sa.reset();
		int[] cur = sa.shuffle();
	}

	// ��ʼ������
	private int[] orgn;// ���ڱ��������ԭʼ˳��
	private int[] cur;

	//���캯��
	public ShuffleanArray(int[] nums) {
		//����ԭ����
        orgn = nums;
    }

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return orgn;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		//��ȡԭ����ĳ���
		int len = orgn.length;
		//������������
		cur = new int[len];
		//
		for (int i = 0; i < len; i++) {
			cur[i] = orgn[i];			
		}			
		// ��¼Ҫ����Ԫ�ص�λ��
		int pos;
		// ��¼Ҫ������ֵ
		int temp; 
		//�����������
		Random ran = new Random();
		for (int i = len - 1; i >= 0; i--) {
			//0-i�����
			pos = ran.nextInt(i + 1);
			//����
			temp = cur[pos];
			cur[pos] = cur[i];
			cur[i] = temp;
		}
		return cur;
	}
}

/**
 * Your Solution object will be instantiated and called as such: 
 * Solution obj =  new Solution(nums); 
 * int[] param_1 = obj.reset(); 
 * int[] param_2 = obj.shuffle();
 */
