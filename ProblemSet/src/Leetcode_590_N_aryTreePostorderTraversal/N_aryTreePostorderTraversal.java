package Leetcode_590_N_aryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import Node.Node;

/*
	����һ�� N ������������ڵ�ֵ�ĺ��������
	
	���磬����һ�� 3���� : 
		ͼƬ��https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png
	������������: [5,6,3,2,4,1].
 */
public class N_aryTreePostorderTraversal {
	// 590. N�����ĺ������

	// �ݹ�
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> postorder(Node root) {
		if (root == null) {
			return list;
		}
		for (Node temp : root.children) {
			list = postorder(temp);
		}
		list.add(root.val);
		return list;
	}

	// ����
	public List<Integer> postorder2(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.add(root);

		while (!stack.isEmpty()) {
			root = stack.pop();
			result.add(root.val);
			for (Node node : root.children) {
				stack.add(node);
			}
		}
		Collections.reverse(result);
		return result;
	}
}
