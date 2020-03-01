package Leetcode_054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/*
	����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�
	
	ʾ�� 1:	
		����:
			[
			 [ 1, 2, 3 ],
			 [ 4, 5, 6 ],
			 [ 7, 8, 9 ]
			]
		���: [1,2,3,6,9,8,7,4,5]
	
	ʾ�� 2:	
		����:
			[
			  [1, 2, 3, 4],
			  [5, 6, 7, 8],
			  [9,10,11,12]
			]
		���: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//54. ��������
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if((matrix.length==0)||(matrix==null)) {
        	return list;
        }
        //��
        int row = matrix.length;
        //��
        int col = matrix[0].length;
        //��
        int rowbegin = 0;
        int rowend = row-1;
        //��
        int colbegin = 0;
        int colend = col-1;
        while(list.size()<row*col) {
        	//����
        	for(int i = colbegin;i<=colend&&list.size()<row*col;i++) {
        		list.add(matrix[rowbegin][i]);
        	}
        	rowbegin++;
        	//����
        	for(int i = rowbegin;i<=rowend&&list.size()<row*col;i++) {
        		list.add(matrix[i][colend]);
        	}
        	colend--;
        	//����
        	for(int i = colend;i>=colbegin&&list.size()<row*col;i--) {
        		list.add(matrix[rowend][i]);
        	}
        	rowend--;
        	//����
        	for(int i = rowend;i>=rowbegin&&list.size()<row*col;i--) {
        		list.add(matrix[i][colbegin]);
        	}
        	colbegin++;
        }
        return list;
    }

}
