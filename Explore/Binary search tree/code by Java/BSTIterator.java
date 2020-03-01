package Leetcode_173_BinarySearchTreeIterator;

import java.util.LinkedList;

import TreeNode.TreeNode;

/*
	ʵ��һ���������������������㽫ʹ�ö����������ĸ��ڵ��ʼ����������	
	���� next() �����ض����������е���һ����С������	 
	
	ʾ����
		ͼƬ��https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/25/bst-tree.png
	
		BSTIterator iterator = new BSTIterator(root);
		iterator.next();    // ���� 3
		iterator.next();    // ���� 7
		iterator.hasNext(); // ���� true
		iterator.next();    // ���� 9
		iterator.hasNext(); // ���� true
		iterator.next();    // ���� 15
		iterator.hasNext(); // ���� true
		iterator.next();    // ���� 20
		iterator.hasNext(); // ���� false 
	
	��ʾ��	
		next() �� hasNext() ������ʱ�临�Ӷ��� O(1)����ʹ�� O(h) �ڴ棬���� h �����ĸ߶ȡ�
		����Լ��� next() ����������Ч�ģ�Ҳ����˵�������� next() ʱ��BST �����ٴ���һ����һ����С������
 */

//173. ����������������
public class BSTIterator {

	LinkedList<Integer> list = new LinkedList<Integer>();

	public BSTIterator(TreeNode root) {
		find(root);
	}

	private void find(TreeNode root) {
		if (root == null) {
			return;
		}
		find(root.left);
		list.add(root.val);
		find(root.right);
	}

	/** @return the next smallest number */
	public int next() {
		return list.poll();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return list.size() != 0;
	}

}
