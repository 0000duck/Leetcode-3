package UsualMethod;
//�������
public class matrixOutput {
	//һλ���������Array.toString(arr);
	public void ArrayOutput(int[] grid) {
		for(int i = 0;i<grid.length;i++) {
			if(i!=grid.length-1) {
				System.out.print(grid[i]+",");
			}else {
				System.out.println(grid[i]);
			}
		}
	}
	
	//��ά�������
	public void ArrayOutput(int[][] grid) {
		// ��ȡgrid���к���
		int row = grid.length;
		int col = grid[0].length;
		// �������
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j != col - 1) {
					System.out.print(grid[i][j] + ",");
				}else {
					System.out.println(grid[i][j]);
				}

			}
		}
	}
}
