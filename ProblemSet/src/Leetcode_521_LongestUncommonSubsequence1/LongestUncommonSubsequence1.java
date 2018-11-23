package Leetcode_521_LongestUncommonSubsequence1;
/*
	���������ַ���������Ҫ���������ַ������ҳ�����������С���������ж������£�������Ϊĳ�ַ������е�������У��������������ַ����������У���	
	�����п���ͨ��ɾȥ�ַ����е�ĳЩ�ַ�ʵ�֣������ܸı�ʣ���ַ������˳�򡣿�����Ϊ�����ַ����������У��κ��ַ���Ϊ������������С�	
	����Ϊ�����ַ����������������еĳ��ȡ���������ڣ��򷵻� -1��
	
	ʾ�� :	
		����:
			"aba", "cdc"
		���: 
			3
		����: 
			��������п�Ϊ "aba" (�� "cdc")
	
	˵��:	
		�����ַ������Ⱦ�С��100��
		�ַ����е��ַ������� 'a'~'z'��
 */
public class LongestUncommonSubsequence1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}
	//521. ��������� ��
    public int findLUSlength(String a, String b) {
        //��ȡ����
    	int alength = a.length();
    	int blength = b.length();
    	if(alength!=blength) {
    		//���ȴ�Ŀ϶�������һ����������
    		return Math.max(alength, blength);
    	}else {
    		//�ַ�����ȣ��϶�����һ����������
    		if(a.equals(b)) {
    			return -1;
    		}else {
    			//������ȣ������ȣ�˵������֮�䲻�������һ��������
    			return alength;
    		}
    	}
    }

}
