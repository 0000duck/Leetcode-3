package Leetcode_013_RomantoInteger;

import java.util.HashMap;

/*
	�������ְ������������ַ���I�� V�� X�� L��C��D �� M��
	
	�ַ�          ��ֵ
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	���磬 
	�������� 2 д�� II ����Ϊ�������е� 1��
	     12 д�� XII ����Ϊ X + II �� 
	     27 д��  XXVII, ��Ϊ XX + V + II ��
	
	ͨ������£�����������С�������ڴ�����ֵ��ұߡ�
	��Ҳ�������������� 4 ��д�� IIII������ IV��
	���� 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��
	
	ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
	
	I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��//IV IX
	X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90�� //XL XC	
	C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��//CD CM
	
	����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
	
	ʾ�� 1:
		����: "III"
		���: 3
	ʾ�� 2:
		����: "IV"
		���: 4
	ʾ�� 3:
		����: "IX"
		���: 9
	ʾ�� 4:
		����: "LVIII"
		���: 58
	����: C = 100, L = 50, XXX = 30, III = 3.
	ʾ�� 5:
		����: "MCMXCIV"
		���: 1994
	����: M = 1000, CM = 900, XC = 90, IV = 4.
*/
public class RomantoInteger {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("M = 1000, CM = 900, XC = 90, IV = 4");
		System.out.println(romanToInt("MCMXCIV"));
		
	}
	//13.��������ת����
	public static int romanToInt(String s) {
		//hashmap���ݽṹ
		 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 map.put('I', 1);
	     map.put('V', 5);
	     map.put('X', 10);
	     map.put('L', 50);
	     map.put('C', 100);
	     map.put('D', 500);
	     map.put('M', 1000);
	     char[] chs = s.toCharArray();
	     int length =chs.length;
		//���
		int result = map.get(chs[length-1]);
		for(int i =length-2;i>=0;i--) {
			//ǰ�����
			int a = map.get(chs[i]);
			//�������
			int b = map.get(chs[i+1]);
			//ǰ������Ⱥ������С��Ϊ-
			if(a<b) {
				result -= a;
			}else {
				result += a;
			}
		}
		return result;
	}
	/*
	public static int romanToInt(String s) {
		//���
		int result = 0;
        //���ַ���ת������
		char[] chs = s.toCharArray();
		for(int i = 0;i<chs.length;i++) {
			if(i<chs.length-1) {
				if(chs[i]=='I') {
					if(chs[i+1]=='V') {
						result += 4;
						i++;
					}else if(chs[i+1]=='X') {
						result += 9;
						i++;
					}else {
						result += 1;
					}
				}else if(chs[i]=='V') {
					result += 5;
				}else if(chs[i]=='X') {
					if(chs[i+1]=='L') {
						result += 40;
						i++;
					}else if(chs[i+1]=='C') {
						result += 90;
						i++;
					}else {
						result += 10;					
					}
				}else if(chs[i]=='L') {
					result += 50;
				}else if(chs[i]=='C') {
					if(chs[i+1]=='D') {
						result += 400;
						i++;
					}else if(chs[i+1]=='M') {
						result += 900;
						i++;
					}else {
						result += 100;					
					}
				}else if(chs[i]=='D') {
					result += 500;
				}else{
					result += 1000;
				}
			}else {
				if(chs[i]=='I') {					
						result += 1;
				}else if(chs[i]=='V') {
					result += 5;
				}else if(chs[i]=='X') {					
					result += 10;					
				}else if(chs[i]=='L') {
					result += 50;
				}else if(chs[i]=='C') {					
					result += 100;				
				}else if(chs[i]=='D') {
					result += 500;
				}else{
					result += 5000;
				}
			}
			
		}
		return result;		
    }
	*/
}
