package Leetcode_146_LRUCache;

import java.util.HashMap;

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
public class LRUCache {
	// Map key-key Value-Node
	private HashMap<Integer, Node<Integer>> keyNodeMap;
	// Map key-Node Value-key
	private HashMap<Node<Integer>, Integer> nodeKeyMap;
	// ���ȼ�
	private NodeDoubleLinkedList<Integer> nodeList;
	// ����
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		keyNodeMap = new HashMap<Integer, Node<Integer>>();
		nodeKeyMap = new HashMap<Node<Integer>, Integer>();
		nodeList = new NodeDoubleLinkedList<Integer>();
	}

	public int get(int key) {
		if (keyNodeMap.containsKey(key)) {
			// �õ�key��Ӧ�Ľڵ�
			Node<Integer> node = keyNodeMap.get(key);
			// ���˽ڵ�Ų��β��
			nodeList.moveNodeToTail(node);
			return node.value;
		} else {
			return -1;
		}

	}

	public void put(int key, int value) {
		// ������ǰkey
		if (keyNodeMap.containsKey(key)) {
			Node<Integer> node = keyNodeMap.get(key);
			node.value = value;
			nodeList.moveNodeToTail(node);
			// valueֵ��ͬ
//			if (keyNodeMap.get(key).value == value) {
//				nodeList.moveNodeToTail(keyNodeMap.get(key));
//			} else {
//				// ֵ��ͬ
//				nodeKeyMap.remove(keyNodeMap.get(key));
//				Node<Integer> node = new Node<Integer>(value);
//				keyNodeMap.put(key, node);
//				nodeKeyMap.put(node, key);
//			}
		} else {
			// ������key
			Node<Integer> node = new Node<Integer>(value);
			keyNodeMap.put(key, node);
			nodeKeyMap.put(node, key);
			nodeList.addNode(node);
			// �����Ƿ�Խ��
			if (keyNodeMap.size() == capacity + 1) {
				removeMostUnusedCache();
			}

		}

	}

	public void removeMostUnusedCache() {
		Node<Integer> oldHead = nodeList.removeHead();
		Integer oldkey = nodeKeyMap.get(oldHead);
		keyNodeMap.remove(oldkey);
		nodeKeyMap.remove(oldHead);
	}

	// ��ϣ��+˫������
	class Node<V> {
		V value;
		Node<V> last;
		Node<V> next;

		Node(V value) {
			this.value = value;
		}
	}

	// �Զ���˫������
	class NodeDoubleLinkedList<V> {
		private Node<V> head;
		private Node<V> tail;

		// ����
		public NodeDoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		// ����һ���ڵ�
		public void addNode(Node<V> newNode) {
			// �½ڵ�Ϊ��
			if (newNode == null) {
				return;
			}
			// ˫������Ϊ��
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				// ��Ϊ��
				this.tail.next = newNode;
				newNode.last = this.tail;
				this.tail = newNode;
			}
		}

		// ��ĳ���ڵ�Ų��β��㣨���������ȼ���
		public void moveNodeToTail(Node<V> node) {
			// ��ǰ�ڵ��Ѿ���β��
			if (node == this.tail) {
				return;
			}
			// ��ǰ�ڵ���ͷ��
			if (node == this.head) {
				this.head = node.next;
				this.head.last = null;
			} else {
				// ��ǰ�ڵ����м�
				node.next.last = node.last;
				node.last.next = node.next;
			}
			// ��node�ڵ����β��
			this.tail.next = node;
			node.last = this.tail;
			node.next = null;// ������
			this.tail = node;
		}

		// ���ռ䲻��ʱ���Ƴ����ȼ���͵Ľڵ㣨head��
		public Node<V> removeHead() {
			// ����Ϊ��
			if (this.head == null) {
				return null;
			}

			Node<V> res = this.head;
			// ����ֻ��һ���ڵ�
			if (this.head == this.tail) {
				this.head = null;
				this.tail = null;
			} else {
				// �������ж���ڵ�
				this.head = res.next;
				res.next = null;// �Ͽ��˴�������
				this.head.last = null;
			}
			return res;
		}
	}

}
