package Leetcode_384_ShuffleanArray;

import java.util.Arrays;

/*
	打乱一个没有重复元素的数组。
	
	示例:	
		// 以数字集合 1, 2 和 3 初始化数组。
		int[] nums = {1,2,3};
		Solution solution = new Solution(nums);
		
		// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
		solution.shuffle();
		
		// 重设数组到它的初始状态[1,2,3]。
		solution.reset();
		
		// 随机返回数组[1,2,3]打乱后的结果。
		solution.shuffle();
 */
public class ShuffleanArray {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	
	//初始化数组
	private int[] orgn;//用于保存数组的原始顺序	
	private int[] cur;
	
	// 384. 打乱数组
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
