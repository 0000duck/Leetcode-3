package Leetcode_566_ReshapeTheMatrix;

/*
	��MATLAB�У���һ���ǳ����õĺ��� reshape�������Խ�һ����������Ϊ��һ����С��ͬ���¾��󣬵�������ԭʼ���ݡ�
	����һ���ɶ�ά�����ʾ�ľ����Լ�����������r��c���ֱ��ʾ��Ҫ���ع��ľ����������������
	�ع���ľ�����Ҫ��ԭʼ���������Ԫ������ͬ���б���˳����䡣
	������и���������reshape�����ǿ����Һ���ģ�������µ����ܾ��󣻷������ԭʼ����

	ʾ�� 1:
		����: 
		nums = 
			[[1,2],
 			 [3,4]]
		r = 1, c = 4
		���: 
			[[1,2,3,4]]
		����:
			�б���nums�Ľ���� [1,2,3,4]���µľ����� 1 * 4 ����, ��֮ǰ��Ԫ��ֵһ��һ������¾���

	ʾ�� 2:
		����: 
		nums = 
			[[1,2],
			 [3,4]]
		r = 2, c = 4
		���: 
			[[1,2],
			 [3,4]]
		����:
			û�а취�� 2 * 2 ����ת��Ϊ 2 * 4 ���� �������ԭ����
		ע�⣺
			��������Ŀ�͸߷�Χ�� [1, 100]��
			������ r �� c ����������
*/
public class ReshapeTheMatrix {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		// ���������ά����
		int[][] result = new int[r][c];
		// ��ȡnums[]����
		int row = nums.length;
		// ��ȡnums[]����
		int col = nums[0].length;
		// result����
		int m = 0;
		// result����
		int n = 0;
		//���Ԫ�ز�ͬ�򷵻�ԭ����
		if (r * c != row * col) {
			return nums;
		} else {
			//����ԭ����
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					//�����������������������
					if (n >= c) {
						m++;
						n = 0;
						result[m][n] = nums[i][j];
						n++;
					} else {
						result[m][n] = nums[i][j];
						n++;
					}
				}
			}
		}
		return result;
	}
}
