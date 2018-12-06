package Leetcode_119_PascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

/*
	����һ���Ǹ����� k������ k �� 33������������ǵĵ� k �С�
	��ͼ��https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
	
	����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
	ʾ��:
		����: 3
		���: [1,3,3,1]
	���ף�
		������Ż�����㷨�� O(k) �ռ临�Ӷ���
 */
public class PascalsTriangle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangle2 pst2 = new PascalsTriangle2();
		pst2.getRow2(3);
	}

	// 119. ������� II
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if (rowIndex == 1) {
			return list;
		}

		List<Integer> nextlist = new ArrayList<Integer>();
		for (int i = 1; i <= rowIndex + 1; i++) {
			nextlist.add(1);
			for (int j = 1; j < i; j++) {
				nextlist.add(list.get(j) + list.get(j - 1));
			}
			nextlist.add(1);
			if (i == rowIndex) {
				return list;
			}
			list.clear();
			list.addAll(nextlist);
			nextlist.clear();
		}
		return list;
	}

	// 0ms
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		long nk = 1;
		for (int i = 0; i <= rowIndex; i++) {
			res.add((int) nk);
			nk = nk * (rowIndex - i) / (i + 1);
		}
		return res;
	}

}
