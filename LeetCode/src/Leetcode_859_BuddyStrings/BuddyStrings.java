package Leetcode_859_BuddyStrings;
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
		 if(A.length()!=B.length()){
			return false; 
		 }
		
		 StringBuilder abulider = new StringBuilder(A);
		 StringBuilder bbulider = new StringBuilder(B);
		 if(abulider.length()==2) {
			 abulider.reverse();
			 if(abulider.reverse().indexOf(B)!=-1) {
				 return true;
			 }else {
				 return false;
			 }
		 }
		 //ɾ����ͬλ�õ��ַ�
		 for(int i = 0;i<abulider.length();) {
			 if(abulider.charAt(i)==bbulider.charAt(i)) {
				 abulider.deleteCharAt(i);
				 bbulider.deleteCharAt(i);				 
			 }else {
				 i++;
			 }
		 }
		 //�жϳ����Ƿ�Ϊ2
		 if(abulider.length()!=2) {
			 return false;
		 }
		 if(abulider.reverse().indexOf(B)==-1) {
			 return false;
		 }
		 return true;
	 }

}
