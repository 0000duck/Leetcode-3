package Leetcode_695_MaxAreaofIsland;
/*
	����һ��������һЩ 0 �� 1�ķǿն�ά���� grid , һ�� ���� �����ĸ����� (ˮƽ��ֱ) �� 1 (��������) ���ɵ���ϡ�
	����Լ����ά������ĸ���Ե����ˮ��Χ�š�
	
	�ҵ������Ķ�ά���������ĵ��������(���û�е��죬�򷵻����Ϊ0��)
	
	ʾ�� 1:	
		[[0,0,1,0,0,0,0,1,0,0,0,0,0],
		 [0,0,0,0,0,0,0,1,1,1,0,0,0],
		 [0,1,1,0,1,0,0,0,0,0,0,0,0],
		 [0,1,0,0,1,1,0,0,1,0,1,0,0],
		 [0,1,0,0,1,1,0,0,1,1,1,0,0],
		 [0,0,0,0,0,0,0,0,0,0,1,0,0],
		 [0,0,0,0,0,0,0,1,1,1,0,0,0],
		 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
		 
		�������������������Ӧ���� 6��ע��𰸲�Ӧ����11����Ϊ����ֻ�ܰ���ˮƽ��ֱ���ĸ�����ġ�1����
	
	ʾ�� 2:	
		[[0,0,0,0,0,0,0,0]]
		����������������ľ���, ���� 0��
	
	ע��: �����ľ���grid �ĳ��ȺͿ�ȶ������� 50��
*/
public class MaxAreaofIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxAreaofIsland mai = new MaxAreaofIsland();
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(mai.maxAreaOfIsland(grid));
	}
	//695. �����������
    public int maxAreaOfIsland(int[][] grid) {
        int max = deepSearch(grid,0,0);
        for(int i =0;i<grid.length;i++) {
        	for(int j = 0;j<grid[0].length;j++) {
        		if(grid[i][j]==1) {
        			max = Math.max(max, deepSearch(grid,i,j));
        		}        		
        	}
        }
        return max;
    }
    //�������
    public int deepSearch(int[][] grid,int i,int j) {
    	//
    	if((i>=0)&&(i<grid.length)&&(j>=0)&&(j<grid[0].length)&&(grid[i][j]==1)) {
    		//���
    		grid[i][j]=0;
    		//��������
    		return 1+deepSearch(grid,i,j-1)+deepSearch(grid,i,j+1)+deepSearch(grid,i-1,j)+deepSearch(grid,i+1,j);
    	}else {
    		return 0;
    	}
    }

}
