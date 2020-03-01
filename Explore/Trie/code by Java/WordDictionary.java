package Leetcode_211_AddandSearchWord;

import java.util.HashMap;

/*
	���һ��֧���������ֲ��������ݽṹ��	
		void addWord(word)
		bool search(word)
		search(word) �����������ֻ�������ʽ�ַ������ַ���ֻ������ĸ . �� a-z �� . ���Ա�ʾ�κ�һ����ĸ��
	
	ʾ��:	
		addWord("bad")
		addWord("dad")
		addWord("mad")
		search("pad") -> false
		search("bad") -> true
		search(".ad") -> true
		search("b..") -> true
	˵��:	
		����Լ������е��ʶ�����Сд��ĸ a-z ��ɵġ�
 */

//211. ������������� - ���ݽṹ���
public class WordDictionary {
	private Node root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new Node();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		Node temp = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!temp.child.containsKey(ch)) {
				Node node = new Node();
				temp.child.put(ch, node);
			}
			temp = temp.child.get(ch);
		}
		temp.isEnd = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return search(0, word, root);
	}

	private boolean search(int i, String word, Node node) {
		if (i == word.length()) {
			return node.isEnd;
		}

		char ch = word.charAt(i);
		if (ch == '.') {
			for (Character key : node.child.keySet()) {
				Node child = node.child.get(key);
				if (search(i + 1, word, child)) {
					return true;
				}
			}
			return false;
		} else {
			if (!node.child.containsKey(ch)) {
				return false;
			} else {
				Node child = node.child.get(ch);
				node = child;
				return search(i + 1, word, child);
			}
		}
	}
}

class Node {
	HashMap<Character, Node> child;
	boolean isEnd = false;

	Node() {
		child = new HashMap<>();
	}

}
