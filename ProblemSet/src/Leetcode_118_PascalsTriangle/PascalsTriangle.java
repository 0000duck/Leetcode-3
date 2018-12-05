package Leetcode_118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/*
	����һ���Ǹ����� numRows������������ǵ�ǰ numRows �С�	
	
	��ͼͼƬ��https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif	
	����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�	
	
		ʾ��:		
			����: 5
			���:
			[
			     [1],
			    [1,1],
			   [1,2,1],
			  [1,3,3,1],
			 [1,4,6,4,1]
			]
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangle pst = new PascalsTriangle();
		pst.generate(5);
	}

	// 118. �������
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return result;
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		result.add(list);
		if (numRows == 1) {
			return result;
		}
		for (int i = 1; i < numRows; i++) {
			// ������
			List<Integer> nofirstlist = new ArrayList<Integer>();
			nofirstlist.add(1);
			for (int j = 1; j < i; j++) {
				nofirstlist.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
			}
			nofirstlist.add(1);
			result.add(nofirstlist);
		}
		return result;
	}

	// 0ms
	public List<List<Integer>> generate2(int numRows) {
		int[][] yanghuiArr = new int[numRows][numRows];
		for (int i = 0; i < numRows; i++) {
			yanghuiArr[i][0] = 1;
			yanghuiArr[i][i] = 1;
		}
		for (int i = 2; i < numRows; i++) {
			for (int j = 1; j <= i; j++) {
				yanghuiArr[i][j] = yanghuiArr[i - 1][j - 1] + yanghuiArr[i - 1][j];
			}
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList(i + 1);
			for (int j = 0; j <= i; j++) {
				list.add(yanghuiArr[i][j]);
			}
			result.add(list);
		}
		return result;
	}

}
