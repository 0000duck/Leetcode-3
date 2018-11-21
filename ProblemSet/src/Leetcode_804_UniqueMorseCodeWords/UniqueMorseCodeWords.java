package Leetcode_804_UniqueMorseCodeWords;

/*
	����Ħ��˹���붨��һ�ֱ�׼���뷽ʽ����ÿ����ĸ��Ӧ��һ����һϵ�е�Ͷ�����ɵ��ַ����� ����: "a" ��Ӧ ".-", "b" ��Ӧ "-...", "c" ��Ӧ "-.-.", �ȵȡ�
	
	Ϊ�˷��㣬����26��Ӣ����ĸ��ӦĦ��˹��������£�	
	[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
	����һ�������б�ÿ�����ʿ���д��ÿ����ĸ��ӦĦ��˹�������ϡ����磬"cab" ����д�� "-.-..--..."��(�� "-.-." + "-..." + ".-"�ַ����Ľ��)�����ǽ�����һ�����ӹ��̳������ʷ��롣
	�������ǿ��Ի�����дʲ�ͬ���ʷ����������
	
	����:
		����: words = ["gin", "zen", "gig", "msg"]
		���: 2
	����: 
		�����ʷ�������:
		"gin" -> "--...-."
		"zen" -> "--...-."
		"gig" -> "--...--."
		"msg" -> "--...--."
	
		���� 2 �ֲ�ͬ����, "--...-." �� "--...--.".
	 
	
	ע��:	
		�����б�words �ĳ��Ȳ��ᳬ�� 100��
		ÿ������ words[i]�ĳ��ȷ�ΧΪ [1, 12]��
		ÿ������ words[i]ֻ����Сд��ĸ��
 */
public class UniqueMorseCodeWords {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		UniqueMorseCodeWords umcw = new UniqueMorseCodeWords();
		String[] words = { "zocd", "gjkl", "hzqk", "hzgq", "gjkl" };
		umcw.uniqueMorseRepresentations(words);
	}

	// 804. ΨһĦ��˹�����
	public int uniqueMorseRepresentations(String[] words) {
		String[] alphabet = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
				"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		String[] result = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < words[i].length(); j++) {
				char temp = words[i].charAt(j);
				sb.append(alphabet[temp - 'a']);
			}
			result[i] = sb.toString();
		}
		int count = 0;
		// �жϲ�ͬ
		String temp = result[0];
		for (int i = 0; i < result.length; i++) {
			if (result[i] != null) {
				temp = result[i];
				count++;
			} else {
				continue;
			}
			int j = i + 1;
			while (j < result.length) {
				if (result[j] == null) {
					j++;
					continue;
				}
				if (result[j].equals(temp)) {
					result[j] = null;
				}
				j++;
			}

		}
		return count;

	}
}
