package Leetcode_811_SubdomainVisitCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	һ����վ��������"discuss.leetcode.com"�������˶������������Ϊ�������������õ���"com"����һ������"leetcode.com"����͵�һ��Ϊ"discuss.leetcode.com"�������Ƿ�������"discuss.leetcode.com"ʱ��Ҳͬʱ�������丸����"leetcode.com"�Լ��������� "com"��
	
	����һ�������ʴ�������������ϣ�Ҫ��ֱ����ÿ�����������ʵĴ��������ʽΪ���ʴ���+�ո�+��ַ�����磺"9001 discuss.leetcode.com"��
	
	�����������һ����ʴ�����������ϵ��б�cpdomains ��Ҫ����������������ķ��ʴ����������ʽ�������ʽ��ͬ�����޶��Ⱥ�˳��
	
	ʾ�� 1:
		����: 
		["9001 discuss.leetcode.com"]
		���: 
		["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
	˵��: 
		�����н�����һ����վ������"discuss.leetcode.com"������ǰ�ļ��裬������"leetcode.com"��"com"���ᱻ���ʣ��������Ƕ���������9001�Ρ�
	
	ʾ�� 2
		����: 
		["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
		���: 
		["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
	˵��: 
		���ռ��裬�����"google.mail.com" 900�Σ�"yahoo.com" 50�Σ�"intel.mail.com" 1�Σ�"wiki.org" 5�Ρ�
		�����ڸ������������"mail.com" 900+1 = 901�Σ�"com" 900 + 50 + 1 = 951�Σ��� "org" 5 �Ρ�
	
	ע�����	
		 cpdomains �ĳ���С�� 100��
		ÿ�������ĳ���С��100��
		ÿ��������ַ����һ��������"."���š�
		����������һ�������ķ��ʴ�����С��10000��
 */
public class SubdomainVisitCount {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SubdomainVisitCount svc = new SubdomainVisitCount();
		String[] cpdomains = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
		System.out.println(svc.subdomainVisits(cpdomains));
		String[] str = { "901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org",
				"1 intel.mail.com", "951 com" };
		System.out.println(Arrays.toString(str));
	}

	// 811. ���������ʼ���
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < cpdomains.length; i++) {
			String[] temp = cpdomains[i].split(" ");
			int count = Integer.valueOf(temp[0]);
			map.put(temp[1], map.getOrDefault(temp[1], 0) + count);
			StringBuilder sbtemp = new StringBuilder(temp[1]);
			while (sbtemp.indexOf(".") != -1) {
				String str = sbtemp.substring(sbtemp.indexOf(".") + 1, sbtemp.length());
				map.put(str, map.getOrDefault(str, 0) + count);
				sbtemp.delete(0, sbtemp.indexOf(".") + 1);
			}
		}
		List<String> list = new ArrayList<String>();
		for (String s : map.keySet()) {
			StringBuilder sb = new StringBuilder();
			list.add(sb.append(map.get(s)).append(" ").append(s).toString());
		}
		return list;
	}
	
	//13ms
	public List<String> subdomainVisits0(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            if (domain.length() == 0) continue; // ����������
            int index = domain.indexOf(' ');    // ��һ���ո���ֵ�λ��
            int time = Integer.valueOf(domain.substring(0, index)); // �ո�ǰ���ַ�Ϊ���ִ���
            domain = domain.substring(index+1); // �ո����ַ�Ϊ����
            map.put(domain, map.getOrDefault(domain, 0)+time);   // ÿ�θ����ַ���ƥ����ִ�������һ�γ��ֳ�ʼֵΪ0��������Ҫ�ۼ�
            
            // �������ı߽�Ϊ'.'
            while (domain.indexOf('.') != -1) {
                domain = domain.substring(domain.indexOf('.')+1);
                map.put(domain, map.getOrDefault(domain, 0)+time);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getValue() + " " + entry.getKey();  // ���ִ�����������ƴ��
            res.add(s);
        }
        return res;
    }

}
