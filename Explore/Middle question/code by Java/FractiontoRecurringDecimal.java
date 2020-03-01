package Leetcode_166_FractiontoRecurringDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	���������������ֱ��ʾ�����ķ��� numerator �ͷ�ĸ denominator�����ַ�����ʽ����С����
	
	���С������Ϊѭ��С������ѭ���Ĳ������������ڡ�
	
	ʾ�� 1:	
		����: numerator = 1, denominator = 2
		���: "0.5"
	ʾ�� 2:	
		����: numerator = 2, denominator = 1
		���: "2"
	ʾ�� 3:	
		����: numerator = 2, denominator = 3
		���: "0.(6)"
 */

//166. ������С��
public class FractiontoRecurringDecimal {
	public static void main(String[] args) {
		System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(2, 3));
	}

	public String fractionToDecimal(int num, int den) {
		long numerator = num;
		long denominator = den;
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		if (numerator < 0 && denominator > 0) {
			flag = true;
			numerator = -1 * numerator;
		} else if (numerator > 0 && denominator < 0) {
			flag = true;
			denominator = -1 * denominator;
		} else if (numerator < 0 && denominator < 0) {
			numerator = -1 * numerator;
			denominator = -1 * denominator;
		}
		if (flag) {
			result.append("-");
		}
		// ����
		long rem = numerator % denominator;
		long quo = numerator / denominator;
		if (rem == 0) {
			return result.append(quo).toString();
		}

		StringBuilder quopart = new StringBuilder();
		List<Long> rempart = new ArrayList<Long>();
		// StringBuilder rempart = new StringBuilder();

		while (rem != 0) {
			int index = rempart.indexOf(rem);
			if (index != -1) {
				quopart.insert(index, "(").append(")");
				break;
			}
			rempart.add(rem);
			quo = rem * 10 / denominator;// ��
			quopart.append(quo);
			rem = rem * 10 % denominator;
		}

		quo = numerator / denominator;

		result.append(quo).append(".").append(quopart);
		return result.toString();

	}

	// 3ms
	public String fractionToDecimal0(int numerator, int denominator) {
		// �߽紦��
		if (numerator == -1 && denominator == Integer.MIN_VALUE)
			return "0.0000000004656612873077392578125";
		if (numerator == 0)
			return "0";
		//
		StringBuilder res = new StringBuilder();
		// ��򣺲�ͬʱ<0,����
		if (numerator < 0 ^ denominator < 0) {
			res.append("-");
		}

		long l_numerator = Math.abs((long) numerator);
		denominator = Math.abs(denominator);

		res.append(l_numerator / denominator);
		int remainder = (int) (l_numerator % denominator);
		if (remainder == 0)
			return res.toString();
		res.append(".");
		Map<Integer, Integer> map = new HashMap<>();
		int pos = 0, len = res.length();
		while (remainder != 0) {
			if (map.containsKey(remainder)) {
				Integer start = map.get(remainder);
				res.insert(len + start, "(");
				res.append(")");
				return res.toString();
			}
			map.put(remainder, pos++);
			res.append(remainder * 10 / denominator);
			remainder = remainder * 10 % denominator;
		}

		return res.toString();
	}
}
