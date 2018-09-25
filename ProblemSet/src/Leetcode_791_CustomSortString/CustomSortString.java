package Leetcode_791_CustomSortString;

/*
	�ַ���S�� T ֻ����Сд�ַ�����S�У������ַ�ֻ�����һ�Ρ�
	
	S �Ѿ�����ĳ�ֹ������������
	����Ҫ����S�е��ַ�˳���T��������
	�������˵�����S��x��y֮ǰ���֣���ô���ص��ַ�����xҲӦ������y֮ǰ��
	
	��������һ�ַ����������ַ���T��
	
	ʾ��:
		����:
			S = "cba"
			T = "abcd"
		���: "cbad"
	����: 
		S�г������ַ� "a", "b", "c", ���� "a", "b", "c" ��˳��Ӧ���� "c", "b", "a". 
		���� "d" û����S�г���, �����Է���T������λ��. "dcba", "cdba", "cbda" ���ǺϷ��������
	ע��:
		S����󳤶�Ϊ26������û���ظ����ַ���
		T����󳤶�Ϊ200��
		S��Tֻ����Сд�ַ���
*/
import java.util.HashMap;

public class CustomSortString {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String S = "kqep";
		String T = "pekeq";
		CustomSortString css = new CustomSortString();
		System.out.println("kqeep");
		System.out.println(css.customSortString(S, T));

	}

	// 791.�Զ����ַ�������
	public String customSortString(String S, String T) {
		// ��S��˳������ַ���HashMap
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), i);
		}
		// System.out.println(map);
		// ��T��������
		char[] t = T.toCharArray();
		int m = 0;
		int n = 0;
		for (int i = 0; i < t.length - 1; i++) {
			if (map.get(t[i]) == null) {
				continue;
			}
			m = map.get(t[i]);
			// System.out.println(t[i]+":"+m);
			for (int j = i + 1; j < t.length; j++) {
				if (map.get(t[j]) == null) {
					continue;
				}				
				n = map.get(t[j]);
				// System.out.println(t[j]+":"+n);
				if (m > n) {
					char temp = t[i];
					t[i] = t[j];
					m = map.get(t[i]);
					t[j] = temp;
					n = map.get(t[j]);
				}
			}
		}

		return new String(t);

	}

}
