package Leetcode_079_WordSearch;

/*
	����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
	
	���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
	
	ʾ��:
		board =
			[
			  ['A','B','C','E'],
			  ['S','F','C','S'],
			  ['A','D','E','E']
			]
		���� word = "ABCCED", ���� true.
		���� word = "SEE", ���� true.
		���� word = "ABCB", ���� false.
 */
//79. ��������
public class WordSearch {
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		new WordSearch().exist(board, "SEE");
	}

	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0) {
			return true;
		}
		int col = board.length;
		int row = board[0].length;
		if (board == null || col == 0 || row == 0) {
			return false;
		}
		boolean[][] used = new boolean[col][row];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					used[i][j] = true;
					if (exist(board, word, used, 1, i, j)) {
						return true;
					} else {
						used[i][j] = false;
					}
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, boolean[][] used, int start, int i2, int j2) {
		if (start == word.length()) {
			return true;
		}
		int[][] step = { { i2 - 1, j2 }, { i2 + 1, j2 }, { i2, j2 - 1 }, { i2, j2 + 1 } };
		for (int[] arr : step) {
			int col = arr[0];
			if (!(col >= 0 && col < board.length)) {
				continue;
			}
			int row = arr[1];
			if (!(row >= 0 && row < board[0].length)) {
				continue;
			}
			if (used[col][row]) {
				continue;
			}
			if (board[col][row] == word.charAt(start)) {
				used[col][row] = true;
				if (exist(board, word, used, start + 1, col, row)) {
					return true;
				}
				used[col][row] = false;
			}
		}

		return false;
	}

	// 8ms
	int m;
	int n;

	public boolean exist0(char[][] board, String word) {
		if (null == board || word == null || word.isEmpty()) {
			return false;
		}

		boolean[][] used = new boolean[board.length][board[0].length];

		m = board.length;
		n = board[0].length;

		char[] charArray = word.toCharArray();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (exist0(board, used, charArray, i, j, 0)) {
					return true;
				}
			}
		}

		return false;

	}

	private boolean exist0(char[][] board, boolean[][] used, char[] charArray, int i, int j, int index) {
		if (index == charArray.length) {
			return true;
		}

		if (i >= m || i < 0) {
			return false;
		}

		if (j >= n || j < 0) {
			return false;
		}

		if (used[i][j] || board[i][j] != charArray[index]) {
			return false;
		}

		used[i][j] = true;
		// up -> right -> down -> left
		boolean found = exist0(board, used, charArray, i - 1, j, index + 1)
				|| exist0(board, used, charArray, i, j + 1, index + 1)
				|| exist0(board, used, charArray, i + 1, j, index + 1)
				|| exist0(board, used, charArray, i, j - 1, index + 1);

		// recover
		if (!found)
			used[i][j] = false;

		return found;
	}
}
