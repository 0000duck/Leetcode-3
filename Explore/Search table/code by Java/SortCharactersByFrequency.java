package Leetcode_451_SortCharactersByFrequency;

import java.util.HashMap;
import java.util.Map;

/*
	����һ���ַ������뽫�ַ�������ַ����ճ��ֵ�Ƶ�ʽ������С�
	
	ʾ�� 1:
		����:
			"tree"
		���:
			"eert"	
	����:
		'e'�������Σ�'r'��'t'��ֻ����һ�Ρ�
		���'e'���������'r'��'t'֮ǰ�����⣬"eetr"Ҳ��һ����Ч�Ĵ𰸡�
		
	ʾ�� 2:
		����:
			"cccaaa"
		���:
			"cccaaa"
	����:
		'c'��'a'���������Ρ����⣬"aaaccc"Ҳ����Ч�Ĵ𰸡�
		ע��"cacaca"�ǲ���ȷ�ģ���Ϊ��ͬ����ĸ�������һ��
		
	ʾ�� 3:
		����:
			"Aabb"
		
		���:
			"bbAa"
	����:
		���⣬"bbaA"Ҳ��һ����Ч�Ĵ𰸣���"Aabb"�ǲ���ȷ�ġ�
		ע��'A'��'a'����Ϊ�����ֲ�ͬ���ַ���
*/
public class SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortCharactersByFrequency scby = new SortCharactersByFrequency();
		System.out.println(scby.frequencySort("eeeee"));
	}

	// 451. �����ַ�����Ƶ������
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			map.put(cur, map.getOrDefault(cur, 0) + 1);

		}
		StringBuilder sb = new StringBuilder();
		for (int i = s.length(); i >= 1; i--) {
			for (Character ch : map.keySet()) {
				if (map.get(ch) == i) {
					for (int j = 0; j < i; j++) {
						sb.append(ch);
					}
				}
			}
		}
		return sb.toString();
	}

	public String frequencySort2(String s) {
		// �����ַ���������
		StringBuffer buffer = new StringBuffer(s);// tree
		StringBuffer result = new StringBuffer();
		// ɾ���ظ��ַ�
		for (int i = 0; i < buffer.length() - 1; i++) {
			for (int j = i + 1; j < buffer.length();) {
				if (buffer.charAt(i) == buffer.charAt(j)) {
					buffer.deleteCharAt(j);
				} else {
					j++;
				}
			}
		}
		if (buffer.length() == 1) {
			return s;
		}
		// ͳ���ַ���Ƶ�� tre
		int[] requency = new int[buffer.length()];// 112
		for (int i = 0; i < buffer.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (buffer.charAt(i) == s.charAt(j)) {
					requency[i]++;
				}
			}
		}

		// ����Ƶ������
		char[] bufferchar = buffer.toString().toCharArray();
		for (int i = 0; i < requency.length - 1; i++) {
			for (int j = i + 1; j < requency.length; j++) {
				if (requency[i] < requency[j]) {
					int temp = requency[i];
					char tempchar = bufferchar[i];
					requency[i] = requency[j];
					bufferchar[i] = bufferchar[j];
					requency[j] = temp;
					bufferchar[j] = tempchar;
				}
			}
			for (int m = 0; m < requency[i]; m++) {
				result.append(bufferchar[i]);
			}
			// ���һ����ĸ
			if (i == requency.length - 2) {
				for (int m = 0; m < requency[requency.length - 1]; m++) {
					result.append(bufferchar[requency.length - 1]);
				}
			}

		}

		return result.toString();

	}

}
