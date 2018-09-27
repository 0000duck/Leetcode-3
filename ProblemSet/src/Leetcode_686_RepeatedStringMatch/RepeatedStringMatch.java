package Leetcode_686_RepeatedStringMatch;
/*
	���������ַ��� A �� B, Ѱ���ظ������ַ���A����С������ʹ���ַ���B��Ϊ���Ӻ���ַ���A���Ӵ�������������򷵻� -1��
	
	�ٸ����ӣ�A = "abcd"��B = "cdabcdab"��	
	��Ϊ 3�� ��Ϊ A �ظ����������Ϊ ��abcdabcdabcd������ʱ B �����Ӵ���A �ظ����������Ϊ"abcdabcd"��B ���������Ӵ���
	
	ע��:	
	 	A �� B �ַ����ĳ�����1��10000���䷶Χ�ڡ�
*/
public class RepeatedStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedStringMatch rsm = new RepeatedStringMatch();
		System.out.println(rsm.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab","ba"));
	}
	//686. �ظ������ַ���ƥ��//��ʱ
    public int repeatedStringMatch(String A, String B) {
    	//������
    	int count=1;
        StringBuilder abuilder = new StringBuilder(A);
        StringBuilder bbuilder = new StringBuilder(B);
        
        while((abuilder.length()<=bbuilder.length())&&(count<=bbuilder.length())){        	  	
        	if(abuilder.indexOf(B)!=-1) {
        		return count;
        	}
        	count++;      
        	abuilder.append(A);
        }
        return -1;
    }
}
