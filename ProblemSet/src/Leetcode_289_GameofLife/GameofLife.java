package Leetcode_289_GameofLife;

import java.util.Arrays;

/*
	���ݰٶȰٿƣ�������Ϸ�����Ϊ��������Ӣ����ѧ��Լ�����ζ١�������1970�귢����ϸ���Զ�����
	
	����һ������ m �� n �����ӵ���壬ÿһ�����Ӷ����Կ�����һ��ϸ����
	ÿ��ϸ������һ����ʼ״̬ live��1����Ϊ��ϸ���� �� dead��0����Ϊ��ϸ����
	ÿ��ϸ������˸�����λ�ã�ˮƽ����ֱ���Խ��ߣ���ϸ������ѭ�����������涨�ɣ�
	
	�����ϸ����Χ�˸�λ�õĻ�ϸ�����������������λ�û�ϸ��������
	�����ϸ����Χ�˸�λ����������������ϸ�������λ�û�ϸ����Ȼ��
	�����ϸ����Χ�˸�λ���г���������ϸ�������λ�û�ϸ��������
	�����ϸ����Χ������������ϸ�������λ����ϸ�����
	
	���ݵ�ǰ״̬��дһ�����������������ϸ������һ����һ�θ��º�ģ�״̬����һ��״̬��ͨ������������ͬʱӦ���ڵ�ǰ״̬�µ�ÿ��ϸ�����γɵģ�����ϸ���ĳ�����������ͬʱ�����ġ�
	
	ʾ��:
		����: 
			[
			  [0,1,0],
			  [0,0,1],
			  [1,1,1],
			  [0,0,0]
			]
		���: 
			[
			  [0,0,0],
			  [1,0,1],
			  [0,1,1],
			  [0,1,0]
			]
		
	����:
		�����ʹ��ԭ���㷨�����������ע�⣬��������и�����Ҫͬʱ�����£��㲻���ȸ���ĳЩ���ӣ�Ȼ��ʹ�����ǵĸ��º��ֵ�ٸ����������ӡ�
		�����У�����ʹ�ö�ά��������ʾ��塣ԭ���ϣ���������޵ģ�������ϸ����ռ�����߽�ʱ��������⡣�㽫��ν����Щ���⣿
*/
public class GameofLife {
	public static void main(String[] args) {
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		new GameofLife().gameOfLife2(board);
	}

	// 289.������Ϸ
	public void gameOfLife2(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					// ��ϸ��
					int around = countAccount(i, j, board);
					if (around == 3) {
						board[i][j] = -1;
					}
				} else if (board[i][j] == 1) {
					// ��ϸ��
					int around = countAccount(i, j, board);
					if (around < 2 || around > 3) {
						// �����
						board[i][j] = 2;
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == -1) {
					board[i][j] = 1;
				} else if (board[i][j] == 2) {
					board[i][j] = 0;
				}
			}
		}
	}

	public int countAccount(int i, int j, int[][] board) {
		int[][] dxy = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		int count = 0;
		for (int m = 0; m < dxy.length; m++) {
			int dx = i + dxy[m][0];
			int dy = j + dxy[m][1];
			if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length) {
				if (board[dx][dy] == 1||board[dx][dy] == 2) {
					count++;
				}
			}

		}
		return count;
	}

}
