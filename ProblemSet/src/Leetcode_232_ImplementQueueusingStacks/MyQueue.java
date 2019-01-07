package Leetcode_232_ImplementQueueusingStacks;

import java.util.Stack;

/*
	ʹ��ջʵ�ֶ��е����в�����	
		push(x) -- ��һ��Ԫ�ط�����е�β����
		pop() -- �Ӷ����ײ��Ƴ�Ԫ�ء�
		peek() -- ���ض����ײ���Ԫ�ء�
		empty() -- ���ض����Ƿ�Ϊ�ա�
	
	ʾ��:	
		MyQueue queue = new MyQueue();
		
		queue.push(1);
		queue.push(2);  
		queue.peek();  // ���� 1
		queue.pop();   // ���� 1
		queue.empty(); // ���� false
	
	˵��:	
		��ֻ��ʹ�ñ�׼��ջ���� -- Ҳ����ֻ�� push to top, peek/pop from top, size, �� is empty �����ǺϷ��ġ�
		����ʹ�õ�����Ҳ��֧��ջ�������ʹ�� list ���� deque��˫�˶��У���ģ��һ��ջ��ֻҪ�Ǳ�׼��ջ�������ɡ�
		�������в���������Ч�� �����磬һ���յĶ��в������ pop ���� peek ��������
 */
//232. ��ջʵ�ֶ���
class MyQueue {

	Stack<Integer> stack;
	Stack<Integer> stack2;

	/** Initialize your data structure here. */
	public MyQueue() {
		stack = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		stack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		while (stack.size() > 1) {
			stack2.push(stack.pop());
		}
		int pop = stack.pop();
		while (!stack2.isEmpty()) {
			stack.push(stack2.pop());
		}
		return pop;
	}

	/** Get the front element. */
	public int peek() {
		while (stack.size() > 1) {
			stack2.push(stack.pop());
		}
		int pop = stack.pop();
		stack.push(pop);
		while (!stack2.isEmpty()) {
			stack.push(stack2.pop());
		}
		return pop;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack.isEmpty();
	}
}