package Leetcode_929_UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

/*
	ÿ������ʼ�����һ���������ƺ�һ��������ɣ��� @ ���ŷָ���	
	���磬�� alice@leetcode.com�У� alice �Ǳ������ƣ��� leetcode.com ��������
	����Сд��ĸ����Щ�����ʼ������ܰ��� ',' �� '+'��	
	����ڵ����ʼ���ַ�ı������Ʋ����е�ĳЩ�ַ�֮����Ӿ�㣨'.'��������������ʼ�����ת��������������û�е��ͬһ��ַ��
	���磬"alice.z@leetcode.com�� �� ��alicez@leetcode.com�� ��ת����ͬһ�����ʼ���ַ�� ����ע�⣬�˹�����������������
	����ڱ�����������ӼӺţ�'+'���������Ե�һ���Ӻź�����������ݡ����������ĳЩ�����ʼ���
	���� m.y+name@email.com ��ת���� my@email.com�� ��ͬ�����˹�����������������	
	����ͬʱʹ������������	
	���������ʼ��б� emails�����ǻ����б��е�ÿ����ַ����һ������ʼ���ʵ���յ��ʼ��Ĳ�ͬ��ַ�ж��٣�
	
	ʾ����
		���룺
		["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
		�����2
		���ͣ�ʵ���յ��ʼ����� "testemail@leetcode.com" �� "testemail@lee.tcode.com"��	 
		
	��ʾ��		
		1 <= emails[i].length <= 100
		1 <= emails.length <= 100
		ÿ�� emails[i] ���������ҽ���һ�� '@' �ַ���
 */
public class UniqueEmailAddresses {
	public static void main(String[] args) {
		UniqueEmailAddresses uea = new UniqueEmailAddresses();
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		uea.numUniqueEmails2(emails);
	}

	// 929. ���صĵ����ʼ���ַ
	public int numUniqueEmails(String[] emails) {
		String[][] emailsArray = new String[emails.length][2];
		HashSet<String> emailset = new HashSet();
		StringBuilder temp;
		//
		for (int i = 0; i < emails.length; i++) {

			// int atindex = temp.lastIndexOf("@");
			emailsArray[i] = emails[i].split("@");
			temp = new StringBuilder(emailsArray[i][0]);
			if (temp.indexOf("+") != -1) {
				temp.delete(temp.indexOf("+"), temp.length());
				// emailsArray[i][0]=emailsArray[i][0].substring(0,
				// emailsArray[i][0].indexOf("+"));
			}
			while (temp.indexOf(".") != -1) {
				temp.deleteCharAt(temp.indexOf("."));
				// emailsArray[i][0]=emailsArray[i][0].replaceAll(".", "");
			}
			emailset.add(temp.append("@").append(emailsArray[i][1]).toString());

		}

		return emailset.size();
	}

	// 9ms��Ϊʲô����Ҫ��ӱ������ƣ�
	public int numUniqueEmails2(String[] emails) {
		Set<String> unique = new HashSet<>();
		for (String email : emails) {
			String host = email.substring(email.indexOf("@"));
			unique.add(host);
		}
		return unique.size();
	}
}
