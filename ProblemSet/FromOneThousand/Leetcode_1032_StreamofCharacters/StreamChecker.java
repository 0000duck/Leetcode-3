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

//1032. �ַ���(��ʱ)
public class StreamChecker {
	TrieTree tt;
	String s;

	// �����ֵ�
	public StreamChecker(String[] words) {
		tt = new TrieTree();
		for (int i = 0; i < words.length; i++) {
			tt.reverseBuild(words[i],words[i].length()-1,tt.root);
		}
		s="";
	}

	public boolean query(char letter) {
		s += letter;
		return tt.reverseSearch(s,s.length()-1,tt.root);
	}
}

//ǰ׺���ڵ�
class TrieNode {
	boolean isEnd = false;
	TrieNode[] childs;

	TrieNode() {
		childs = new TrieNode[26];
	}
}

//ǰ׺��
class TrieTree {
	TrieNode root;

	TrieTree() {
		root = new TrieNode();
	}
	//�ݹ�
	//��ת
	public void reverseBuild(String s,int i,TrieNode root) {
		if(i==-1) {
			root.isEnd = true;
			return;
		}
		int index = s.charAt(i)-'a';
		if(root.childs[index]==null) {
			root.childs[index]= new TrieNode();			
		}		
		reverseBuild(s,i-1,root.childs[index]);
	}
	//��ѯ
	public boolean reverseSearch(String s,int i,TrieNode root) {
		if(i==-1||root.isEnd) {
			return root.isEnd;
		}
		int index =s.charAt(i)-'a';
		if(root.childs[index]==null) {
			return false;
		}
		return reverseSearch(s,i-1,root.childs[index]);
	}
	
	//����
	// ��ת����
	public void reverseBuild(String s) {
		TrieNode node = root;
		for (int i = s.length() - 1; i >= 0; i--) {
			int index = s.charAt(i) - 'a';
			if (node.childs[index] == null) {
				TrieNode child = new TrieNode();
				node.childs[index] = child;
			}
			node = node.childs[index];
		}
		node.isEnd = true;
	}

	// ��ת����
	public boolean reverseSearch(String s) {
		TrieNode node = root;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (node.isEnd) {
				return true;
			}
			int index = s.charAt(i) - 'a';
			if (node.childs[index] == null) {
				return false;
			}
			node = node.childs[index];
		}
		return node.isEnd;
	}
}
