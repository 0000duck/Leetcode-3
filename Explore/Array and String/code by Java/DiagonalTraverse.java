package Leetcode_498_DiagonalTraverse;

/*
	����һ������ M x N ��Ԫ�صľ���M �У�N �У������ԶԽ��߱�����˳�򷵻���������е�����Ԫ�ء�	
	ʾ��:	
		����:
			[
			 [ 1, 2, 3 ],
			 [ 4, 5, 6 ],
			 [ 7, 8, 9 ]
			]	
		���:  
			[1,2,4,7,5,3,6,8,9]

 */
public class DiagonalTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiagonalTraverse dt = new DiagonalTraverse();
		int[][] matrix = {{3},{2}};
		dt.findDiagonalOrder(matrix);
	}

	// 498. �Խ��߱���
	public int[] findDiagonalOrder(int[][] matrix) {
		//null
		if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return new int[]{};
        }
		//1��
        if (matrix.length == 1) {
            return matrix[0];
        }
        //1��
        if (matrix[0].length == 1) {
            int[] result = new int[matrix.length];           
            for ( int i = 0;i<result.length;i++) {
                result[i] = matrix[i][0];
            }
            return result;
        }
        
		// ��
		int m = matrix.length;
		// ��
		int n = matrix[0].length;
		int[] result = new int[m * n];

		int i = 0;
        int j = 0;
        
        int flag = 0;// 0-����    1-����
        int index = 0;//result������

        while (i != matrix.length && j != matrix[0].length) {
        	//�������߽�
        	result[index] = matrix[i][j];
            // ���ϱ���
            if (flag == 0) {
                // ��������ת�ƣ���ĩ�У�
                if (i == 0 && j != matrix[0].length - 1) {
                    j++;
                    flag = 1;
                } else if (j == matrix[0].length - 1) {
                    // ĩ������ת��
                    i++;
                    flag = 1;
                } else {
                    //��������
                    i--;
                    j++;
                }
            } else {
                // ��������ת�ƣ���ĩ�У�
                if (j == 0 && i != matrix.length - 1) {
                    i++;
                    flag = 0;
                } else if (i == matrix.length - 1) {
                	//δ��
                    j++;
                    flag = 0;
                } else {
                	//��������
                    i++;
                    j--;
                }
            }
            index++;
        }
        return result;
	}

}
