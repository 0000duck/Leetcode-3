package Leetcode_093_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
	����һ��ֻ�������ֵ��ַ�������ԭ�����������п��ܵ� IP ��ַ��ʽ��
	
	ʾ��:	
		����: "25525511135"
		���: ["255.255.11.135", "255.255.111.35"]
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/restore-ip-addresses
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
//93. ��ԭIP��ַ
public class RestoreIPAddresses {
	List<String> res = new ArrayList<>();
	String s;

	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.length() == 0) {
			return res;
		}
		this.s = s;
		dfs(0, "", 0);
		return res;
	}

	private void dfs(int curLength, String cur, int count) {
		if (count > 4) {
			return;
		}
		if (count == 4 && curLength == s.length()) {
			res.add(cur);
		}
		for (int i = 1; i < 4; i++) {
			if (curLength + i > s.length()) {
				break;
			}
			String str = s.substring(curLength, curLength + i);
			if ((str.startsWith("0") && str.length() > 1) || (i == 3 && Integer.valueOf(str) >= 256)) {
				continue;
			}
			dfs(curLength + i, cur + str + (count == 3 ? "" : "."), count + 1);
		}
	}
}
