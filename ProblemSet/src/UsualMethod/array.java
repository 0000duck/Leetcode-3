package UsualMethod;

/**
 * ����һ���������йصĲ���������
 * 
 * @author Andrew
 *
 */
public class array {
	private array() {

	}

	/**
	 * ���������е�������
	 * 
	 * @param nums ������������
	 * @param i    Ҫ����������1
	 * @param j    Ҫ����������2
	 */
	public static void exchange(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	//һλ���������Array.toString(arr);
	
	/**
	 *  ��ά�������
	 * @param grid Ҫ����Ķ�ά����
	 */
	public static void ArrayOutput(int[][] grid) {
		// ��ȡgrid���к���
		int row = grid.length;
		int col = grid[0].length;
		// �������
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j != col - 1) {
					System.out.print(grid[i][j] + ",");
				} else {
					System.out.println(grid[i][j]);
				}

			}
		}
	}
}
