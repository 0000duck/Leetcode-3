package Leetcode_409_LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

/*
	����һ��������д��ĸ��Сд��ĸ���ַ������ҵ�ͨ����Щ��ĸ����ɵ���Ļ��Ĵ���	
	�ڹ�������У���ע�����ִ�Сд������ "Aa" ���ܵ���һ�������ַ�����
	
	ע��:
		�����ַ����ĳ��Ȳ��ᳬ�� 1010��
	
	ʾ�� 1:	
		����:
			"abccccdd"
		
		���:
			7
		
		����:
			���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		new LongestPalindrome().longestPalindrome(s);
	}

	// 409. ����Ĵ�
	public int longestPalindrome(String s) {
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int oddCount = 0;
		for (Character ch : map.keySet()) {
			if (map.get(ch) % 2 == 0) {
				maxLength += map.get(ch);
			} else {
				maxLength += map.get(ch) - 1;
				oddCount++;
			}
		}

		if (oddCount >= 1) {
			maxLength++;
		}

		return maxLength;
	}

	// 5ms
	public int longestPalindrome0(String s) {
		int max = 'z' - 'A' + 1;
		int[] mark = new int[max];
		int maxLen = 0;
		char[] s1 = s.toCharArray();
		for (char aS1 : s1) {
			mark[aS1 - 'A']++;
		}
		boolean flag = false;
		for (int i = 0; i < max; i++) {
			if (mark[i] != 0) {
				if (mark[i] % 2 == 0) {
					maxLen += mark[i];
				} else {
					if (mark[i] >= 1) {
						flag = true;
						maxLen += mark[i] - 1;
					}
				}
			}
		}

		return flag ? maxLen + 1 : maxLen;
	}

}
