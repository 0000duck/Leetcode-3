package Leetcode_073_SetMatrixZeroes;

import UsualMethod.matrixOutput;

public class SetMatrixZeroes3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetMatrixZeroes3 smz3 = new SetMatrixZeroes3();
		matrixOutput mo = new matrixOutput();
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		System.out.println("����ǰ��");
		mo.ArrayOutput(matrix);
		smz3.setZeroes(matrix);
		System.out.println("�����");
		mo.ArrayOutput(matrix);
	}
	//73. ��������
	//�����ռ�
	public void setZeroes(int[][] matrix) {
		//��ȡ�к���
		int row = matrix.length;
		int col = matrix[0].length;
		//�жϵ�һ���Ƿ�����		
		boolean rowflag = false;
		for(int j = 0;j<col;j++) {
			if(matrix[0][j]==0) {
				rowflag = true;
				break;
			}
		}
		//������һ���Ƿ�����
		boolean colflag = false;
		for(int i = 0;i<row;i++) {
			if(matrix[i][0]==0) {
				colflag = true;
				break;
			}
		}
		//��i=1,j=1��0������оͶ�Ӧ�����к�������Ϊ0
		for(int i = 1;i<row;i++) {
			for(int j = 1;j<col;j++) {
				if(matrix[i][j]==0) {
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		//����Ӧ���к�������
		//���б�����������
		for(int j=1;j<col;j++) {
			if(matrix[0][j]==0) {
				for(int i=0;i<row;i++) {
					matrix[i][j]=0;
				}
			}
		}
		//���б�����������
		for(int i=1;i<row;i++) {
			if(matrix[i][0]==0) {
				for(int j=0;j<col;j++) {
					matrix[i][j]=0;
				}
			}
		}
		//�ж�����
		if(rowflag) {
			for(int j =0;j<col;j++) {
				matrix[0][j]=0;
			}
		}
		//�ж�����
		if(colflag) {
			for(int i =0;i<row;i++) {
				matrix[i][0]=0;
			}
		}
		
	}

}
