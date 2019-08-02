package Leetcode_146_LRUCache;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/*
	�����������յ����ݽṹ����ƺ�ʵ��һ��  LRU (�������ʹ��) ������ơ�
	��Ӧ��֧�����²����� ��ȡ���� get �� д������ put ��
	
	��ȡ���� get(key) - �����Կ (key) �����ڻ����У����ȡ��Կ��ֵ�����������������򷵻� -1��
	д������ put(key, value) - �����Կ�����ڣ���д��������ֵ�������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ���������ʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
	
	����:	
		���Ƿ������ O(1) ʱ�临�Ӷ�����������ֲ�����
	
	ʾ��:	
		LRUCache cache = new LRUCache( 2 /* ��������  );
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // ����  1
		cache.put(3, 3);    // �ò�����ʹ����Կ 2 ����
		cache.get(2);       // ���� -1 (δ�ҵ�)
		cache.put(4, 4);    // �ò�����ʹ����Կ 1 ����
		cache.get(1);       // ���� -1 (δ�ҵ�)
		cache.get(3);       // ����  3
		cache.get(4);       // ����  4
 */
/*
	Your LRUCache object will be instantiated and called as such:
	LRUCache obj = new LRUCache(capacity);
	int param_1 = obj.get(key);
	obj.put(key,value);
*/

//146. LRU�������
public class LRUCache {
	// ����LinkedHashMap
	class LRUCache0 extends LinkedHashMap<Integer, Integer> {
		private int capacity;

		public LRUCache0(int capacity) {
			super(capacity, 0.75F, true);
			this.capacity = capacity;
		}

		public int get(int key) {
			return super.getOrDefault(key, -1);
		}

		public void put(int key, int value) {
			super.put(key, value);
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
			return size() > capacity;
		}
	}

	// ��ϣ��+˫�˶���

	// ��ϣ�� key=value
	// ˫�˶��У�head + tail + removeNode + moveToHead + addNode + poptail
	public class LRUCache1 {

		// ����˫�˶��еĽ��
		class DLinkedNode {
			int key;
			int value;
			DLinkedNode prev;
			DLinkedNode next;
		}

		private void addNode(DLinkedNode node) {
			// ���ǽ��½ڵ�������head����
			node.prev = head;
			node.next = head.next;

			head.next.prev = node;
			head.next = node;
		}

		private void removeNode(DLinkedNode node) {
			// ɾ���Ѿ����ڵĽ��.
			DLinkedNode prev = node.prev;// ǰһ���ڵ�
			DLinkedNode next = node.next;// ��һ���ڵ�
			// �����ǰ�ڵ�
			prev.next = next;
			next.prev = prev;
		}

		private void moveToHead(DLinkedNode node) {
			// ���Ѵ��ڵĽ��Ų��ͷ����һ�� removeNode(node);
			DLinkedNode res = tail.prev;
			removeNode(res);
			// return res;
		}

		private DLinkedNode popTail() {
			// ������ǰ����ʱ��tail��ǰһ���ڵ�ɾ��
			DLinkedNode res = tail.prev;
			removeNode(res);
			return res;
		}

		private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
		private int size;
		private int capacity;
		private DLinkedNode head, tail;

		public LRUCache1(int capacity) {
			this.size = 0;
			this.capacity = capacity;

			head = new DLinkedNode();
			// head.prev = null;

			tail = new DLinkedNode();
			// tail.next = null;

			head.next = tail;
			tail.prev = head;
		}

		public int get(int key) {
			DLinkedNode node = cache.get(key);
			if (node == null)
				return -1;

			// move the accessed node to the head;
			moveToHead(node);

			return node.value;
		}

		public void put(int key, int value) {
			DLinkedNode node = cache.get(key);

			if (node == null) {
				DLinkedNode newNode = new DLinkedNode();
				newNode.key = key;
				newNode.value = value;

				cache.put(key, newNode);
				addNode(newNode);

				++size;

				if (size > capacity) {
					// pop the tail
					DLinkedNode tail = popTail();
					cache.remove(tail.key);
					--size;
				}
			} else {
				// update the value.
				node.value = value;
				moveToHead(node);
			}
		}
	}

}
