package Leetcode_1028_RecoveraTreeFromPreorderTraversal;

import TreeNode.TreeNode;
//1028.�����������ԭ������
public class RecoveraTreeFromPreorderTraversal0 {
	// ȫ������
	int begin = 0;

	public static void main(String[] args) {
		String S = "1-2--3--4-5--6--7";
		RecoveraTreeFromPreorderTraversal0 rtfpt = new RecoveraTreeFromPreorderTraversal0();
		rtfpt.recoverFromPreorder(S);
	}

	public TreeNode recoverFromPreorder(String S) {
		return recover(S, 0);
	}

	private TreeNode recover(String s, int depth) {
		int d = getDep(s);
		if (d != depth) {
			// �������ԣ����˵���һ��beginλ��
			begin -= d;
			return null;
		}
		TreeNode root = new TreeNode(getNum(s));
		root.left = recover(s, d + 1);
		root.right = recover(s, d + 1);
		return root;
	}

	// ��ȡ����
	private int getDep(String S) {
		int d = 0;
		while (begin < S.length() && S.charAt(begin) == '-') {
			begin++;
			d++;
		}
		return d;
	}

	// ��ȡ����
	private int getNum(String S) {
		int val = 0;
		while (begin < S.length() && isNum(S.charAt(begin))) {
			val = val * 10 + S.charAt(begin) - '0';
			begin++;
		}
		return val;
	}

	// �ж��Ƿ��������ַ�
	private boolean isNum(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		} else {
			return false;
		}
	}

}
