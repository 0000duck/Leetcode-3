package Leetcode_036_ValidSudoku;

import java.util.ArrayList;
import java.util.List;

/*
	�ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
	
	���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
	���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
	���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
	
	ͼƬ��https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
	��ͼ��һ������������Ч��������
	
	�������ֿո��������������֣��հ׸��� '.' ��ʾ��
	
	ʾ�� 1:	
		����:
			[
			  ["5","3",".",".","7",".",".",".","."],
			  ["6",".",".","1","9","5",".",".","."],
			  [".","9","8",".",".",".",".","6","."],
			  ["8",".",".",".","6",".",".",".","3"],
			  ["4",".",".","8",".","3",".",".","1"],
			  ["7",".",".",".","2",".",".",".","6"],
			  [".","6",".",".",".",".","2","8","."],
			  [".",".",".","4","1","9",".",".","5"],
			  [".",".",".",".","8",".",".","7","9"]
			]
		���: true
		
	ʾ�� 2:	
		����:
			[
			  ["8","3",".",".","7",".",".",".","."],
			  ["6",".",".","1","9","5",".",".","."],
			  [".","9","8",".",".",".",".","6","."],
			  ["8",".",".",".","6",".",".",".","3"],
			  ["4",".",".","8",".","3",".",".","1"],
			  ["7",".",".",".","2",".",".",".","6"],
			  [".","6",".",".",".",".","2","8","."],
			  [".",".",".","4","1","9",".",".","5"],
			  [".",".",".",".","8",".",".","7","9"]
			]
		���: false
	����:
		���˵�һ�еĵ�һ�����ִ� 5 ��Ϊ 8 ���⣬�ո����������־��� ʾ��1 ��ͬ��
		������λ�����Ͻǵ� 3x3 ���������� 8 ����, ��������������Ч�ġ�
	˵��:	
		һ����Ч�������������ѱ���䣩��һ���ǿɽ�ġ�
		ֻ��Ҫ�������Ϲ�����֤�Ѿ�����������Ƿ���Ч���ɡ�
		������������ֻ�������� 1-9 ���ַ� '.' ��
		����������Զ�� 9x9 ��ʽ�ġ�
 */
public class ValidSudoku {
	// 36. ��Ч������
	public boolean isValidSudoku(char[][] board) {
		// ��
		List<Character> rowlist;
		for (int i = 0; i < 9; i++) {
			rowlist = new ArrayList<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (rowlist.contains(board[i][j])) {
						return false;
					} else {
						rowlist.add(board[i][j]);
					}
				}
			}
		}
		// ��
		List<Character> collist;
		for (int i = 0; i < 9; i++) {
			collist = new ArrayList<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					if (collist.contains(board[j][i])) {
						return false;
					} else {
						collist.add(board[j][i]);
					}
				}
			}
		}
		// �Ź���
		List<Character> jiugonggelist;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				jiugonggelist = new ArrayList<Character>();
				for (int i = 3 * x + 0; i < 3 * x + 3; i++) {
					for (int j = 3 * y + 0; j < 3 * y + 3; j++) {
						if (board[i][j] != '.') {
							if (jiugonggelist.contains(board[i][j])) {
								return false;
							} else {
								jiugonggelist.add(board[i][j]);
							}
						}
					}
				}
			}
		}
		return true;

	}

	// 14ms
	public boolean isValidSudoku0(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				for (int k = 8; k > j; k--)
					if (board[i][j] == board[i][k])
						return false;
				for (int k = 8; k > i; k--)
					if (board[i][j] == board[k][j])
						return false;
				for (int k = i + 1; k % 3 != 0; k++) {
					for (int h = j / 3 * 3; h <  j / 3 * 3 + 3; h++)
						if (board[i][j] == board[k][h])
							return false;
				}
			}
		}
		return true;
	}
}
