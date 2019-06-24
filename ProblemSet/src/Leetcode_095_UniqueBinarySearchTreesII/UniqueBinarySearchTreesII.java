package Leetcode_095_UniqueBinarySearchTreesII;
/*
	����һ������ n������������ 1 ... n Ϊ�ڵ�����ɵĶ�����������
	
	ʾ��:	
		����: 3
		���:
			[
			  [1,null,3,2],
			  [3,2,null,1],
			  [3,1,null,null,2],
			  [2,1,3],
			  [1,null,2,null,3]
			]
		����:
			���ϵ������Ӧ���� 5 �ֲ�ͬ�ṹ�Ķ�����������		
			   1         3     3      2      1
			    \       /     /      / \      \
			     3     2     1      1   3      2
			    /     /       \                 \
			   2     1         2                 3
 */
import java.util.LinkedList;
import java.util.List;

import TreeNode.TreeNode;

//95. ��ͬ�Ķ��������� II
public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new LinkedList<TreeNode>();
		}
		return generate_trees(1, n);
	}

	public LinkedList<TreeNode> generate_trees(int start, int end) {
		LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
		if (start > end) {
			all_trees.add(null);
			return all_trees;
		}

		// pick up a root
		for (int i = start; i <= end; i++) {
			// all possible left subtrees if i is choosen to be a root
			LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

			// all possible right subtrees if i is choosen to be a root
			LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

			// connect left and right trees to the root i
			for (TreeNode l : left_trees) {
				for (TreeNode r : right_trees) {
					TreeNode current_tree = new TreeNode(i);
					current_tree.left = l;
					current_tree.right = r;
					all_trees.add(current_tree);
				}
			}
		}
		return all_trees;
	}
}