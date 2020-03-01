package Leetcode_102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	����һ���������������䰴��α����Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
	
	����:
		����������: [3,9,20,null,null,15,7],
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		   
		�������α��������		
			[
			  [3],
			  [9,20],
			  [15,7]
			]
 */
public class BinaryTreeLevelOrderTraversal {
	//102. �������Ĳ�α���
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<List<TreeNode>> queue = new LinkedList<List<TreeNode>>();
		if (root == null) {
			return list;
		}
		List<TreeNode> nodelist = new ArrayList<TreeNode>();
		nodelist.add(root);
		queue.offer(nodelist);
		List<Integer> valList = new ArrayList<Integer>();
		valList.add(root.val);
		list.add(valList);
		while (!queue.isEmpty()) {
			List<TreeNode> nextNodeList = new ArrayList<TreeNode>();
			List<Integer> nextValList = new ArrayList<Integer>();
			for (TreeNode cur : queue.peek()) {
				if (cur.left != null) {
					nextNodeList.add(cur.left);
					nextValList.add(cur.left.val);
				}
				if (cur.right != null) {
					nextNodeList.add(cur.right);
					nextValList.add(cur.right.val);
				}
			}
			if (!nextNodeList.isEmpty()) {
				queue.offer(nextNodeList);
				list.add(nextValList);
			}
			queue.poll();
		}
		return list;

	}

	// 0ms
	public List<List<Integer>> levelOrder0(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		function(root, list, 0);
		return list;
	}

	public void function(TreeNode node, List<List<Integer>> list, int level) {
		if (node == null) {
			return;
		}
		if (list.size() <= level) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(node.val);
		function(node.left, list, level + 1);
		function(node.right, list, level + 1);
	}
}
