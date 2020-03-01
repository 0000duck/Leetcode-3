package Leetcode_117_PopulatingNextRightPointersinEachNode2;

import TreeLinkNode.TreeLinkNode;

/*
	����һ��������
	
	struct TreeLinkNode {
		TreeLinkNode *left;
	  	TreeLinkNode *right;
	  	TreeLinkNode *next;
	}
	
	�������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣
	����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
	
	��ʼ״̬�£����� next ָ�붼������Ϊ NULL��
	
	˵��:	
		��ֻ��ʹ�ö��ⳣ���ռ䡣
		ʹ�õݹ����Ҳ����Ҫ�󣬱����еݹ����ռ�õ�ջ�ռ䲻��������Ŀռ临�Ӷȡ�
	ʾ��:	
		������������		
		     1
		   /  \
		  2    3
		 / \    \
		4   5    7
		
		������ĺ����󣬸ö�������Ϊ��		
		     1 -> NULL
		   /  \
		  2 -> 3 -> NULL
		 / \    \
		4-> 5 -> 7 -> NULL

 */
public class PopulatingNextRightPointersinEachNode2 {
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		TreeLinkNode node8 = new TreeLinkNode(8);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.right = node6;

		node4.left = node7;
		node6.right = node8;

		PopulatingNextRightPointersinEachNode2 pnroen2 = new PopulatingNextRightPointersinEachNode2();
		pnroen2.connect(root);
	}

	// 117. ���ͬһ����ֵܽڵ� II

	// ���Խ����ṹ���ɽ������ķ��䣬ÿ��ķ���������һ���������ͨ�磬
	// ����Ҫ��ÿ��ķ��䶼ͨ��
	public void connect(TreeLinkNode root) {
		// dummy�൱�����ӣ���������root �� cur ��������
		// root �����ϲ㣬cur �����²�
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeLinkNode cur = dummy;
		// root�����ڷ�����
		while (root != null) {
			// root�²���û��left����
			if (root.left != null) {
				// cur������dummy�Ͻ����ߴ�left���䴫�룬���ݵ�next���²���left�ķ���
				cur.next = root.left;
				// cur����left����
				cur = cur.next;
			}
			// root�²���û��right����
			if (root.right != null) {
				// root����cur�У�cur�����ߴ���right���䲢����
				cur.next = root.right;
				cur = cur.next;
			}
			// rootȥ�������һ������
			root = root.next;
			// �������
			if (root == null) {
				// root����ͨ�����ݵ��²����left�ķ���
				root = dummy.next;

				// cur���˻ص�����
				cur = dummy;
				// �����뿪����cur��ָʾ��root���²���left�ķ���
				dummy.next = null;
			}
		}
	}

	// 0ms
	public void connect0(TreeLinkNode root) {
		helper(root);
	}

	void helper(TreeLinkNode node) {
		if (node == null)
			return;
		TreeLinkNode next = null;
		if (node.left != null) {
			if (node.right != null) {
				node.left.next = node.right;
			} else {
				next = node.next;
				while (next != null) {
					if (next.left != null) {
						node.left.next = next.left;
						break;
					} else if (next.right != null) {
						node.left.next = next.right;
						break;
					}
					next = next.next;
				}
			}
		}
		if (node.right != null) {
			next = node.next;
			while (next != null) {
				if (next.left != null) {
					node.right.next = next.left;
					break;
				} else if (next.right != null) {
					node.right.next = next.right;
					break;
				}
				next = next.next;
			}
		}
		helper(node.right);
		helper(node.left);
	}
}
