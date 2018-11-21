package Leetcode_405_ConvertaNumbertoHexadecimal;

/*
	����һ����������дһ���㷨�������ת��Ϊʮ�������������ڸ�����������ͨ��ʹ�� �������� ������
	
	ע��:	
		ʮ��������������ĸ(a-f)��������Сд��
		ʮ�������ַ����в��ܰ��������ǰ���㡣���Ҫת������Ϊ0����ô�Ե����ַ�'0'����ʾ���������������ʮ�������ַ����еĵ�һ���ַ���������0�ַ��� 
		��������ȷ����32λ�з���������Χ�ڡ�
		����ʹ���κ��ɿ��ṩ�Ľ�����ֱ��ת�����ʽ��Ϊʮ�����Ƶķ�����
		
	ʾ�� 1��	
		����:
			26	
		���:
			"1a"
	
	ʾ�� 2��	
		����:
			-1	
		���:
			"ffffffff"
 */
public class ConvertaNumbertoHexadecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 405. ����ת��Ϊʮ��������
	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}

		StringBuilder resultBuilder = new StringBuilder();
		int hex;
		while (num != 0) {
			// ȡ��num�ĺ���λ��hex
			hex = num & 0x0000000f;
			if (hex < 10) {
				// 10���²�����builder֮ǰ
				resultBuilder.insert(0, (char) (hex + '0'));
			} else {
				resultBuilder.insert(0, (char) (hex - 10 + 'a'));
			}
			// �޷�������4λ
			num >>>= 4;
		}

		return resultBuilder.toString();
	}

}
