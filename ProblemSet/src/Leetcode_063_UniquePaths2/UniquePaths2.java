package Leetcode_063_UniquePaths2;



/*
	һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
	������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
	���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
	
	�����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
	˵����m �� n ��ֵ�������� 100��
	
	ʾ�� 1:
	����:
		[
		  [0,0,0],
		  [0,1,0],
		  [0,0,0]
		]
	���: 2
	����:
		3x3 ��������м���һ���ϰ��
		�����Ͻǵ����½�һ���� 2 ����ͬ��·����
		1. ���� -> ���� -> ���� -> ����
		2. ���� -> ���� -> ���� -> ����
*/
public class UniquePaths2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		UniquePaths2 up2 = new UniquePaths2();
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		int num=up2.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(num);
	}
	//63. ��ͬ·�� II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	//��һ��λ��Ϊ�ϰ���
    	if(obstacleGrid[0][0]==1) {
    		return 0;
    	}
        //��ȡ����
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	//���µ�һ��
    	for(int i=0;i<m;i++) {
    		if(obstacleGrid[i][0]==1) {
    			//i��0�������ϰ���    			
    			//�ϰ��������·����
    			for(int p = i;p<m;p++) {
    				obstacleGrid[p][0]=0;    				
    			}
    			break;
    		}else {
    			obstacleGrid[i][0] =1;
    		}
    	}
    	//���µ�һ��
    	for(int j=1;j<n;j++) {
    		if(obstacleGrid[0][j]==1) {
    			//i��0�������ϰ���    			
    			//�ϰ��������·����
    			for(int p = j;p<n;p++) {
    				obstacleGrid[0][p]=0;
    			}
    			break;
    		}else {
    			obstacleGrid[0][j] =1;
    		}
    	}
    	//�ҳ�·������
    	for(int i = 1;i<m;i++) {
    		for(int j = 1;j<n;j++) {
    			if(obstacleGrid[i][j]==1) {
    				obstacleGrid[i][j]=0;
    			}else{
    				obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
    			}
    			
    		}
    	}
    	//�����ά����
    	//new matrixOutput().ArrayOutput(obstacleGrid);
    	
    	return obstacleGrid[m-1][n-1];
    }

}
