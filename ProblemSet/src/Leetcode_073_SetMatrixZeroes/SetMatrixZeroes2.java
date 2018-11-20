package Leetcode_073_SetMatrixZeroes;



public class SetMatrixZeroes2 {

	public static void main(String[] args) {
		
	}	
	//73. ��������
	//O(M)+O(N)
	public void setZeroes(int[][] matrix) {
		//��ȡ��
		int m = matrix.length;
		//��ȡ��
		int n = matrix[0].length;
		//������־������
		boolean[] rowflag =new boolean[m];
		//������־lie����
		boolean[] colflag =new boolean[n];
		//��������
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(matrix[i][j]==0) {
					rowflag[i] = true;
					colflag[j] = true;
				}
			}
		}
		//�����б�־λ
		for(int i = 0;i<m;i++) {
			if(rowflag[i]) {
				//����������
				for(int j = 0;j<n;j++) {
					matrix[i][j]=0;
				}
			}
		}
		//�����б�־λ
		for(int j = 0;j<n;j++) {
			if(colflag[j]) {
				//����������
				for(int i = 0;i<m;i++) {
					matrix[i][j]=0;
				}
			}
		}
	}

}
