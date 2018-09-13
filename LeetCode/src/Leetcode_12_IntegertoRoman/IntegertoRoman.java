package Leetcode_12_IntegertoRoman;

import java.util.HashMap;

/*
	�������ְ������������ַ��� I�� V�� X�� L��C��D �� M��
	
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

	}
	//12. ����ת��������
	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "I");//1
		map.put(5, "V");//5
		map.put(10, "X");//10
		map.put(50, "L");//50
		map.put(100, "C");//100
		map.put(500, "D");//500
		map.put(1000, "M");//1000
		map.put(40, "IV");//40
		map.put(90, "IX");//90
		map.put(400, "XL");//400
		map.put(900, "CM");//900
		//1000����
		while(num>=1000) {
			num -= 1000;
			result.append(map.get(1000));
		}
		
		return result.toString();
        
    }
}
