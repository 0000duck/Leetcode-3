package Leetcode_64_MinimumPathSum;
/*
	����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��	
	˵����ÿ��ֻ�����»��������ƶ�һ����
	
	ʾ��:	
		����:
			[
			  [1,3,1],
			  [1,5,1],
			  [4,2,1]
			]
		���: 7
	����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��
*/
public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//64. ��С·����
    public int minPathSum(int[][] grid) {  
    	//�վ���
    	if(grid==null||grid[0]==null||grid.length=0||grid[0].length==0) {
    		return 0;
    	}
        //����һ����Сֵ
    	int minpath=0;
    	//�к���
    	int m = grid.length;
    	int n = grid[0].length;
    
    	//1*1�ľ���
    	if((m==1)&(n==1)) {
    		return grid[m-1][n-1];
    	}
    	//���µ�һ��
    	for(int j = 1;j<n;j++) {
    		grid[0][j]
    	}
    	//���µ�һ��
    	
    }

}
