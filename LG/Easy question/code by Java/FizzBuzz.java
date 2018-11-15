package Leetcode_412_FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/*
	дһ����������� 1 �� n ���ֵ��ַ�����ʾ��	
	1. ��� n ��3�ı����������Fizz����	
	2. ��� n ��5�ı����������Buzz����	
	3.��� n ͬʱ��3��5�ı�������� ��FizzBuzz����
	
	ʾ����	
		n = 15,	
		����:
			[
			    "1",
			    "2",
			    "Fizz",
			    "4",
			    "Buzz",
			    "Fizz",
			    "7",
			    "8",
			    "Fizz",
			    "Buzz",
			    "11",
			    "Fizz",
			    "13",
			    "14",
			    "FizzBuzz"
			]
*/
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 412.Fizz Buzz
	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i <= n; i++) {
			if ((i % 3 == 0) && (i % 5 == 0)) {
				list.add("FizzBuzz");				
			}else if (i % 3 == 0) {
				list.add("Fizz");
			}else if (i % 5 == 0) {
				list.add("Buzz");
			}else {
				list.add(i+"");
			}
		}
		return list;
	}

}
