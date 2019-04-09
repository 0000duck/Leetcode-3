package Leetcode_460_LFUCache;

import java.util.HashMap;

/*
	��Ʋ�ʵ�������ʹ�ã�LFU����������ݽṹ��
	��Ӧ��֧�����²�����get �� put��
	
	get(key) - ����������ڻ����У����ȡ����ֵ�����������������򷵻� -1��
	put(key, value) - ����������ڣ������û����ֵ��
				������ﵽ������ʱ����Ӧ���ڲ�������Ŀ֮ǰ��ʹ�����ʹ�õ���Ŀ��Ч��
				�ڴ������У�������ƽ�֣���������������������ͬʹ��Ƶ�ʣ�ʱ���������ʹ�õļ�����ȥ����
	
	���ף�
		���Ƿ������ O(1) ʱ�临�Ӷ���ִ�����������
	
	ʾ����	
		LFUCache cache = new LFUCache( 2 /* capacity (��������)  );
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // ���� 1
		cache.put(3, 3);    // ȥ�� key 2
		cache.get(2);       // ���� -1 (δ�ҵ�key 2)
		cache.get(3);       // ���� 3
		cache.put(4, 4);    // ȥ�� key 1
		cache.get(1);       // ���� -1 (δ�ҵ� key 1)
		cache.get(3);       // ���� 3
		cache.get(4);       // ���� 4
 */

//460. LFU����
public class LFUCache {
	// ˫������ʵ��

	// ����ڵ�����
	class Node {
		int key;
		int value;
		int times;
		Node up;
		Node down;

		Node(int key, int value, int time) {
			this.times = time;
			this.key = key;
			this.value = value;
		}
	}

	// ˫������
	class NodeList {
		// list�ڲ��Ľṹ
		Node head;// Ƶ����ͬ������£�����Ĳ���
		Node tail;// Ƶ����ͬ��ɾ��β
		// listǰ��Ľṹ
		NodeList last;
		NodeList next;

		// ����
		NodeList(Node node) {
			this.head = node;
			this.tail = node;
		}

		// ��list������һ���½ڵ�
		public void addNodeFromHead(Node newHead) {
			newHead.down = head;
			head.up = newHead;
			head = newHead;
		}

		// �п�
		public boolean isEmpty() {
			return head == null;
		}

		// ɾ���ڵ�
		public void deleteNode(Node node) {
			// ֻ��һ���ڵ�
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				// ����ڵ�

				if (head == node) {
					// node��ͷ�ڵ�
					head = node.down;
					head.up = null;
					// node.down = null;// ???
				} else if (tail == node) {
					// node��β�ڵ�
					tail = node.up;
					tail.down = null;
					// node.up = null;// ???
				} else {
					// node���м�Ľڵ�
					node.up.down = node.down;
					node.down.up = node.up;
				}
			}
			node.up = null;
			node.down = null;
		}

	}

	// LFUCache�Ĺ���
	private int capacity;// ����
	private int size;// ʵ�ʴ�С

	private HashMap<Integer, Node> records;// key-Node
	private HashMap<Node, NodeList> heads;// �ڵ��Ӧ��˫���б�
	private NodeList headList;

	// ���췽��
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		records = new HashMap<Integer, Node>();
		heads = new HashMap<Node, NodeList>();
		headList = null;
	}

	public int get(int key) {
		if (!records.containsKey(key)) {
			return -1;
		}
		Node node = records.get(key);
		node.times++;
		NodeList curNodeList = heads.get(node);
		move(node, curNodeList);
		return node.value;
	}

	//
	public void put(int key, int value) {
		if (capacity == 0) {
			return;
		}
		// �ж�key�Ƿ����
		if (records.containsKey(key)) {
			Node node = records.get(key);
			node.value = value;
			node.times++;
			NodeList curNodeList = heads.get(node);
			move(node, curNodeList);
		} else {
			// ������key

			// ��������
			if (size == capacity) {
				// ͷlist��tail�ڵ�ɾ��
				Node node = headList.tail;
				headList.deleteNode(node);
				modifyHeadList(headList);
				records.remove(node.key);
				heads.remove(node);
				size--;
			}
			Node node = new Node(key, value, 1);
			if (headList == null) {
				headList = new NodeList(node);
			} else {
				if (headList.head.times == node.times) {
					headList.addNodeFromHead(node);
				} else {
					NodeList newList = new NodeList(node);
					newList.next = headList;
					headList.last = newList;
					headList = newList;
				}
			}
			records.put(key, node);
			heads.put(node, headList);
			size++;
		}
	}

	// ��һ��node�ƶ�����list
	public void move(Node node, NodeList oldNodeList) {
		// ��ԭ����list��ɾ����ǰ�ڵ�
		oldNodeList.deleteNode(node);
		// ��ȡ��ǰ�ڵ����ڵ�list��ǰһ��list
		NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last : oldNodeList;
		NodeList nextList = oldNodeList.next;
		if (nextList == null) {
			// ��������һ��list
			NodeList newList = new NodeList(node);
			if (preList != null) {
				// ǰһ���ڵ㲻Ϊ��
				preList.next = newList;
			}
			newList.last = preList;
			if (headList == null) {
				headList = newList;
			}
			heads.put(node, newList);
		} else {
			// ��һlist����

			// times�Ƿ�ƥ��
			if (nextList.head.times == node.times) {
				nextList.addNodeFromHead(node);
				heads.put(node, nextList);
			} else {
				NodeList newList = new NodeList(node);
				if (preList != null) {
					preList.next = newList;
				}
				newList.last = preList;
				newList.next = nextList;
				nextList.last = newList;
				if (headList == nextList) {
					headList = newList;
				}
				heads.put(node, newList);
			}
		}
	}

	// �ж�ɾ�����б��Ƿ���ͷ����
	private boolean modifyHeadList(NodeList nodeList) {
		if (nodeList.isEmpty()) {
			if (headList == nodeList) {
				headList = nodeList.next;
				// �пգ�����
				if (headList != null) {
					headList.last = null;
				}
			} else {
				nodeList.last.next = nodeList.next;
				if (nodeList.next != null) {
					nodeList.next.last = nodeList.last;
				}
			}
			return true;
		}
		return false;
	}
}
