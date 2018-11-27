package Leetcode_771_JewelsandStones;

/*
	�����ַ��� J ����ʯͷ�б�ʯ�����ͣ����ַ��� S������ӵ�е�ʯͷ�� 
	S ��ÿ���ַ�������һ����ӵ�е�ʯͷ�����ͣ�����֪����ӵ�е�ʯͷ���ж����Ǳ�ʯ��	
	J �е���ĸ���ظ���J �� S�е������ַ�������ĸ����ĸ���ִ�Сд�����"a"��"A"�ǲ�ͬ���͵�ʯͷ��
	
	ʾ�� 1:	
		����: J = "aA", S = "aAAbbbb"
		���: 3
	
	ʾ�� 2:	
		����: J = "z", S = "ZZ"
		���: 0
	
	ע��:	
		S �� J ��ຬ��50����ĸ��
		J �е��ַ����ظ���
 */
public class JewelsandStones {
	public static void main(String[] args) {
		JewelsandStones js = new JewelsandStones();

	}

	// 771. ��ʯ��ʯͷ
	public int numJewelsInStones(String J, String S) {
		if ((J.length() == 0) || (J == null)) {
			return 0;
		}
		char[] jewels = J.toCharArray();
		int count = 0;
		for (int i = 0; i < jewels.length; i++) {
			for (int j = 0; j < S.length(); j++) {
				if (jewels[i] == S.charAt(j)) {
					count++;
				}
			}
		}
		return count;
	}

	// 9ms
	public int numJewelsInStones2(String J, String S) {
		// all ASCII letters from A to z represented as a boolean array
		boolean[] JArray = new boolean[58];
		//���鱦�Ž���ĸ��
		for (int i = 0; i < J.length(); i++) {
			JArray[J.charAt(i) - 'A'] = true;
		}
		int counter = 0;
		//����ʯͷ
		for (int i = 0; i < S.length(); i++) {
			//������鱦,������++��������ǣ�����
			counter = (JArray[S.charAt(i) - 'A']) ? ++counter : counter;
		}
		return counter;
	}
}
