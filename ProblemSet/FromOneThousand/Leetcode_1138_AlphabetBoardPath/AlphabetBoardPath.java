package Leetcode_1138_AlphabetBoardPath;

/*
	���Ǵ�һ����ĸ���ϵ�λ�� (0, 0) �������������Ӧ���ַ�Ϊ board[0][0]��
	�ڱ������ĸ��Ϊboard = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
	���ǿ��԰������ָ������ж���
		���������ڣ�'U' ��ζ�Ž����ǵ�λ������һ�У�
		���������ڣ�'D' ��ζ�Ž����ǵ�λ������һ�У�
		���������ڣ�'L' ��ζ�Ž����ǵ�λ������һ�У�
		���������ڣ�'R' ��ζ�Ž����ǵ�λ������һ�У�
		'!' ��������ǵ�ǰλ�� (r, c) ���ַ� board[r][c] ��ӵ����С�
		����ָ�����У�����С���ж������ô𰸺�Ŀ�� target ��ͬ������Է����κδ��Ŀ���·����
	
	ʾ�� 1��
		���룺target = "leet"
		�����"DDR!UURRR!!DDD!"
	ʾ�� 2��
		���룺target = "code"
		�����"RR!DDRR!UUL!R!"
	
	��ʾ��
		1 <= target.length <= 100
		target ������СдӢ����ĸ��
 */

//1138.��ĸ���ϵ�·��
public class AlphabetBoardPath {
	public String alphabetBoardPath(String target) {
		int x = 0;
		int y = 0;
		StringBuilder res = new StringBuilder();
		;
		for (char ch : target.toCharArray()) {
			int index = ch - 'a';
			int nx = index / 5;
			int ny = index % 5;
			while (x < nx) {
				res.append("U");
				x++;
			}
			while (y > ny) {
				res.append("L");
				y--;
			}
			while (x > nx) {
				res.append("D");
				x--;
			}
			while (y < ny) {
				res.append("R");
				y++;
			}
			res.append("!");
		}
		return res.toString();
	}
}
