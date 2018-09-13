package Leetcode_12_IntegertoRoman;

import java.util.HashMap;

/*
	�������ְ������������ַ��� I�� V�� X�� L��C��D �� M��
	
	�ַ�       		   ��ֵ
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
	
	I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
	X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90�� 
	C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
	����һ������������תΪ�������֡�����ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
	
	ʾ�� 1:
		����: 3
		���: "III"
	ʾ�� 2:
		����: 4
		���: "IV"
	ʾ�� 3:
		����: 9
		���: "IX"
	ʾ�� 4:
		����: 58
		���: "LVIII"
	����: C = 100, L = 50, XXX = 30, III = 3.
	ʾ�� 5:
		����: 1994
		���: "MCMXCIV"
	����: M = 1000, CM = 900, XC = 90, IV = 4.
*/
public class IntegertoRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegertoRoman itor = new IntegertoRoman();
		System.out.println(itor.intToRoman(1994));
		System.out.println("MCMXCIV");
	}

	// 12. ����ת��������:152 ms
	public String intToRoman(int num) {
		StringBuffer result = new StringBuffer();
		int index = 0;
		// �����ַ�������
		String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		// ������������
		int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		while (num > 0) {
			if (num >= nums[index]) {
				num -= nums[index];
				result.append(str[index]);
			}else{
				index++;
			}
		}

		return result.toString();
	}

	// 12. ����ת��������:104 ms
//	public String intToRoman(int num) {
//		StringBuilder result = new StringBuilder();		
//		//1000����
//		while(num>=1000) {
//			num -= 1000;
//			result.append("M");
//		}
//		//1000����900����
//		if(num>=900) {
//			num -= 900;
//			result.append("CM");
//		}
//		//900����500����
//		if(num>=500) {
//			num -= 500;
//			result.append("D");
//		}
//		//500����400����
//		if(num>=400) {
//			num-=400;
//			result.append("CD");
//		}
//		//400����100����
//		while(num>=100) {
//			num-=100;
//			result.append("C");
//		}
//		//100����90����
//		if(num>=90) {
//			num-=90;
//			result.append("XC");
//		}
//		//90����50����
//		if(num>=50) {
//			num-=50;
//			result.append("L");		
//		}
//		//50����40����
//		if(num>=40) {
//			num-=40;
//			result.append("XL");		
//		}
//		//40����10����
//		while(num>=10) {
//			num-=10;
//			result.append("X");		
//		}
//		//10����9����
//		if(num>=9) {
//			num-=9;
//			result.append("IX");
//		}
//		//9����5����
//		if(num>=5) {
//			num-=5;
//			result.append("V");
//		}
//		//5����4����
//		if(num>=4) {
//			num-=4;
//			result.append("IV");
//		}
//		//4����1����
//		while(num>=1) {
//			num-=1;
//			result.append("I");
//		}
//		    
//		return result.toString();
//	}

}
