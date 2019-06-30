package Leetcode_FindKLengthSubstringsWithNoRepeatedCharacters;

import java.util.HashMap;

/*
	����һ���ַ��� S���ҳ����г���Ϊ K �Ҳ����ظ��ַ����Ӵ������㷵��ȫ������Ҫ����Ӵ��� ��Ŀ��	 
	
	ʾ�� 1��	
		���룺S = "havefunonleetcode", K = 5
		�����6
		���ͣ�
			������ 6 ������������Ӵ����ֱ��ǣ�'havef','avefu','vefun','efuno','etcod','tcode'��	
	
	ʾ�� 2��	
		���룺S = "home", K = 5
		�����0
		���ͣ�
			ע�⣺K ���ܻ���� S �ĳ��ȡ�����������£����޷��ҵ��κγ���Ϊ K ���Ӵ���	 
	
	��ʾ��	
		1 <= S.length <= 10^4
		S �е������ַ���ΪСдӢ����ĸ
		1 <= K <= 10^4
 */
//
public class FindKLengthSubstringsWithNoRepeatedCharacters {
	// 1099.����Ϊ K �����ظ��ַ��Ӵ�
	public int numKLenSubstrNoRepeats(String S, int K) {
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		char[] srr = S.toCharArray();
		int j = 0;// [j,i]Ϊ����
		for (int i = 0; i < srr.length;) {
			if (map.containsKey(srr[i])) {
				int temp = map.get(srr[i]);
				for (; j <= temp; j++) {
					map.remove(srr[j]);
				}
			} else {
				map.put(srr[i], i);
				if (i - j + 1 == K) {
					res++;
					map.remove(srr[j++]);
				}
				i++;
			}
		}
		return res;
	}
}
