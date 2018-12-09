package Leetcode_438_FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	����һ���ַ��� s ��һ���ǿ��ַ��� p���ҵ� s �������� p ����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������	
	�ַ���ֻ����СдӢ����ĸ�������ַ��� s �� p �ĳ��ȶ������� 20100��
	
	˵����	
		��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
		�����Ǵ������˳��
		
	ʾ�� 1:	
		����:
			s: "cbaebabacd" p: "abc"		
		���:
			[0, 6]		
		����:
			��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����ĸ��λ�ʡ�
			��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����ĸ��λ�ʡ�
	
	 ʾ�� 2:	
		����:
		s: "abab" p: "ab"		
		���:
		[0, 1, 2]	
	����:
		��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
		��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����ĸ��λ�ʡ�
		��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
 */
public class FindAllAnagramsinaString {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String s = "abab";
		String p = "ab";
		new FindAllAnagramsinaString().findAnagrams(s, p);
	}

	// 438. �ҵ��ַ�����������ĸ��λ��
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		int m = s.length();
		int n = p.length();
		if (m < n) {
			return list;
		}
		for (int i = 0; i <= m - n; i++) {
			int[] t = new int[26];
			for (int j = 0; j < n; j++) {
				t[s.charAt(i + j) - 'a']++;
				t[p.charAt(j) - 'a']--;
			}
			boolean flag = true;
			for (int j = 0; j < t.length; j++) {
				if (t[j] != 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				list.add(i);
		}
		return list;
	}

	// 7ms
	public List<Integer> findAnagrams0(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		int[] sump = new int[123];
		int[] sums = new int[123];
		char[] chs = s.toCharArray();
		char[] chp = p.toCharArray();
		int k = chp.length, end = chp.length;
		if (chs.length < end)
			return list;

		for (int i = 0; i < end; i++) {
			sump[chp[i]]++;
			sums[chs[i]]++;
		}

		while (true) {
			boolean flag = true;
			for (int j = 97; j < 123; j++) {
				if (sums[j] != sump[j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				list.add(k - end);
			if (k == chs.length)
				break;
			sums[chs[k - end]]--;
			sums[chs[k]]++;
			k++;
		}
		return list;
	}

	// ��ʱ
	private Map<Character, Integer> mapP;

	public List<Integer> findAnagrams2(String s, String p) {
		
		List<Integer> list = new ArrayList<Integer>();
		if(s.length()<p.length()){
			return list;
		}
		// p��map
		mapP = stringtoMap(p);
		for (int i = 0; i <= s.length() - p.length(); i++) {
			Map<Character, Integer> mapTemp = stringtoMap(s.substring(i, i + p.length()));
			if (equalsToMapP(mapTemp)) {
				list.add(i);
			}
		}
		return list;

	}

	// String to Map
	public Map<Character, Integer> stringtoMap(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}
		return map;
	}

	// mapTemp �Ƿ����mapP
	public boolean equalsToMapP(Map<Character, Integer> mapTemp) {
		for (Character ch : mapP.keySet()) {
			if (mapTemp.containsKey(ch) && (mapTemp.get(ch) == mapP.get(ch))) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
