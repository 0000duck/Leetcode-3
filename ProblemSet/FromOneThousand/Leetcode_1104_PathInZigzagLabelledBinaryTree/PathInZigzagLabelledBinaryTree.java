package Leetcode_1104_PathInZigzagLabelledBinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
	��һ�����޵Ķ������ϣ�ÿ���ڵ㶼�������ӽڵ㣬���еĽڵ� ���� ���ΰ� ��֮�� ���ν��б�ǡ�	
	����ͼ��ʾ���������У�������һ�С������С������С������У��������ҵ�˳����б�ǣ�	
	��ż���У������ڶ��С������С������С������У������ҵ����˳����б�ǡ�
	
	��������ĳһ���ڵ�ı�� label��
	���㷵�شӸ��ڵ㵽�ñ��Ϊ label �ڵ��·����
	��·������;���Ľڵ�������ɵġ�		 
	
	ʾ�� 1��	
		���룺label = 14
		�����[1,3,4,14]
	ʾ�� 2��	
		���룺label = 26
		�����[1,2,6,10,26]		 
	
	��ʾ��	
		1 <= label <= 10^6
 */

//1104.������Ѱ·
public class PathInZigzagLabelledBinaryTree {
	public static void main(String[] args) {
		new PathInZigzagLabelledBinaryTree().pathInZigZagTree(14);
	}

	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> res = new ArrayList<>();
		int level = 0;
		int temp = label;
		while (temp != 1) {
			level++;
			temp /= 2;
		}
		while (label >= 1) {
			level--;
			res.add(0, label);
			label = 3 * (int) Math.pow(2, level) - 1 - label / 2;
		}

		return res;
	}
}
