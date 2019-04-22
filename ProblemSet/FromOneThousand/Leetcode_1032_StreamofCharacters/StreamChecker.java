package Leetcode_1032_StreamofCharacters;
/*
	������Ҫ��ʵ�� StreamChecker �ࣺ	
		StreamChecker(words)��
			���캯�����ø������ִʳ�ʼ�����ݽṹ��
		query(letter)��
			�������ĳЩ k >= 1�������ò�ѯ����� k���ַ�
			(���Ӿɵ���˳�򣬰����ող�ѯ����ĸ)
			ƴд�������ִʱ��е�ĳһ�ִ�ʱ������ true��
			���򣬷��� false��
	
	ʾ����	
		StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // ��ʼ���ֵ�
		streamChecker.query('a');          // ���� false
		streamChecker.query('b');          // ���� false
		streamChecker.query('c');          // ���� false
		streamChecker.query('d');          // ���� true����Ϊ 'cd' ���ִʱ���
		streamChecker.query('e');          // ���� false
		streamChecker.query('f');          // ���� true����Ϊ 'f' ���ִʱ���
		streamChecker.query('g');          // ���� false
		streamChecker.query('h');          // ���� false
		streamChecker.query('i');          // ���� false
		streamChecker.query('j');          // ���� false
		streamChecker.query('k');          // ���� false
		streamChecker.query('l');          // ���� true����Ϊ 'kl' ���ִʱ��С� 
	
	��ʾ��	
		1 <= words.length <= 2000
		1 <= words[i].length <= 2000
		�ִ�ֻ����СдӢ����ĸ��
		������ֻ����СдӢ����ĸ��
		��������� 40000 ����
 */

//1032. �ַ���
public class StreamChecker {

	class TrieNode {
		boolean isWord;
		TrieNode[] next = new TrieNode[26];
	}

	TrieNode root = new TrieNode();
	StringBuilder sb = new StringBuilder();

	public StreamChecker(String[] words) {
		createTrie(words);
	}

	public boolean query(char letter) {
		sb.append(letter);
		TrieNode node = root;
		for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
			char c = sb.charAt(i);
			node = node.next[c - 'a'];
			if (node != null && node.isWord) {
				return true;
			}
		}
		return false;
	}

	private void createTrie(String[] words) {
		for (String s : words) {
			TrieNode node = root;
			int len = s.length();
			for (int i = len - 1; i >= 0; i--) {
				char c = s.charAt(i);
				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new TrieNode();
				}
				node = node.next[c - 'a'];
			}
			node.isWord = true;
		}
	}
}
