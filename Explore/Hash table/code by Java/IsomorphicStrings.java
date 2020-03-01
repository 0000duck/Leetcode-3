package Leetcode_205_IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
	���������ַ��� s �� t���ж������Ƿ���ͬ���ġ�	
	��� s �е��ַ����Ա��滻�õ� t ����ô�������ַ�����ͬ���ġ�
	
	���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����
	
	ʾ�� 1:	
		����: s = "egg", t = "add"
		���: true
	ʾ�� 2:	
		����: s = "foo", t = "bar"
		���: false
	ʾ�� 3:	
		����: s = "paper", t = "title"
		���: true
	˵��:
		����Լ��� s �� t ������ͬ�ĳ��ȡ�
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		String t = "aa";
		IsomorphicStrings is = new IsomorphicStrings();
		is.isIsomorphic(s, t);
	}

	// 205. ͬ���ַ���
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char chars = s.charAt(i);
			char chart = t.charAt(i);
			// �Ƿ����key,key-value�Ƿ��Ӧ
			if (map.containsKey(chars)) {
				if (map.get(chars) != chart) {
					return false;
				}
				// �Ƿ����value
			} else if (map.containsValue(chart)) {
				// ����value,��������key,����fasle
				if (!map.containsKey(chars)) {
					return false;
				}
				// ������keyҲ������value
			} else {
				map.put(chars, chart);
			}

		}
		return true;
	}

	// 1ms
	public boolean isIsomorphic1(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		char[] chas1 = s.toCharArray();
		char[] chas2 = t.toCharArray();
		int[] map = new int[512];
		for (int i = s.length() - 1; i >= 0; i--) { // ��һ��ӳ��������±궼����ͬһ������Ҳ��ֹ�˶��������
			if (map[chas1[i]] != map[chas2[i] + 256]) {
				return false;
			}
			map[chas1[i]] = map[chas2[i] + 256] = i;
		}
		return true;
	}
}
