package Leetcode_225_ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

/*
	ʹ�ö���ʵ��ջ�����в�����	
		push(x) -- Ԫ�� x ��ջ
		pop() -- �Ƴ�ջ��Ԫ��
		top() -- ��ȡջ��Ԫ��
		empty() -- ����ջ�Ƿ�Ϊ��
	
	ע��:	
		��ֻ��ʹ�ö��еĻ�������-- Ҳ���� push to back, peek/pop from front, size, �� is empty ��Щ�����ǺϷ��ġ�
		����ʹ�õ�����Ҳ��֧�ֶ��С� �����ʹ�� list ���� deque��˫�˶��У���ģ��һ������ , ֻҪ�Ǳ�׼�Ķ��в������ɡ�
		����Լ������в���������Ч�ģ�����, ��һ���յ�ջ������� pop ���� top ��������
 */

//225. �ö���ʵ��ջ
class ImplementStackusingQueues {

	Queue<Integer> queue;
	Queue<Integer> queue2;
	public int peek;

	/** Initialize your data structure here. */
	public MyStack() {
		queue = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		peek = x;
		queue.offer(x);

	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		while (queue.size() > 1) {
			queue2.offer(queue.poll());
		}
		int pop = queue.poll();
		while (!queue2.isEmpty()) {
			queue.offer(queue2.poll());
		}
		return pop;
	}

	/** Get the top element. */
	public int top() {
		while (queue.size() > 1) {
			queue2.offer(queue.poll());
		}
		int pop = queue.poll();
		while (!queue2.isEmpty()) {
			queue.offer(queue2.poll());
		}
		queue.offer(pop);
		return pop;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */