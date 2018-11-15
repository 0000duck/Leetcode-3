package Leetcode_073_SetMatrixZeroes;

import UsualMethod.matrixOutput;

/*
	����һ�� m x n �ľ������һ��Ԫ��Ϊ 0�����������к��е�����Ԫ�ض���Ϊ 0����ʹ��ԭ���㷨��
	
	ʾ�� 1:
		����: 
			[
			  [1,1,1],
			  [1,0,1],
			  [1,1,1]
			]
		���: 
			[
			  [1,0,1],
			  [0,0,0],
			  [1,0,1]
			]
	ʾ�� 2:
		����: 
			[
			  [0,1,2,0],
			  [3,4,5,2],
			  [1,3,1,5]
			]
		���: 
			[
			  [0,0,0,0],
			  [0,4,5,0],
			  [0,3,1,0]
			]
	����:
		һ��ֱ�ӵĽ��������ʹ��  O(mn) �Ķ���ռ䣬���Ⲣ����һ���õĽ��������
		һ���򵥵ĸĽ�������ʹ�� O(m + n) �Ķ���ռ䣬������Ȼ������õĽ��������
		�������һ�������ռ�Ľ��������
*/
public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetMatrixZeroes smz = new SetMatrixZeroes();
		matrixOutput mo = new matrixOutput();
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		System.out.println("����ǰ��");
		mo.ArrayOutput(matrix);
		smz.setZeroes(matrix);
		System.out.println("�����");
		mo.ArrayOutput(matrix);
	}
	//73. ��������
	//��˱��У��ҳ˱���
    public void setZeroes(int[][] matrix) {
        //O(mn)
    	boolean[][] flag = new boolean[matrix.length][matrix[0].length];
    	//�ҵ�0
    	for(int i = 0;i<matrix.length;i++) {
    		for(int j = 0;j<matrix[0].length;j++) {
    			if(matrix[i][j]==0) {
    				flag[i][j] = true;
    			}
    		}
    	}
    	//����
    	for(int i = 0;i<matrix.length;i++) {
    		for(int j = 0;j<matrix[0].length;j++) {
    			if(flag[i][j]) {
    				setZeroes(matrix,i,j);
    			}
    		}
    	}
    }
    
    public void setZeroes(int[][] matrix,int i,int  j) {
    	//����������
    	for(int m = 0;m<matrix[0].length;m++) {
    		matrix[i][m]=0;
    	}
    	//����������
    	for(int n = 0;n<matrix.length;n++) {
    		matrix[n][j]=0;
    	}
    }

}
