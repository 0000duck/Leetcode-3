package Leetcode_387_FirstUniqueCharacterinaString;

import java.util.HashMap;
import java.util.Map;

/*
	����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��
	
	����:	
		s = "leetcode"
		���� 0.
	
		s = "loveleetcode",
		���� 2.
*/
public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstUniqueCharacterinaString fucs = new FirstUniqueCharacterinaString();
		System.out.println("loveleetcode");
		System.out.println(fucs.firstUniqChar2("loveleetcode"));

	}

	// 387.�ַ����еĵ�һ��Ψһ�ַ�
	public int firstUniqChar2(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), -1);
			} else {
				map.put(s.charAt(i), i);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == -1) {
				return i;
			}
		}

		return -1;

	}

	// 5ms
	public int firstUniqChar0(String s) {
		int res = -1;
		for (char i = 'a'; i <= 'z'; i++) {
			int index = s.indexOf(i);
			if (index != -1 && index == s.lastIndexOf(i)) {
				res = (res == -1 || res > index) ? index : res;
			}
		}
		return res;
	}

	// 1ˢ
	public int firstUniqChar(String s) {
		// �ַ�������Ϊ1
		if (s.length() == 1) {
			return 0;
		}
		// �ַ�����
		char[] chs = s.toCharArray();
		int length = chs.length;
		int[] flag = new int[chs.length];
		for (int i = 0; i < length; i++) {
			// ǰ���Ƿ����
			if (i > 0) {
				if (flag[i - 1] == 0) {
					return i - 1;
				}
			}
			if (flag[i] != 0) {
				continue;
			}
			// ���һλ
			if (i == length - 1) {
				return i;
			}
			for (int j = i + 1; j < length; j++) {
				if (flag[j] != 0) {
					continue;
				}
				if (chs[i] == chs[j]) {
					flag[i]++;
					flag[j]++;
				}
			}

		}
		return -1;

	}

}
