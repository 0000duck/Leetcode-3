package Leetcode_1133_LargestUniqueNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.TreeMap;

/*
	����һ���������� A�����ҳ��������ڸ������н�����һ�ε����������
	������������ֻ����һ�ε��������򷵻� -1��
	
	ʾ�� 1��
		���룺[5,7,3,9,4,9,8,3,1]
		�����8
		���ͣ� 
			���������������� 9���������������ظ������ˡ����ڶ���������� 8����ֻ������һ�Σ����Դ��� 8��
	ʾ�� 2��
		���룺[9,9,8,8]
		�����-1
		���ͣ� 
			�����в����ڽ�����һ�ε�������
	
	��ʾ��
		1 <= A.length <= 2000
		0 <= A[i] <= 1000
 */
public class LargestUniqueNumber {
	public int largestUniqueNumber1(int[] A) {
		TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int i : A) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		return -1;

	}

	public int largestUniqueNumber(int[] A) {
		if (A == null) {
			return -1;
		}
		if (A.length == 1) {
			return A[0];
		}
		Arrays.sort(A);
		Stack<Integer> stack = new Stack<>();
		boolean flag = false;
		int res = -1;
		for (int i = A.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				stack.push(A[i]);
			} else if (A[i] == stack.peek()) {
				flag = true;// �ظ�
			} else if (A[i] != stack.peek()) {
				if (!flag) {
					res = stack.peek();
					break;
				}
				stack.pop();
				flag = false;// false
				stack.push(A[i]);
			}
		}
		if (!stack.isEmpty() && !flag) {
			res = stack.peek();
		}
		return res;
	}
}
