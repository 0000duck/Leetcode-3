package Leetcode_290_WordPattern;

import java.util.HashMap;
import java.util.Map;

/*
	����һ�� pattern(ģʽ) ��һ���ַ��� str ���ж� str �Ƿ���ѭ��ͬ��ģʽ��	
	�������ѭָ��ȫƥ�䣬���磬 pattern ���ÿ����ĸ���ַ��� str �е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧģʽ��
	
	ʾ��1:	
		����: pattern = "abba", str = "dog cat cat dog"
		���: true
		
	ʾ�� 2:	
		����:pattern = "abba", str = "dog cat cat fish"
		���: false
		
	ʾ�� 3:	
		����: pattern = "aaaa", str = "dog cat cat dog"
		���: false
		
	ʾ�� 4:		
		����: pattern = "abba", str = "dog dog dog dog"
		���: false
		
	˵��:
		����Լ��� pattern ֻ����Сд��ĸ�� str �������ɵ����ո�ָ���Сд��ĸ��    
 */
public class WordPattern {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String pattern = "ab";
		String str = "cat dog";
		System.out.println(new WordPattern().wordPattern(pattern, str));
	}

	// 290. ����ģʽ
	public boolean wordPattern(String pattern, String str) {
		String[] strArr = str.split(" ");
		if (pattern.length() != strArr.length) {
			return false;
		}
		Map<Character, String> map = new HashMap<Character, String>();
		Map<String, Character> map2 = new HashMap<String, Character>();
		for (int i = 0; i < strArr.length; i++) {
			if (map.containsKey(pattern.charAt(i))) {
				if (!map2.containsKey(strArr[i])) {
					return false;
				}
				if (!map.get(pattern.charAt(i)).equals(strArr[i]) && (map2.get(strArr[i]) != pattern.charAt(i))) {
					return false;
				}
			} else {
				if (map2.containsKey(strArr[i])) {
					return false;
				}
				map.put(pattern.charAt(i), strArr[i]);
				map2.put(strArr[i], pattern.charAt(i));
			}
		}
		return true;
	}

	// 0ms
	public boolean wordPattern0(String pattern, String str) {
		char[] pc = pattern.toCharArray();
		String[] words = str.split(" ");
		// ���Ȳ���
		if (pc.length != words.length) {
			return false;
		}
		// ��ascii����Ϊ�±�洢String��Ҳ����String[] mark = new String[26];ֻҪ����mark[pc[i]-97]����
		String[] mark = new String[123];
		for (int i = 0; i < pc.length; i++) {
			if (mark[pc[i]] == null) {
				mark[pc[i]] = words[i];
			}
			// ����ֵ������֮ǰ�洢�Ĳ�ͬ�����Ը�ʽ����
			else if (!mark[pc[i]].equals(words[i])) {
				return false;
			}
		}

		// ����2����������
		for (int i = 97; i < 122; i++) {
			for (int j = i + 1; j < 123; j++) {
				if (mark[i] != null && mark[i].equals(mark[j])) {
					return false;
				}
			}
		}

		return true;
	}
}
