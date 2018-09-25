package Leetcode_463_IslandPerimeter;
/*
	����һ������ 0 �� 1 �Ķ�ά�����ͼ������ 1 ��ʾ½�� 0 ��ʾˮ��
	�����еĸ���ˮƽ�ʹ�ֱ�����������Խ��߷�����������
	��������ˮ��ȫ��Χ��������ǡ����һ�����죨����˵��һ��������ʾ½�صĸ���������ɵĵ��죩��
	������û�С������������� ָˮ���ڵ����ڲ��Ҳ��͵�����Χ��ˮ��������
	�����Ǳ߳�Ϊ 1 �������Ρ�����Ϊ�����Σ��ҿ�Ⱥ͸߶Ⱦ������� 100 ��
	�������������ܳ���
	
	ʾ�� :	
		[[0,1,0,0],
		 [1,1,1,0],
		 [0,1,0,0],
		 [1,1,0,0]]
	
	��: 16
	����: �����ܳ�������ͼƬ�е� 16 ����ɫ�ıߣ�
*/
public class IslandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IslandPerimeter ip = new IslandPerimeter();
		int[][] grid = {{1},{0}};
		System.out.println(ip.islandPerimeter(grid));
		
	}
	//463. ������ܳ�
    public int islandPerimeter(int[][] grid) {
    	int perimeter = 0;
        //i,j��Χ�ж��ٿ鵺�죬���ܳ��ͼ�����
    	for(int i = 0;i<grid.length;i++) {
    		for(int j =0;j<grid[0].length;j++) {
    			if(grid[i][j]==1) {
    				perimeter += (4-landCount(grid,i,j));
    			}
    		}
    	}
    	return perimeter;
    }
    //�ж�i,j��Χ�ж��ٿ鵺��
    public int landCount(int[][] grid,int i,int j) {
    	int sum = 0;    	
    	//��
    	if((j>0)&&(grid[i][j-1]==1)) {
    		sum++;
    	}
    	//��
    	if((j<grid[0].length-1)&&(grid[i][j+1]==1)) {
    		sum++;
    	}
    	//��
    	if((i>0)&&(grid[i-1][j]==1)) {
    		sum++;
    	}
    	//��
    	if((i<grid.length-1)&&(grid[i+1][j]==1)) {
    		sum++;
    	}
    	return sum;
    	
    }
}
