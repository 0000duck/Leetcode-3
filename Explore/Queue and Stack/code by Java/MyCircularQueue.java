package Leetcode_622_DesignCircularQueue;
/*
	������ѭ������ʵ�֡� 
	ѭ��������һ���������ݽṹ����������ֻ��� FIFO���Ƚ��ȳ���ԭ���Ҷ�β�������ڶ���֮�����γ�һ��ѭ����
	��Ҳ����Ϊ�����λ���������
	ѭ�����е�һ���ô������ǿ��������������֮ǰ�ù��Ŀռ䡣
	��һ����ͨ�����һ��һ���������ˣ����ǾͲ��ܲ�����һ��Ԫ�أ���ʹ�ڶ���ǰ�����пռ䡣
	����ʹ��ѭ�����У�������ʹ����Щ�ռ�ȥ�洢�µ�ֵ��
	
	���ʵ��Ӧ��֧�����²�����	
		MyCircularQueue(k): �����������ö��г���Ϊ k ��
		Front: �Ӷ��׻�ȡԪ�ء��������Ϊ�գ����� -1 ��
		Rear: ��ȡ��βԪ�ء��������Ϊ�գ����� -1 ��
		enQueue(value): ��ѭ�����в���һ��Ԫ�ء�����ɹ������򷵻��档
		deQueue(): ��ѭ��������ɾ��һ��Ԫ�ء�����ɹ�ɾ���򷵻��档
		isEmpty(): ���ѭ�������Ƿ�Ϊ�ա�
		isFull(): ���ѭ�������Ƿ�������
	
	ʾ����	
		MyCircularQueue circularQueue = new MycircularQueue(3); // ���ó���Ϊ3		
		circularQueue.enQueue(1);  // ����true		
		circularQueue.enQueue(2);  // ����true		
		circularQueue.enQueue(3);  // ����true		
		circularQueue.enQueue(4);  // ����false,��������		
		circularQueue.Rear();  // ����3		
		circularQueue.isFull();  // ����true		
		circularQueue.deQueue();  // ����true		
		circularQueue.enQueue(4);  // ����true		
		circularQueue.Rear();  // ����4	 
	
	��ʾ��	
		���е�ֵ���� 1 �� 1000 �ķ�Χ�ڣ�
		���������� 1 �� 1000 �ķ�Χ�ڣ�
		�벻Ҫʹ�����õĶ��п⡣
 */
//622. ���ѭ������
public class DesignCircularQueue {	

	
	private int[] Queue;	
	//��ָ��
	int head = -1;
	//βָ��
	int tail = -1;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue(int k) {
    	//�����������ö��г���Ϊ k
    	Queue = new int[k];
    }    
   

	/** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //enQueue(value): ��ѭ�����в���һ��Ԫ�ء�����ɹ������򷵻��档
    	//��
    	if(isFull()) {
    		return false;
    	}
    	//����
    	if((head==-1)&(tail==-1)) {
    		head++;
    		tail++;
    		Queue[head] = value;
    		return true;
    	}else if((head<=tail)&(tail<Queue.length-1)) {
    		tail++;
    		Queue[tail] = value;
    		return true;
    	}else if((head>0)&&(tail==Queue.length-1)) {
    		tail = 0;
    		Queue[tail] = value;
    		return true;
    	}else if((head>0)&&(tail<head-1)) {
    		tail++;
    		Queue[tail] = value;
    		return true;
    	}
    	return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        //deQueue(): ��ѭ��������ɾ��һ��Ԫ�ء�����ɹ�ɾ���򷵻��档
    	if(isEmpty()) {
    		return false;
    	}
    	if(head<tail) {
    		head++;
    		return true;
    	}else if(head==tail) {
    		head=-1;
    		tail=-1;
    		return true;
    	}else if((head>tail)&&(head==Queue.length-1)) {
    		head = 0;
    		return true;
    	}else if((head>tail)&&(head<Queue.length-1)) {
    		head++;
    		return true;
    	}
    	return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        //Front: �Ӷ��׻�ȡԪ�ء��������Ϊ�գ����� -1 ��
    	if(head==-1) {
    		return -1;
    	}else {
    		return Queue[head];
    	}
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        //Rear: ��ȡ��βԪ�ء��������Ϊ�գ����� -1 ��
    	if(tail==-1) {
    		return -1;
    	}else {
    		return Queue[tail];
    	}
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        //isEmpty(): ���ѭ�������Ƿ�Ϊ�ա�
    	if(head==-1) {
    		return true;
    	}
    	return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    	//isFull(): ���ѭ�������Ƿ�������
    	//�����ж��Ƿ�full
    	if(((head==0)&(tail==Queue.length-1))||((head-tail==1))) {
    		return true;
    	}
    	return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
