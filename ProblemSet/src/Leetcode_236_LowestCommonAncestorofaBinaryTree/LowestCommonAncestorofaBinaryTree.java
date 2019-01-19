package Leetcode_236_LowestCommonAncestorofaBinaryTree;

import TreeNode.TreeNode;

/*
	����һ��������, �ҵ�����������ָ���ڵ������������ȡ�	
	�ٶȰٿ�������������ȵĶ���Ϊ��
		�������и��� T ��������� p��q������������ȱ�ʾΪһ����� x��
		���� x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
	
	���磬�������¶�����:  root = [3,5,1,6,2,0,8,null,null,7,4]
	
	ͼƬ��https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/binarytree.png	 
	
	ʾ�� 1:	
		����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
		���: 3
		����: �ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3��
	
	ʾ�� 2:	
		����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
		���: 5
		����: �ڵ� 5 �ͽڵ� 4 ��������������ǽڵ� 5����Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
	
	˵��:	
		���нڵ��ֵ����Ψһ�ġ�
		p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ������С�
 */
public class LowestCommonAncestorofaBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node0 = new TreeNode(0);
		TreeNode node8 = new TreeNode(8);
		TreeNode node7 = new TreeNode(7);
		TreeNode node4 = new TreeNode(4);
		root.left = node5;
		root.right = node1;
		node5.left = node6;
		node5.right = node2;
		node1.left = node0;
		node1.right = node8;
		node2.left = node7;
		node2.right = node4;
		LowestCommonAncestorofaBinaryTree lcabt = new LowestCommonAncestorofaBinaryTree();
		lcabt.lowestCommonAncestor(root, node7, node4);
	}

	// 236. �������������������
	/*
	 * �ȴ������±������ٴ������ϻ���
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// ����һ��Ϊroot
		if (root == null || root.val == p.val || root.val == q.val) {
			return root;
		}
		//
		TreeNode leftN = lowestCommonAncestor(root.left, p, q);
		TreeNode rightN = lowestCommonAncestor(root.right, p, q);
		if (leftN != null && rightN != null) {
			return root;
		}
		if (leftN == null) {
			return rightN;
		}
		return leftN;
	}
	
	//7ms
    private TreeNode ans;
    public LowestCommonAncestorofaBinaryTree(){
        this.ans = null;
    }
    public boolean recurseTree(TreeNode curr,TreeNode p,TreeNode q){
        if(curr!=null){
            int left = this.recurseTree(curr.left,p,q)?1:0;
            int right = this.recurseTree(curr.right,p,q)?1:0;
            int mid = (curr==p)||(curr==q)?1:0;
            if((left+right+mid) >=2){
                this.ans = curr;
            }
          return (mid + left + right > 0);

        }else
            return false;
    }
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root,p,q);
        return this.ans;
    }
}
