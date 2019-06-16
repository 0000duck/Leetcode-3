package Leetcode_1087_PermutationofLetters;

/*
	������һ��������ַ��� S ����ʾһ�ݵ����б�
	֮������չ����Ϊһ���б�����Ϊ����ַ��� S �д���һ��������ѡ��ĸ��	
		�����е�ÿ����ĸ����ֻ��һ��ѡ�����ڶ����ѡ����ֻ��һ��ѡ���ô����ĸ��ԭ����ʾ��	
		������ڶ��ѡ��ͻ��Ի����Ű�������ʾ��Щѡ�ʹ������������ĸ�ָ����������� "{a,b,c}" ��ʾ ["a", "b", "c"]��	
		���ӣ�"{a,b,c}d{e,f}" ���Ա�ʾ�����б� ["ade", "adf", "bde", "bdf", "cde", "cdf"]��
	
	���㰴�ֵ�˳�򣬷������������ַ�ʽ�γɵĵ��ʡ�	 
	
	ʾ�� 1��	
		���룺"{a,b}c{d,e}f"
		�����["acdf","acef","bcdf","bcef"]
	ʾ�� 2��	
		���룺"abcd"
		�����["abcd"] 
	
	��ʾ��	
		1 <= S.length <= 50
		����Լ�����Ŀ�в�����Ƕ�׵Ļ�����
		��һ�������Ļ����ţ�����������ջ����ţ�֮���������ĸ��������ͬ
 */
import java.util.ArrayList;
import java.util.Collections;

//1087. ��ĸ�л�
public class PermutationofLetters {
	public String[] permute(String S) {
		ArrayList<String> res = new ArrayList<>();
		String temp = "";
		res.add(temp);
		char[] ch = S.toCharArray();
		for (int i = 0; i < S.length(); i++) {
			if (ch[i] == '{') {
				i++;
				String t = "";
				while (ch[i] != '}') {
					t += ch[i++];
				}
				ArrayList<String> res1 = new ArrayList<String>();
				String[] x = t.split(",");
				for (String tem : res) {
					for (String xx : x) {
						res1.add(tem + xx);
					}
				}
				res = res1;
			} else {
				ArrayList<String> res1 = new ArrayList<String>();
				for (String tem : res) {
					res1.add(tem + ch[i]);
				}
				res = res1;
			}
		}
		Collections.sort(res);
		return res.toArray(new String[0]);
	}
}
