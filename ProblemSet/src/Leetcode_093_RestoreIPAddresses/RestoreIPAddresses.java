package Leetcode_093_RestoreIPAddresses;

import java.util.ArrayList;
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
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s==null||s.length()<4) {
        	return res;
        }
        restoreIpAddresses(s,1,1,1,1,res);
        
        return res;
    }

	private void restoreIpAddresses(String s, int i, int j, int k, int l, List<String> res) {
				
	}
}
