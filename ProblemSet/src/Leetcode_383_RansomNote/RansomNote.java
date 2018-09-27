package Leetcode_383_RansomNote;
/*
	����һ������� (ransom) �ַ�����һ����־(magazine)�ַ�����
	�жϵ�һ���ַ���ransom�ܲ����ɵڶ����ַ���magazines������ַ����ɡ�
	������Թ��ɣ����� true �����򷵻� false��
	
	(��Ŀ˵����Ϊ�˲���¶������ּ���Ҫ����־������������Ҫ����ĸ����ɵ����������˼��)
	
	ע�⣺
	
	����Լ��������ַ�����ֻ����Сд��ĸ��
	
	canConstruct("a", "b") -> false
	canConstruct("aa", "ab") -> false
	canConstruct("aa", "aab") -> true
*/
public class RansomNote {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		RansomNote rn = new RansomNote();
		System.out.println(rn.canConstruct("aa", "ab"));
	}
	//383. �����
	public boolean canConstruct(String ransomNote, String magazine) {
		//ransomNote�Ĺ���
		if(ransomNote.length()==1) {
			if(magazine.indexOf(ransomNote)==-1) {
				return false;
			}
		}
		//�ַ�������
		StringBuffer ransomNotebuffer = new StringBuffer(ransomNote);		
		//����ж��ŵĹ���
		for(int i=0;i<ransomNotebuffer.length()-1;i++) {
			int count = 1;
			for(int j =i+1;j<ransomNotebuffer.length();j++) {
				if(ransomNotebuffer.charAt(i)==ransomNotebuffer.charAt(j)) {
					ransomNotebuffer.deleteCharAt(j);
					count++;
				}
			}
			if(!magazineCons(magazine,ransomNote.charAt(i),count)) {
				return false;
			}			
		}
		
		return true;
	}
	public boolean magazineCons(String magazine,char ch,int count) {
		int chcount = 0;
		for(int i=0;i<magazine.length();i++ ) {
			if(magazine.charAt(i)==ch) {
				chcount++;
				if(chcount==count) {
					return true;
				}
			}
		}
		return false;
		
	}
}
