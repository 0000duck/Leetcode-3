package Leetcode_443_StringCompression;

/*
	����һ���ַ���ʹ��ԭ���㷨����ѹ����
	ѹ����ĳ��ȱ���ʼ��С�ڻ����ԭ���鳤�ȡ�
	�����ÿ��Ԫ��Ӧ���ǳ���Ϊ1 ���ַ������� int �������ͣ���
	
	�����ԭ���޸���������󣬷���������³��ȡ�
	
	���ף�
		���ܷ��ʹ��O(1) �ռ������⣿
	
	ʾ�� 1��
		���룺
			["a","a","b","b","c","c","c"]
		�����
			����6�����������ǰ6���ַ�Ӧ���ǣ�["a","2","b","2","c","3"]
	˵����
		"aa"��"a2"�����"bb"��"b2"�����"ccc"��"c3"�����
	
	ʾ�� 2��
		���룺
			["a"]
		�����
			����1�����������ǰ1���ַ�Ӧ���ǣ�["a"]
	˵����
		û���κ��ַ������������
	
	ʾ�� 3��	
		���룺
			["a","b","b","b","b","b","b","b","b","b","b","b","b"]	
		�����
			����4�����������ǰ4���ַ�Ӧ���ǣ�["a","b","1","2"]��	
	˵����
		�����ַ�"a"���ظ������Բ��ᱻѹ����"bbbbbbbbbbbb"����b12�������
		ע��ÿ�������������ж������Լ���λ�á�
	ע�⣺	
		�����ַ�����һ��ASCIIֵ��[35, 126]�����ڡ�
		1 <= len(chars) <= 1000��
*/
public class StringCompression {

	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		char[] chars = String.valueOf("aabbccc").toCharArray();
		int length = sc.compress(chars);		
		System.out.println(String.copyValueOf(chars));
		System.out.println(length);
	}

	// 443.ѹ���ַ���
	public int compress(char[] chars) {
		//˫ָ�룬index��ǰ��i�ں�
		//indexΪ�������ָ��,i��ԭ�����ָ��
		int index = 0;
		//����С��2�����س���
		if(chars.length<2) {
			return chars.length;
		}
		//����ԭ����
		for(int i = 0;i<chars.length;) {
			//���ַ��ƴ�
			int count = 1;
			//�����鸲��ԭ����
			chars[index++] = chars[i++];
			//�ж��Ƿ��ظ�
			while((i<chars.length)&&(chars[i]==chars[i-1])) {
				//���i-1��i��ȣ��ƴ�
				count++;
				//ԭ����ָ�����
				i++;
			}
			//���ֳ���1����Ӵ���
			if(count>1) {
				//�����������ַ�������
				char[] chs = String.valueOf(count).toCharArray();
				for(int j = 0;j<chs.length;j++) {
					//�������鲢����
					chars[index++] = chs[j];
				}
			}			
		}
		//���������鳤��
		return index;
	}

}
