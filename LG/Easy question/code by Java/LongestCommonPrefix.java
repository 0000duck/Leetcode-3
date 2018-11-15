package Leetcode_014_LongestCommonPrefix;
/*
	��дһ�������������ַ��������е������ǰ׺��
	
	��������ڹ���ǰ׺�����ؿ��ַ��� ""��
	
	ʾ�� 1:		
		����: ["flower","flow","flight"]
		���: "fl"
	ʾ�� 2:	
		����: ["dog","racecar","car"]
		���: ""
	����: ���벻���ڹ���ǰ׺��
	˵��:	
		��������ֻ����Сд��ĸ a-z ��
*/
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String[] strs= {"babb","caa"};
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(strs));
	}
	//14. �����ǰ׺
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length==0) {
    		return "";
    	}else if(strs.length==1) {
    		return strs[0];
    	}
    	//�ҳ���̵ĵ���
        int minlength = strs[0].length();//��̵��ʵĳ���
        int minindex = 0;//��̵��ʵ�λ��
        for(int i =1;i<strs.length;i++) {
        	if(minlength>strs[i].length()) {
        		minlength = strs[i].length();
        		minindex = i;
        	}
        }
        
        //����̵��ʿ�ʼ�Ƚ� 	
        StringBuilder minbuffer = new StringBuilder(strs[minindex]);
        //�������е���
        for(int i = 0;i<strs.length;i++) {           
            int length = minbuffer.length();
            //��ɾ�꣬�ͷ���
            if(length==0) {
            	return minbuffer.toString();
            }
            //�ж�strs[i]�Ƿ���minbuffer��ͷ
        	if(strs[i].startsWith(minbuffer.toString())) {
        		//����
        		continue;
        	}else {
        		//����ɾ��minbuffer�����һ���ַ�
        		minbuffer.deleteCharAt(minbuffer.length()-1);
        		i=-1;
        		continue;
        	}
        	
        }
        
        return minbuffer.toString();
        
        
    }

}
