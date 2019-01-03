package Leetcode_133_CloneGraph;

import java.util.HashMap;
import java.util.Stack;

import UndirectedGraphNode.UndirectedGraphNode;

/*
	��¡һ������ͼ��ͼ�е�ÿ���ڵ����һ�� label ����ǩ����һ�� neighbors ���ڽӵ㣩�б� ��
	
	OJ������ͼ���л���
	
	�ڵ㱻Ψһ��ǡ�
	
	������ # ��Ϊÿ���ڵ�ķָ������� , ��Ϊ�ڵ��ǩ���ڽӵ�ķָ�����
	
	���磬���л�����ͼ {0,1,2#1,2#2,2}��
	
	��ͼ�ܹ��������ڵ�, �������ָ���  # ��Ϊ�����֡� 
	
	��һ���ڵ�ı�ǩΪ 0�����ڴӽڵ� 0 ���ڵ� 1 �ͽڵ� 2 �������ߡ�
	�ڶ����ڵ�ı�ǩΪ 1�����ڴӽڵ� 1 ���ڵ� 2 ��һ���ߡ�
	�������ڵ�ı�ǩΪ 2�����ڴӽڵ� 2 ���ڵ� 2 (����) ��һ���ߣ��Ӷ��γ��Ի���
	���ǽ�ͼ�ο��ӻ����£�
	
	       1
	      / \
	     /   \
	    0 --- 2
	         / \
	         \_/
 */
public class CloneGraph {
	
	//133. ��¡ͼ
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		// ջ����������Ľڵ�
		Stack<UndirectedGraphNode> nodeStack = new Stack<UndirectedGraphNode>();
		nodeStack.push(node);

		while (!nodeStack.empty()) {
			UndirectedGraphNode tempNode = nodeStack.pop();
			if (map.containsKey(tempNode))
				continue;
			UndirectedGraphNode copyNode = new UndirectedGraphNode(tempNode.label);

			for (UndirectedGraphNode unode : tempNode.neighbors) {
				copyNode.neighbors.add(unode);
				if (map.containsKey(node))
					continue;
				nodeStack.push(unode);
			}
			map.put(tempNode, copyNode);
		}

		return map.get(node);
	}

}
