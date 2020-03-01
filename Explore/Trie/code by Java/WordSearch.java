package Leetcode_212_WordSearchII;

import java.util.ArrayList;
import java.util.List;

/*
	����һ����ά���� board ��һ���ֵ��еĵ����б� words��
	�ҳ�����ͬʱ�ڶ�ά������ֵ��г��ֵĵ��ʡ�
	
	���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ�
	���С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��
	ͬһ����Ԫ���ڵ���ĸ��һ�������в������ظ�ʹ�á�
	
	ʾ��:	
		����: 
			words = ["oath","pea","eat","rain"] and board =
			[
			  ['o','a','a','n'],
			  ['e','t','a','e'],
			  ['i','h','k','r'],
			  ['i','f','l','v']
			]		
		���: ["eat","oath"]
		˵��:
			����Լ����������붼��Сд��ĸ a-z ��ɡ�
	
	��ʾ:	
		����Ҫ�Ż������㷨��ͨ�������������Ĳ��ԡ����ܷ����ֹͣ���ݣ�
		�����ǰ���ʲ����������е��ʵ�ǰ׺�У����������ֹͣ���ݡ�
		ʲô�������ݽṹ������Ч��ִ�������Ĳ�����
		ɢ�б��Ƿ���У�Ϊʲô�� ǰ׺����Σ�
		�������ѧϰ���ʵ��һ��������ǰ׺�������Ȳ鿴������⣺ ʵ��Trie��ǰ׺������
 */

//212.�������� II
public class WordSearch {
	// ǰ׺��+dfs
	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;// ��ʶ���ʵĽ�β
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null) {
					p.next[i] = new TrieNode();
				}
				p = p.next[i];
			}
			p.word = w;
		}
		return root;
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		// # ����������
		// null �������ڵ�ǰ�ַ�
		if (c == '#' || p.next[c - 'a'] == null)
			return;
		p = p.next[c - 'a'];
		if (p.word != null) { // �ҵ�һ��
			res.add(p.word);
			p.word = null; // ȥ��
		}

		board[i][j] = '#';
		// ����
		if (i > 0) {
			dfs(board, i - 1, j, p, res);
		}
		// ����
		if (j > 0) {
			dfs(board, i, j - 1, p, res);
		}
		// ����
		if (i < board.length - 1) {
			dfs(board, i + 1, j, p, res);
		}
		// ����
		if (j < board[0].length - 1) {
			dfs(board, i, j + 1, p, res);
		}
		// �ָ�
		board[i][j] = c;
	}

}
