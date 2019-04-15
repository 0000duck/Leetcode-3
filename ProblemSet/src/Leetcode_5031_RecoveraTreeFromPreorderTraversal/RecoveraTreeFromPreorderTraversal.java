package Leetcode_5031_RecoveraTreeFromPreorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

import TreeNode.TreeNode;

/*
	���ǴӶ������ĸ��ڵ� root ��ʼ�����������������	
	�ڱ����е�ÿ���ڵ㴦��������� D ���̻��ߣ����� D �Ǹýڵ����ȣ���Ȼ������ýڵ��ֵ��
	������ڵ�����Ϊ D������ֱ���ӽڵ�����Ϊ D + 1�����ڵ�����Ϊ 0����
	
	����ڵ�ֻ��һ���ӽڵ㣬��ô��֤���ӽڵ�Ϊ���ӽڵ㡣	
	����������� S����ԭ������������ڵ� root�� 
	
	ʾ�� 1��	
		���룺"1-2--3--4-5--6--7"
		�����[1,2,5,3,4,6,7]
	ʾ�� 2��	
		���룺"1-2--3---4-5--6---7"
		�����[1,2,5,3,null,6,null,4,null,7]
	ʾ�� 3��	
		���룺"1-401--349---90--88"
		�����[1,401,null,349,88,90] 
	
	��ʾ��	
		ԭʼ���еĽڵ������� 1 �� 1000 ֮�䡣
		ÿ���ڵ��ֵ���� 1 �� 10 ^ 9 ֮�䡣
 */

//5031.�����������ԭ������
public class RecoveraTreeFromPreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "1-2--3--4-5--6--7";
		RecoveraTreeFromPreorderTraversal rtfpt = new RecoveraTreeFromPreorderTraversal();
		rtfpt.recoverFromPreorder(S);

	}

	public TreeNode recoverFromPreorder(String S) {
		int[] headarr = getNum(0, S);
		TreeNode head = new TreeNode(headarr[0]);
		Stack<TreeNode> stack = new Stack<>();
		stack.push(head);
		// int lastheight = 0;
		ArrayList<Integer> lastheight = new ArrayList<>();
		lastheight.add(0);
		int begin = headarr[1];
		process(begin, head, S, stack, lastheight);
		return head;

	}

	public void process(int begin, TreeNode head, String S, Stack<TreeNode> stack, ArrayList<Integer> lastheight) {
		// ��ȡ����
		int[] heightarr = getHeight(begin, S);
		if (heightarr == null) {
			return;
		}
		int height = heightarr[0];
		begin = heightarr[1];
		// ��ȡ����
		int[] numarr = getNum(begin, S);
		int num = numarr[0];
		TreeNode newNode = new TreeNode(num);
		begin = numarr[1];
		int lasth = lastheight.get(lastheight.size() - 1);
		while (lasth > height) {
			stack.pop();
			lastheight.remove(lastheight.size() - 1);
			lasth = lastheight.get(lastheight.size() - 1);
		}
		if (lasth == height - 1) {
			TreeNode node = stack.peek();
			node.left = newNode;
		}

		if (lasth == height) {
			stack.pop();
			lastheight.remove(lastheight.size() - 1);
			TreeNode node = stack.peek();
			node.right = newNode;
		}

		stack.add(newNode);
		lastheight.add(height);
		process(begin, head, S, stack, lastheight);

	}

	// getNum
	public int[] getNum(int begin, String S) {
		int i = begin;
		for (; i < S.length(); i++) {
			if (!isNum(S.charAt(i))) {
				break;
			}
		}
		return new int[] { Integer.parseInt(S.substring(begin, i)), i };
	}

	// getHeight
	public int[] getHeight(int begin, String S) {
		if (begin == S.length()) {
			return null;
		}
		int i = begin;
		for (; i < S.length(); i++) {
			if (isNum(S.charAt(i))) {
				break;
			}
		}
		return new int[] { i - begin, i };
	}

	public boolean isNum(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		} else {
			return false;
		}
	}

}
