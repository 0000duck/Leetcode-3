package Leetcode_648_ReplaceWords;

import java.util.List;

/*
	��Ӣ���У�������һ������ �ʸ�(root)�ĸ��
	�����Ը�������һЩ�������һ���ϳ��ĵ��ʡ������ǳ������Ϊ �̳д�(successor)��
	���磬�ʸ�an�������ŵ��� other(����)�������γ��µĵ��� another(��һ��)��
	
	���ڣ�����һ�������ʸ���ɵĴʵ��һ�����ӡ�
	����Ҫ�������е����м̳д��ôʸ��滻����
	����̳д����������γ����Ĵʸ���������̵Ĵʸ��滻����
	
	����Ҫ����滻֮��ľ��ӡ�
	
	ʾ�� 1:
	
	����: dict(�ʵ�) = ["cat", "bat", "rat"]
	sentence(����) = "the cattle was rattled by the battery"
	���: "the cat was rat by the bat"
	ע:
	
	����ֻ����Сд��ĸ��
	1 <= �ֵ䵥���� <=1000
	1 <=  ���д����� <= 1000
	1 <= �ʸ����� <= 100
	1 <= ���д��ﳤ�� <= 1000
 */
public class ReplaceWords {
	public String replaceWords(List<String> dict, String sentence) {
		// ���ʸ�����ǰ׺��
		Node root = new Node();		
		for (String str : dict) {
			Node temp = root;
			for (int i = 0; i < str.length(); i++) {
				int index = str.charAt(i) - 'a';
				if (temp.child[index] == null) {
					Node node = new Node();
					temp.child[index] = node;
				}
				temp = temp.child[index];
			}
			temp.isEnd = true;
		}
		// �����ӳ�����
		String[] sent = sentence.split(" ");
		StringBuilder res = new StringBuilder();
		for (int j = 0; j < sent.length; j++) {
			Node temp = root;
			String str = sent[j];
			for (int i = 0; i < str.length(); i++) {
				int index = str.charAt(i) - 'a';
				if (temp.child[index] == null) {
					res.append(str);
					break;
				} else if (temp.child[index].isEnd) {
					res.append(str.substring(0, i + 1));
					break;
				}
				if (i == str.length() - 1) {
					res.append(str);
				}
				temp = temp.child[index];
			}
			if (j != sent.length - 1) {
				res.append(" ");
			}
		}
		return res.toString();

	}
}

class Node {
	boolean isEnd;
	Node[] child;

	Node() {
		isEnd = false;
		child = new Node[26];
	}
}
