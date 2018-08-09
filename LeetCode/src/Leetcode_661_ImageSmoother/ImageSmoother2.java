package Leetcode_661_ImageSmoother;

/*
 
	���������Ķ�ά���� M ��ʾһ��ͼƬ�ĻҶȡ�����Ҫ���һ��ƽ��������ÿһ����Ԫ�ĻҶȳ�Ϊƽ���Ҷ� (��������) ��ƽ���Ҷȵļ�������Χ��8����Ԫ���������ֵ��ƽ���������Χ�ĵ�Ԫ����˸����򾡿��ܶ���������ǡ�

	ʾ�� 1:	
		����:
			[[1,1,1],
			 [1,0,1],
			 [1,1,1]]
		���:
			[[0, 0, 0],
			 [0, 0, 0],
			 [0, 0, 0]]
		����:
			���ڵ� (0,0), (0,2), (2,0), (2,2): ƽ��(3/4) = ƽ��(0.75) = 0
			���ڵ� (0,1), (1,0), (1,2), (2,1): ƽ��(5/6) = ƽ��(0.83333333) = 0
			���ڵ� (1,1): ƽ��(8/9) = ƽ��(0.88888889) = 0
*/
//�������
public class ImageSmoother2 {
	
	public int[][] imageSmoother(int[][] M) {
		// ȡM����
		int row = M.length;
		int col = M[0].length;
		// ������������
		int[][] result = new int[row + 2][col + 2];

		// �������齫M������result����
		for (int i = 1; i < row + 1; i++) {
			for (int j = 1; j < col + 1; j++) {
				result[i][j] = M[i - 1][j - 1];
			}
		}

		
		// ����ֵ����M����,�������ֵ
		for (int i = 1; i < row + 1; i++) {
			for (int j = 1; j < col + 1; j++) {
				M[i - 1][j - 1] = result[i - 1][j - 1] + result[i - 1][j] + result[i - 1][j + 1] + result[i][j - 1]
						+ result[i][j] + result[i][j + 1] + result[i + 1][j - 1] + result[i + 1][j]
						+ result[i + 1][j + 1];
				
				// �ж��Ƿ��������
				if (((i == 1) & (j == 1)) || ((i == 1) & (j == col)) || ((i == row) & (j == 1))
						|| ((i == row) & (j == col))) {
					M[i-1][j-1]=(int)Math.floor(M[i-1][j-1] / 4);
				
				} else if (((i == 1) & (j != 1) & (j != col)) ||((j == 1) & (i != row) & (i != 1))
						|| ((i == row) & (j != col) & (j != 1)) || ((j == col) & (i != 1) & (i != row))) {
					 M[i-1][j-1]=(int)Math.floor(M[i-1][j-1] / 6);
					
				} else {
					 M[i-1][j-1]=(int)Math.floor(M[i-1][j-1] / 9);
					
				}

				

			}
		}
		
		return M;
	}
}
