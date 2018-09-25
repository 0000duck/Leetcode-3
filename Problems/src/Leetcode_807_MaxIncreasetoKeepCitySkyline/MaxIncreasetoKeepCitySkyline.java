package Leetcode_807_MaxIncreasetoKeepCitySkyline;
/*
	�ڶ�ά����grid�У�grid[i][j]����λ��ĳ���Ľ�����ĸ߶ȡ� 
	���Ǳ����������κ���������ͬ��������������ܲ�ͬ���Ľ�����ĸ߶ȡ� 
	�߶� 0 Ҳ����Ϊ�ǽ����
	
	��󣬴�������������ĸ����򣨼��������ײ��������Ҳࣩ�ۿ��ġ�����ߡ�������ԭʼ������������ͬ�� 
	���е�������Ǵ�Զ���ۿ�ʱ�������н������γɵľ��ε��ⲿ������
	�뿴��������ӡ�	
	������߶ȿ������ӵ�����ܺ��Ƕ��٣�
	
	���ӣ�
		���룺 grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
		����� 35
	���ͣ� 
		The grid is:
		[ [3, 0, 8, 4], 
		  [2, 4, 5, 7],
		  [9, 2, 6, 3],
		  [0, 3, 1, 0] ]		
		��������ֱ���򣨼��������ײ�����������ߡ��ǣ�[9, 4, 8, 7]
		��ˮƽˮƽ���򣨼���࣬�Ҳࣩ��������ߡ��ǣ�[8, 7, 9, 3]
		
		�ڲ�Ӱ������ߵ�����¶Խ�����������ߺ����������£�		
		gridNew = [ [8, 4, 8, 7],
		            [7, 4, 7, 7],
		            [9, 4, 8, 7],
		            [3, 3, 3, 3] ]
	˵��:	
		1 < grid.length = grid[0].length <= 50��
		 grid[i][j] �ĸ߶ȷ�Χ�ǣ� [0, 100]��
		һ��������ռ��һ��grid[i][j]������֮�������� 1 x 1 x grid[i][j] �ĳ����塣
*/
public class MaxIncreasetoKeepCitySkyline {
	
	//807. ���ֳ��������
	public  int maxIncreaseKeepingSkyline(int[][] grid) {
		//��ȡ�к���
		int h = grid.length;
		int l = grid[0].length;
		//ͳ��
		int sum = 0;
        for(int i = 0;i<h;i++) {
        	for(int j = 0;j<l;j++) {
        		sum += (Math.min(maxHang(grid,i), maxLie(grid,j))-grid[i][j]);
        	}
        }
        return sum;
    }
	//��ȡ�е����ֵ
	 int maxHang(int[][] grid,int i) {
		int maxhang = grid[i][0];
		for(int j = 1;j<grid[0].length;j++) {
			if(maxhang<grid[i][j]) {
				maxhang = grid[i][j];
			}
		}
		return maxhang;
	}
	//��ȡ�е����ֵ
	 int maxLie(int[][] grid,int j) {
		int maxlie = grid[0][j];
		for(int i = 1;i<grid.length;i++) {
			if(maxlie<grid[i][j]) {
				maxlie = grid[i][j];
			}
		}
		return maxlie;
	}

}
