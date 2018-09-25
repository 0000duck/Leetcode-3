package Leetcode_661_ImageSmoother;

/*
 
	���������Ķ�ά���� M ��ʾһ��ͼƬ�ĻҶȡ�����Ҫ���һ��ƽ��������ÿһ����Ԫ�ĻҶȳ�Ϊƽ���Ҷ� (��������) ��ƽ���Ҷȵļ�������Χ��8����Ԫ����������ֵ��ƽ���������Χ�ĵ�Ԫ����˸����򾡿��ܶ���������ǡ�

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
//�߽�����
//
public class ImageSmoother {

	public int[][] imageSmoother(int[][] M) {

		int row = M.length;// ��ȡM����
		int col = M[0].length;// ��ȡM����
		int[][] res = new int[row][col];//����������
		
		// ��������
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int sum = 0;//���
				int count = 0;//����
				
				//��ͼ�����ͬʱ�жϱ߽�
				//x��0����row-1
				//�ж�i-1�Ƿ��0С��i+1�Ƿ��row-1��				
				for(int x=Math.max(0, i-1);x<=Math.min(row-1, i+1);x++) {
					//y��0����col-1
					//�ж�j-1�Ƿ��0С��j+1�Ƿ��col-1��			
					for(int y = Math.max(0, j-1);y<=Math.min(col-1, j+1);y++) {
						sum+=M[x][y];
						count++;
					}
				}
			
			res[i][j] = (int)Math.floor(sum/count);
			}
		}
		return res;
	}
}