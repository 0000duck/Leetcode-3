package Node;

import java.util.List;

//N�����ڵ�Ķ���
public class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
