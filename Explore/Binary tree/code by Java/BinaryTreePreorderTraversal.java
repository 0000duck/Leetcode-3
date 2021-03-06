package Leetcode_144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;

/*
	给定一个二叉树，返回它的 前序 遍历。
	
	前序遍历：
		根节点，左子树，右子树。
	
	 示例:	
		输入: [1,null,2,3]  
		   1
		    \
		     2
		    /
		   3 
		
		输出: [1,2,3]
	进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreePreorderTraversal {
	// 144. 二叉树的前序遍历
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.add(root.val);
		if (root.left != null) {
			list.addAll(preorderTraversal(root.left));
		}
		if (root.right != null) {
			list.addAll(preorderTraversal(root.right));
		}
		return list;
	}

	// 0ms
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> preorderTraversal0(TreeNode root) {
		loop(root);
		return res;
	}

	public void loop(TreeNode root) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		loop(root.left);
		loop(root.right);
	}
}
