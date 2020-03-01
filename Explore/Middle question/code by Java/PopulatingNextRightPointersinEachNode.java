package Leetcode_116_PopulatingNextRightPointersinEachNode;

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
		����Լ�������һ��������������������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ㣩��
	ʾ��:	
		����������������		
					     1
					   /  \
					  2    3
					 / \  / \
					4  5  6  7
		������ĺ����󣬸�������������Ϊ��		
					     1 -> NULL
					   /  \
					  2 -> 3 -> NULL
					 / \  / \
					4->5->6->7 -> NULL

 */
public class PopulatingNextRightPointersinEachNode {
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		PopulatingNextRightPointersinEachNode pnrpen = new PopulatingNextRightPointersinEachNode();
		pnrpen.connect(root);
	}
	// 116. ���ͬһ����ֵܽڵ�

	// �ݹ�
	public void connect(TreeLinkNode root) {
		// �������ҽڵ�һ����������ڵ�
		if (root == null || root.right == null)
			return;
		// ���ӽڵ��nextָ�����ӽڵ�
		root.left.next = root.right;
		// root����next�ڵ�һ����ͬ���ҽڵ�
		if (root.next != null) {
			root.right.next = root.next.left;
		}
		// �ݹ�root�������ӽڵ�
		connect(root.left);
		connect(root.right);

	}
}
