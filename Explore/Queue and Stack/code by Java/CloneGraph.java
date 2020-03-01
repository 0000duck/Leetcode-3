package Leetcode_133_CloneGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
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

	// 133. ��¡ͼ
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		// ��Ÿ��ƵĶԵȽڵ�
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		// DFS���ƽڵ�
		Stack<UndirectedGraphNode> nodeStack = new Stack<UndirectedGraphNode>();

		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		DFS(node, nodeStack, map, set);
		// �����ھӽڵ�
		for (UndirectedGraphNode copynbNode : map.keySet()) {
			for (UndirectedGraphNode nbNode : copynbNode.neighbors) {
				map.get(copynbNode).neighbors.add(map.get(nbNode));
			}
		}

		return map.get(node);
	}

	private void DFS(UndirectedGraphNode node, Stack<UndirectedGraphNode> nodeStack,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map, Set<UndirectedGraphNode> set) {

		nodeStack.push(node);
		while (!nodeStack.isEmpty()) {
			UndirectedGraphNode curNode = nodeStack.peek();
			// ���Ʊ�ǩ
			UndirectedGraphNode newNode = new UndirectedGraphNode(curNode.label);
			//
			map.put(curNode, newNode);
			set.add(curNode);
			for (UndirectedGraphNode nbNode : curNode.neighbors) {
				if (!set.contains(nbNode)) {
					nodeStack.push(nbNode);
					DFS(nbNode, nodeStack, map, set);
				}
			}
			nodeStack.pop();
			return;
		}

	}

	// 2ms
	HashMap<Integer, UndirectedGraphNode> cloned = new HashMap<>();

	public UndirectedGraphNode cloneGraph0(UndirectedGraphNode node) {
		// �սڵ�
		if (node == null)
			return null;
		// �Ѹ���
		if (cloned.containsKey(node.label))
			return cloned.get(node.label);
		// δ����
		UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
		cloned.put(node.label, ans);
		// �����ھӽڵ�
		for (UndirectedGraphNode ugn : node.neighbors) {
			ans.neighbors.add(cloneGraph0(ugn));
		}
		return ans;
	}
}
