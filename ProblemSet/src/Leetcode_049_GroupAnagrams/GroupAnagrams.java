package Leetcode_049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
	
	ʾ��:	
		����: ["eat", "tea", "tan", "ate", "nat", "bat"],
		���:
		[
		  ["ate","eat","tea"],
		  ["nat","tan"],
		  ["bat"]
		]
	˵����	
		���������ΪСд��ĸ��
		�����Ǵ������˳��
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams ga = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(ga.groupAnagrams(strs));
	}

	// 49. ��ĸ��λ�ʷ���
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		if (strs.length == 0) {
			return list;
		}
		Map<String, List<String>> types = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] kk = strs[i].toCharArray();
			Arrays.sort(kk);
			String key = new String(kk);
			if (!types.containsKey(key)) {
				List<String> keys = new ArrayList<>();
				keys.add(strs[i]);
				types.put(key, keys);
				list.add(keys);
			} else {
				types.get(key).add(strs[i]);
			}
		}
		return list;
	}

	// ��ʱ
	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		ArrayList<String> strlist = new ArrayList<String>();
		strlist.add(strs[0]);
		list.add(strlist);
		// �����ַ���
		for (int i = 1; i < strs.length; i++) {
			// �ַ���ת����
			char[] temp = strs[i].toCharArray();
			// ����list
			for (int x = 0; x < list.size(); x++) {
				char[] temp2 = list.get(x).get(0).toCharArray();
				if (equalsTo(temp, temp2)) {
					list.get(x).add(strs[i]);
					break;
				}
				if (x == list.size() - 1) {
					strlist = new ArrayList<String>();
					strlist.add(strs[i]);
					list.add(strlist);
					break;
				}
			}

		}
		return list;
	}

	public boolean equalsTo(char[] temp1, char[] temp2) {
		if (temp1.length != temp2.length) {
			return false;
		}
		Arrays.sort(temp1);
		Arrays.sort(temp2);
		for (int i = 0; i < temp1.length; i++) {
			if (temp1[i] != temp2[i]) {
				return false;
			}
		}
		return true;
	}

}
