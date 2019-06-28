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
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = String.valueOf(arr);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(key, list);
			}
		}
		List<List<String>> res = new ArrayList<>();
		for (String key : map.keySet()) {
			res.add(map.get(key));
		}
		return res;

	}

}
