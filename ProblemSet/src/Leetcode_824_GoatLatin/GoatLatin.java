package Leetcode_824_GoatLatin;

/*
	����һ���ɿո�ָ�ʵľ��� S��ÿ������ֻ������д��Сд��ĸ��
	����Ҫ������ת��Ϊ ��Goat Latin����һ�������� �������� - Pig Latin ���鹹���ԣ���
	
	ɽ�������ĵĹ������£�
		���������Ԫ����ͷ��a, e, i, o, u�����ڵ��ʺ����"ma"��
		���磬����"apple"��Ϊ"applema"��
		
		��������Ը�����ĸ��ͷ������Ԫ����ĸ�����Ƴ���һ���ַ��������ŵ�ĩβ��֮�������"ma"��
		���磬����"goat"��Ϊ"oatgma"��
		
		���ݵ����ھ����е��������ڵ�����������������ͬ��������ĸ'a'��������1��ʼ��
		���磬�ڵ�һ�����ʺ����"a"���ڵڶ������ʺ����"aa"���Դ����ơ�
		���ؽ� S ת��Ϊɽ�������ĺ�ľ��ӡ�
	
	ʾ�� 1:
		����: "I speak Goat Latin"
		���: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
	ʾ�� 2:
		����: "The quick brown fox jumped over the lazy dog"
		���: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
*/
public class GoatLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoatLatin gl = new GoatLatin();
		String s = "I speak Goat Latin";
		System.out.println(s);
		System.out.println("Imaa peaksmaaa oatGmaaaa atinLmaaaaa");
		System.out.println(gl.toGoatLatin(s));

	}

	// 824. ɽ��������
	public String toGoatLatin(String S) {
		// ���������ж�
		StringBuffer buffer = new StringBuffer(S);
		StringBuffer result = new StringBuffer();
		// ��ȡ���ʵĸ���
		int count = 0;
		while (buffer.length() != 0) {
			// �ո�ָ�ʣ�index�ո��λ��
			int index = buffer.indexOf(" ");
			// ���ʵĸ���
			count++;
			// ��ȡ��һ������
			StringBuffer sb;
			if (index == -1) {
				sb = new StringBuffer(buffer.toString());
				buffer.delete(0, buffer.length());
			} else {
				sb = new StringBuffer(buffer.subSequence(0, index));
				buffer.delete(0, index + 1);
			}
			result.append(wordChange(sb, count));
		}

		return (result.toString().trim());

	}

	// �����޸�
	public StringBuffer wordChange(StringBuffer sb, int count) {
		StringBuffer result = new StringBuffer();
		// �ж��Ƿ�����Ԫ����ͷ
		char temp = sb.charAt(0);
		if ((temp != 'a') & (temp != 'A') & (temp != 'E') & (temp != 'e') & (temp != 'I') & (temp != 'i')
				& (temp != 'O') & (temp != 'o') & (temp != 'u') & (temp != 'U')) {
			sb.deleteCharAt(0);
			sb.append(temp);
		}

		result.append(sb).append("ma");
		for (int i = 0; i < count; i++) {
			result.append("a");
			if (i == count - 1) {
				result.append(" ");
			}
		}
		return result;
	}

}
