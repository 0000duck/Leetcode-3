package Leetcode_155_MinStack;

import java.util.Stack;

/*
	���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
	
	push(x) -- ��Ԫ�� x ����ջ�С�
	pop() -- ɾ��ջ����Ԫ�ء�
	top() -- ��ȡջ��Ԫ�ء�
	getMin() -- ����ջ�е���СԪ�ء�
	
	ʾ��:	
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();   --> ���� -3.
		minStack.pop();
		minStack.top();      --> ���� 0.
		minStack.getMin();   --> ���� -2.
 */

//155. ��Сջ
class MinStack {

	Stack<int[]> s;
	int min;

	/** initialize your data structure here. */
	public MinStack() {
		s = new Stack<int[]>();
	}

	public void push(int x) {
		if (s.isEmpty()) {
			min = x;
			s.push(new int[] { x, min });
		} else if (x < min) {
			min = x;
			s.push(new int[] { x, min });
		} else {
			s.push(new int[] { x, min });
		}
	}

	public void pop() {
		s.pop();
		if (!s.isEmpty()) {
			min = s.peek()[1];
		}

	}

	public int top() {
		return s.peek()[0];
	}

	public int getMin() {
		return s.peek()[1];
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */