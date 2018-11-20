package Leetcode_476_NumberComplement;

import java.util.Arrays;

/*
	����һ����������������Ĳ����������ǶԸ����Ķ����Ʊ�ʾȡ����
	
	ע��:	
	
		������������֤��32λ�����������ķ�Χ�ڡ�
		����Լٶ���������������ǰ����λ��
	
	ʾ�� 1:	
		����: 5
		���: 2
		����: 5�Ķ����Ʊ�ʾΪ101��û��ǰ����λ�����䲹��Ϊ010����������Ҫ���2��
	
	ʾ�� 2:	
		����: 1
		���: 0
		����: 1�Ķ����Ʊ�ʾΪ1��û��ǰ����λ�����䲹��Ϊ0����������Ҫ���0��
 */
public class NumberComplement {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		NumberComplement nc = new NumberComplement();
		nc.findComplement(5);
	}

	// 476. ���ֵĲ���
	public int findComplement(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			if (num % 2 == 1) {
				sb.append(0);
			} else {
				sb.append(1);
			}
			num /= 2;
		}
		char[] reschar = sb.reverse().toString().toCharArray();
		int result = 0;
		for (int i = 0; i < reschar.length; i++) {
			result = result * 2 + reschar[i] - '0';
		}
		return result;
	}

}
