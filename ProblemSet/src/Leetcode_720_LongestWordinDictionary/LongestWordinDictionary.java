package Leetcode_720_LongestWordinDictionary;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	����һ���ַ�������words��ɵ�һ��Ӣ��ʵ䡣
	�����ҳ����һ�����ʣ��õ�������words�ʵ����������������һ����ĸ��ɡ�
	�������ж�����еĴ𰸣��򷵻ش����ֵ�����С�ĵ��ʡ�	
	���޴𰸣��򷵻ؿ��ַ�����
	
	ʾ�� 1:	
		����: 
			words = ["w","wo","wor","worl", "world"]
		���:
		 	"world"
		����: 
			����"world"����"w", "wo", "wor", �� "worl"���һ����ĸ��ɡ�
	ʾ�� 2:	
		����: 
			words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
		���:
		 	"apple"
		����: 
			"apply"��"apple"�����ɴʵ��еĵ�����ɡ�����"apple"���ֵ���С��"apply"��
	ע��:	
		����������ַ�����ֻ����Сд��ĸ��
		words���鳤�ȷ�ΧΪ[1,1000]��
		words[i]�ĳ��ȷ�ΧΪ[1,30]��
 */
public class LongestWordinDictionary {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String[] words = { "w", "wo", "wor", "worl", "world" };
		Arrays.sort(words);
		LongestWordinDictionary lwd = new LongestWordinDictionary();
		System.out.println("apple".compareTo("apply"));
		System.out.println(lwd.longestWord(words));
		// System.out.println("a".compareTo("ap"));
		Arrays.sort(words);
		Arrays.toString(words);

	}

	// 720. �ʵ�����ĵ���
	public String longestWord(String[] words) {
		// Arrays.sort(words);
		Map<String, Integer> map = new HashMap<String, Integer>();
		// ���������map
		for (int i = words.length - 1; i >= 0; i--) {
			map.put(words[i], i);
		}
		// ��������
		String result = new String();// words[words.length-1];
		for (int i = words.length - 1; i >= 0; i--) {
			// ��¼��ǰ����ʵ�����
			int maxIndex = i;
			StringBuilder sb = new StringBuilder(words[i]);
			while (sb.length() > 0) {
				// sb.deleteCharAt(sb.length() - 1);
				if (map.containsKey(sb.toString())) {
					if (sb.length() == 1) {
						if (result.length() < words[maxIndex].length()) {
							result = words[maxIndex];
						} else if (result.length() == words[maxIndex].length()) {
							if (result.compareTo(words[maxIndex]) > 0) {
								result = words[maxIndex];
							}
						}
					}
					sb.deleteCharAt(sb.length() - 1);
				} else {
					break;
				}
			}

		}

		return result;
	}

	// 11ms
	public String longestWord0(String[] words) {
		// ���ȹ���ǰ׺���ĸ��ڵ�
		PrefixTreeNode root = new PrefixTreeNode();
		root.word = "_";
		// ���õ������鹹��ǰ׺��
		for (String word : words) {
			root.insert(word);
		}
		String[] result = new String[] { "z" };
		// ��ǰ׺��������
		dfs(root, result);
		return result[0];
	}

	/**
	 * ����������ȱ�������������
	 */
	void dfs(PrefixTreeNode node, String[] result) {
		// ���һ���ڵ�����ĵ��ʳ���Ϊ0��˵��ԭ�ȵ���������û�е�����ýڵ��Ӧ��ֱ�ӷ���
		if (node == null || node.word.length() == 0) {
			return;
		}
		for (PrefixTreeNode child : node.links) {
			if (child != null) {
				dfs(child, result);
				// Ѱ������ʲ��ҳ�����ȵ�����·�����С�ģ��������������ж�
				boolean valid = child.word.length() > result[0].length()
						|| (child.word.length() == result[0].length() && child.word.compareTo(result[0]) < 0);
				if (valid) {
					result[0] = child.word;
				}
			}
		}
	}

}
