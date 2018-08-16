package Leetcode_887_ProjectionAreaof3DShapes;

/*
	�� N * N �������У����Ƿ�����һЩ�� x��y��z �������� 1 * 1 * 1 �����塣	
	ÿ��ֵ v = grid[i][j] ��ʾ v ������������ڵ�Ԫ�� (i, j) �ϡ�	
	���ڣ����ǲ鿴��Щ�������� xy��yz �� zx ƽ���ϵ�ͶӰ��	
	ͶӰ����Ӱ�ӣ�����ά����ӳ�䵽һ����άƽ���ϡ�	
	������Ӷ�����ǰ��Ͳ��濴������ʱ�����ǻῴ����Ӱ�ӡ���	
	������������ͶӰ���������
		
	ʾ�� 1��
		���룺[[2]]
		�����5
	ʾ�� 2��
		���룺[[1,2],[3,4]]
		�����17
		���ͣ�
		�����и����������������ƽ���ϵ�����ͶӰ(����Ӱ���֡�)��	
	ʾ�� 3��	
		���룺[[1,0],[0,2]]
		�����8
	ʾ�� 4��	
		���룺[[1,1,1],[1,0,1],[1,1,1]]
		�����14
	ʾ�� 5��	
		���룺[[2,2,2],[2,1,2],[2,2,2]]
		�����21	
	��ʾ��	
		1 <= grid.length = grid[0].length <= 50
		0 <= grid[i][j] <= 50
*/
public class ProjectionAreaof3DShapes {
	public int projectionArea(int[][] grid) {
		int areasum = 0;
		// ��ȡ��ά�������
		int col = grid.length;
		// ��ȡ��ά�������
		int row = grid[0].length;
		if((col==0) |(row==0)){
			return 0;
		}
		
		// xy���ֵ
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (grid[i][j] != 0) {
					areasum++;
				}
			}
		}
		System.out.println(areasum);
		// yz���ֵ

		for (int j = 0; j < row; j++) {
			int temp = grid[0][j];
			for (int i = 1; i < col; i++) {
				if (grid[i][j] > temp) {
					temp = grid[i][j];
				}
				
			}
			areasum += temp;
		}
		System.out.println(areasum);
		// xz���ֵ
		
		for (int i = 0; i < col; i++) {
			int temp = grid[i][0];
			for (int j = 1; j < row; j++) {
				if (grid[i][j] > temp) {
					temp = grid[i][j];
				}
				
			}
			areasum += temp;
		}
		System.out.println(areasum);
		return areasum;
	}
}
