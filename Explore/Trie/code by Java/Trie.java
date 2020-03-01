package Leetcode_208_ImplementTrie;

import java.util.ArrayList;

/*
	ʵ��һ�� Trie (ǰ׺��)������ insert, search, �� startsWith ������������
	
	ʾ��:	
		Trie trie = new Trie();
	
		trie.insert("apple");
		trie.search("apple");   // ���� true
		trie.search("app");     // ���� false
		trie.startsWith("app"); // ���� true
		trie.insert("app");   
		trie.search("app");     // ���� true
	˵��:	
	����Լ������е����붼����Сд��ĸ a-z ���ɵġ�
	��֤���������Ϊ�ǿ��ַ�����
 */
public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();		
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			if (curNode.children[temp - 'a'] == null) {
				TrieNode node = new TrieNode();
				curNode.children[temp - 'a'] = node;
			}
			curNode = curNode.children[temp - 'a'];
		}
		curNode.isEnd++;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			if (curNode.children[temp - 'a'] == null) {
				return false;
			}
			curNode = curNode.children[temp - 'a'];
		}
		if (curNode.isEnd == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode curNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			char temp = prefix.charAt(i);
			if (curNode.children[temp - 'a'] == null) {
				return false;
			}
			curNode = curNode.children[temp - 'a'];
		}
		return true;
	}
}

class TrieNode {	
	public int isEnd;
	public TrieNode[] children;

	//����
	public TrieNode() {
		isEnd = 0;
		children = new TrieNode[26];
	}
}
