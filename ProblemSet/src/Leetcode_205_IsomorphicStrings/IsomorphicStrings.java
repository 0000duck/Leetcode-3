package Leetcode_205_IsomorphicStrings;

import java.util.Arrays;
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

	public boolean isIsomorphic2(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		HashMap<Character, Character> map = new HashMap<>();// ӳ���ϵ
		HashSet<Character> set = new HashSet<>();// ��֤ͬһ���ַ�����ӳ������
		for (int i = 0; i < sc.length; i++) {
			if (!map.containsKey(sc[i])) {
				if (set.contains(tc[i])) {
					return false;
				}
				map.put(sc[i], tc[i]);
				set.add(tc[i]);
			} else if (map.get(sc[i]) != tc[i]) {
				return false;
			}
		}
		return true;
	}

	// �ַ����Ĺ��ɰ������ֺ���ĸ
	// �����ַ�����ӳ�䵽ͬһ���ַ���s->t t->x����
	// �ַ�����ӳ�䵽����
	public boolean isIsomorphic3(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		int[] ascii = new int[512];
		for (int i = sc.length - 1; i >= 0; i--) {
			// ��һ��ӳ��������±궼����ͬһ��������ֹ���ӳ��
			if (ascii[sc[i]] != ascii[tc[i] + 256]) {
				return false;
			}
			ascii[sc[i]] = ascii[tc[i] + 256] = i;
		}
		return true;
	}
}
