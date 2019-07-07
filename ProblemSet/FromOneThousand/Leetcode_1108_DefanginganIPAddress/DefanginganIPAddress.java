package Leetcode_1108_DefanginganIPAddress;

/*
	����һ����Ч�� IPv4 ��ַ address��������� IP ��ַ����Ч���汾��	
	��ν��Ч�� IP ��ַ����ʵ������ "[.]" ������ÿ�� "."��	 
	
	ʾ�� 1��	
		���룺address = "1.1.1.1"
		�����"1[.]1[.]1[.]1"
	ʾ�� 2��	
		���룺address = "255.100.50.0"
		�����"255[.]100[.]50[.]0"	 
	
	��ʾ��	
		������ address ��һ����Ч�� IPv4 ��ַ
 */
public class DefanginganIPAddress {
	// 1108.IP ��ַ��Ч��
	public String defangIPaddr(String address) {
		StringBuilder res = new StringBuilder();
		for (char ch : address.toCharArray()) {
			if (ch != '.') {
				res.append(ch);
			} else {
				res.append("[.]");
			}
		}
		return res.toString();
	}
}
