package Leetcode_1106_ParsingABooleanExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
	����һ�����ַ�����ʽ������ �������ʽ��boolean�� expression�����ظ�ʽ����������
	
	��Ч�ı��ʽ����ѭ����Լ����	
		"t"��������Ϊ True
		"f"��������Ϊ False
		"!(expr)"���������Ϊ���ڲ����ʽ expr �����߼� �ǵ����㣨NOT��
		"&(expr1,expr2,...)"���������Ϊ�� 2 ���������ڲ����ʽ expr1, expr2, ... �����߼� ������㣨AND��
		"|(expr1,expr2,...)"���������Ϊ�� 2 ���������ڲ����ʽ expr1, expr2, ... �����߼� ������㣨OR��	 
	
	ʾ�� 1��	
		���룺expression = "!(f)"
		�����true
	ʾ�� 2��	
		���룺expression = "|(f,t)"
		�����true
	ʾ�� 3��	
		���룺expression = "&(t,f)"
		�����false
	ʾ�� 4��
		���룺expression = "|(&(t,f,t),!(t))"
		�����false	 
	
	��ʾ��	
		1 <= expression.length <= 20000
		expression[i] �� {'(', ')', '&', '|', '!', 't', 'f', ','} �е��ַ���ɡ�
		expression ����������ʽ��������Ч���ʽ����ʾһ������ֵ��
 */

//1106. �����������ʽ
public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
    	Stack<Character> sta = new Stack<>();
    	List<List<Boolean>> flags = new ArrayList<>();           
       
        for(char it:expression.toCharArray()) {
        	if(it=='!'||it=='&'||it=='|') {
        		sta.push(it);
        	}else if(it=='(') {
        		flags.add(new ArrayList<Boolean>());
        	}else if(it=='t') {
        		flags.get(flags.size()-1).add(true);
        	}else if(it=='f') {
        		flags.get(flags.size()-1).add(false);
        	}else if(it==')') {
        		List<Boolean> tem = flags.remove(flags.size()-1);
        		if(flags.size()==0) {
        			flags.add(new ArrayList<Boolean>());
        		}
        		char exp = sta.pop();
        		boolean curFlag = tem.get(0);
        		if(exp=='&') {
        			for(int i = 1;i<tem.size();i++) {
        				curFlag &= tem.get(i);
        			}
        		}else if(exp=='|') {
        			for(int i = 1;i<tem.size();i++) {
        				curFlag |= tem.get(i);
        			}
        		}else {
        			curFlag =!curFlag;
        		}
        		
        		flags.get(flags.size()-1).add(curFlag);
        	}
        }
        return flags.get(0).get(0);
    }

	
}
