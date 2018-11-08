package Leetcode_038_CountandSay;

/*
	����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�
	
	1.     1
	2.     11
	3.     21
	4.     1211
	5.     111221
	1 ������  "one 1"  ("һ��һ") , �� 11��
	11 ������ "two 1s" ("����һ"��, �� 21��
	21 ������ "one 2",  "one 1" ��"һ����" ,  "һ��һ") , �� 1211��
	
	����һ�������� n��1 �� n �� 30��������������еĵ� n �
	
	ע�⣺����˳�򽫱�ʾΪһ���ַ�����
	
	ʾ�� 1:	
		����: 1
		���: "1"
	ʾ�� 2:	
		����: 4
		���: "1211"
 */
public class CountandSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay cs = new CountandSay();
		System.out.println(cs.countAndSay(3));
	}

	// 38. ����
	public String countAndSay(int n) {
		// n=1
		if (n == 1) {
			return "1";
		}
		// n>=2
		String str = "11";
		char[] charr = str.toCharArray();
		while (n > 2) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int i = 1; i < charr.length; i++) {
				// ��ǰһ�����
				if (charr[i - 1] == charr[i]) {
					//��ȣ�count++
					count++;
				}else {
					//�����,���Ӹ��������֣�����������
					sb.append(count).append(charr[i-1]);
					count = 1;
				}
				//������һ�����֣����������Ӹ���������
				if(i==charr.length-1) {
					sb.append(count).append(charr[i]);
				}
			}
			//����������������
			charr = sb.toString().toCharArray();
			n--;
		}
		
		return String.valueOf(charr);
	}

}
