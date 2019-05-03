package Leetcode_503_NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

/*
	����һ��ѭ�����飨���һ��Ԫ�ص���һ��Ԫ��������ĵ�һ��Ԫ�أ���
	���ÿ��Ԫ�ص���һ������Ԫ�ء����� x ����һ�������Ԫ���ǰ��������˳��
	�������֮��ĵ�һ�������������������ζ����Ӧ��ѭ��������������һ�����������
	��������ڣ������ -1��
	
	ʾ�� 1:	
		����: [1,2,1]
		���: [2,-1,2]
		����: ��һ�� 1 ����һ����������� 2��
		���� 2 �Ҳ�����һ����������� 
		�ڶ��� 1 ����һ����������Ҫѭ�����������Ҳ�� 2��
	ע��: ��������ĳ��Ȳ��ᳬ�� 10000��
 */
//503. ��һ������Ԫ�� II
public class NextGreaterElementII {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 1 };
		new NextGreaterElementII().nextGreaterElements(nums);
	}

	public int[] nextGreaterElements(int[] nums) {
		int length = nums.length;
		int[] res = new int[length];
		Arrays.fill(res, -1);
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < length * 2; i++) {
			int n = nums[i % length];
			while (!stack.isEmpty() && stack.peek()[0] < n) {
				res[stack.peek()[1]] = n;
				stack.pop();
			}
			stack.push(new int[] { n, i % length });
		}
		return res;
	}

	// 6ms
	public int[] nextGreaterElements0(int[] nums) {
		int[] stack = new int[nums.length * 2];
		// a = nums*2
		int[] a = new int[nums.length * 2];
		// ���
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[i] = a[i + nums.length] = nums[i];
		}
		Arrays.fill(res, -1);
		int top = 0;
		int j = 0;
		while (j < a.length) {
			if (top == 0) {
				stack[top++] = j;
			} else {
				while (top > 0 && a[j] > a[stack[top - 1]]) {
					if (stack[top - 1] >= nums.length)
						res[stack[top - 1] - nums.length] = a[j];
					else
						res[stack[top - 1]] = a[j];
					top--;
				}
				stack[top++] = j;
			}
			j++;
		}
		return res;
	}
}
