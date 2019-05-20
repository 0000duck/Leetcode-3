package Leetcode_1047_RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;
/*
	������Сд��ĸ��ɵ��ַ��� S���ظ���ɾ��������ѡ��������������ͬ����ĸ����ɾ�����ǡ�
	�� S �Ϸ���ִ���ظ���ɾ��������ֱ���޷�����ɾ����
	����������ظ���ɾ�������󷵻����յ��ַ������𰸱�֤Ψһ��
	
	ʾ����
		���룺"abbaca"
		�����"ca"
		���ͣ�
			���磬�� "abbaca" �У����ǿ���ɾ�� "bb" ��������ĸ��������ͬ��
			���Ǵ�ʱΨһ����ִ��ɾ���������ظ��֮�����ǵõ��ַ��� "aaca"��
			������ֻ�� "aa" ����ִ���ظ���ɾ�����������������ַ���Ϊ "ca"��
	��ʾ��
		1 <= S.length <= 20000
		S ����СдӢ����ĸ��ɡ�
 */

//1047.ɾ���ַ����е����������ظ���
public class RemoveAllAdjacentDuplicatesInString {

	public static void main(String[] args) {
		String S ="abbaca";
		System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates(S));

	}
	
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char ch : S.toCharArray()) {
        	if(!stack.isEmpty()&&stack.peek()==ch) {
        		stack.pop();
        	}else {
        		stack.push(ch);
        	}
        }
        StringBuilder sb  = new StringBuilder();
        while(!stack.isEmpty()) {
        	sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    
    //StringBuilder
    public String removeDuplicates2(String S) {
    	StringBuilder sb = new StringBuilder();
    	for(char ch:S.toCharArray()) {
    		if(sb.length()>0&&sb.charAt(sb.length()-1)==ch) {
    			sb.deleteCharAt(sb.length()-1);
    		}else {
    			sb.append(ch);
    		}
    	}
    	return sb.toString();
    }

}
