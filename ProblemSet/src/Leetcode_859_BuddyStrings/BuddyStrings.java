package Leetcode_859_BuddyStrings;

import java.util.HashSet;
import java.util.Set;

/*
����������Сд��ĸ���ɵ��ַ��� A �� B ��ֻҪ���ǿ���ͨ������ A �е�������ĸ�õ��� B ��ȵĽ�����ͷ��� true �����򷵻� false ��
ʾ�� 1��
	���룺 A = "ab", B = "ba"
	����� true
ʾ�� 2��
	���룺 A = "ab", B = "ab"
	����� false
ʾ�� 3:
	���룺 A = "aa", B = "aa"
	����� true
ʾ�� 4��
	���룺 A = "aaaaaaabc", B = "aaaaaaacb"
	����� true
ʾ�� 5��
	���룺 A = "", B = "aa"
	����� false
��ʾ��
	0 <= A.length <= 20000
	0 <= B.length <= 20000
	A �� B ����Сд��ĸ���ɡ�
*/
public class BuddyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuddyStrings bs = new BuddyStrings();
		System.out.println(bs.buddyStrings("aaaaaaabc","aaaaaaacb"));
		
	}
	//859. �����ַ���
	 public boolean buddyStrings(String A, String B) {
		 //����һ��Ϊ��
		 if((A.length()==0)||(B.length()==0)) {
			 return false;
		 }
		 //A,B���Ȳ����
		 if(A.length()!=B.length()) {
			 return false;
		 }
		 //A,B������ͬ
		 if(A.equals(B)) {
			 //�ж��ַ��Ƿ��ظ�
			 Set<Character> set = new HashSet<Character>();
			 for(int i = 0;i<A.length();i++) {
				 set.add(A.charAt(i));
			 }
			 //set�Ĵ�С��A�ĳ�����ͬ��˵�����ظ�
			 if(set.size()==A.length()) {
				 return false;
			 }
			 return true;
		 }
		 //���ݲ�ͬ
		 //������
		 int count = 0;
		 Set<Character> seta = new HashSet<Character>();
		 Set<Character> setb = new HashSet<Character>();
		 for(int i = 0;i<A.length();i++) {
			 if(A.charAt(i)!=B.charAt(i)) {
				 count++;
				 seta.add(A.charAt(i));
				 setb.add(B.charAt(i));
			 }
			 if(count>2) {
				 return false;
			 }
		 }
		 //�ж�seta��setb�Ƿ���ͬ
		 if((count==2)&(seta.equals(setb))) {
			 return true;
		 }
		 return false;
	 }

}
