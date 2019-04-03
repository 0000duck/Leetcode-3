package Leetcode_218_TheSkylineProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
	���е�������Ǵ�Զ���ۿ��ó��������н������γɵ��������ⲿ������
	���ڣ�����������˳��з����Ƭ��ͼA:skyline1������ʾ�����н������λ�ú͸߶ȣ�
	���дһ���������������Щ�������γɵ�����ߣ�ͼB:skyline2����
	
	ÿ��������ļ�����Ϣ����Ԫ�� [Li��Ri��Hi] ��ʾ��
	���� Li �� Ri �ֱ��ǵ� i �����������ұ�Ե�� x ���꣬Hi ����߶ȡ�
	���Ա�֤ 0 �� Li, Ri �� INT_MAX, 0 < Hi �� INT_MAX �� Ri - Li > 0��
	�����Լ������н����ﶼ���ھ���ƽ̹�Ҹ߶�Ϊ 0 �ı����ϵ��������Ρ�
	
	���磬ͼA�����н�����ĳߴ��¼Ϊ��
		 	[Li Ri Hi] 
		[	[2 9 10], 
			[3 7 15], 
			[5 12 12], 
			[15 20 10], 
			[19 24 8] ] ��
	
	������� [ [x1,y1], [x2, y2], [x3, y3], ... ] ��ʽ�ġ��ؼ��㡱��ͼB�еĺ�㣩���б�����Ψһ�ض���������ߡ�
	�ؼ�����ˮƽ�߶ε���˵㡣
	��ע�⣬���Ҳཨ��������һ���ؼ�������ڱ������ߵ��յ㣬��ʼ��Ϊ��߶ȡ�
	���⣬�κ��������ڽ�����֮��ĵ��涼Ӧ����Ϊ�����������һ���֡�
	
	���磬ͼB�е������Ӧ�ñ�ʾΪ��
		[ 	[2 10], 
			[3 15], 
			[7 12], 
			[12 0], 
			[15 10], 
			[20 8], 
			[24, 0] ]��
	
	˵��:
	�κ������б��еĽ�����������֤�� [0, 10000] ��Χ�ڡ�
	�����б��Ѿ����� x ���� Li  �����������С�
	����б���밴 x λ����
	���������в�������������ͬ�߶ȵ�ˮƽ�ߡ�
	���� [...[2 3], [4 5], [7 5], [11 5], [12 7]...] �ǲ���ȷ�Ĵ𰸣�
	�����߶�Ϊ 5 ����Ӧ������������кϲ�Ϊһ����[...[2 3], [4 5], [12 7], ...]
 */
public class TheSkylineProblem {
	// 218. ���������
	public List<int[]> getSkyline(int[][] buildings) {
		// Node���齫ԭʼ���ݲ�ֳ�����
		Node[] nodes = new Node[buildings.length * 2];
		for (int i = 0; i < buildings.length; i++) {
//			L:buildings[i][0]
//			R:buildings[i][1]
//			H:buildings[i][2]
			nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
			nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
		}
		// �����ݰ��պ�����Ĵ�С����С��������
		Arrays.sort(nodes, new NodeComparator());
		// �������齫���ݷ���TreeMap: key���߶� value:��Ƶ
		TreeMap<Integer, Integer> htMap = new TreeMap<>();
		// ��¼�߶ȱ仯���γ�������ʱʹ��
		TreeMap<Integer, Integer> pmMap = new TreeMap<>();
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].isUp) {
				// ����
				if (htMap.containsKey(nodes[i].h)) {
					htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
				} else {
					htMap.put(nodes[i].h, 1);
				}
			} else {
				// ����
				if (htMap.containsKey(nodes[i].h)) {
					if (htMap.get(nodes[i].h) == 1) {
						htMap.remove(nodes[i].h);
					} else {
						htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
					}
				}
			}
			// ��pmMap�м�¼�߶ȱ仯
			if (htMap.isEmpty()) {
				pmMap.put(nodes[i].x, 0);
			} else {
				pmMap.put(nodes[i].x, htMap.lastKey());
			}
		}

		// ����������
		List<int[]> res = new ArrayList<>();
		int hight = 0;
		int start = 0;
		for (Entry<Integer, Integer> entry : pmMap.entrySet()) {
			int curStation = entry.getKey();
			int curMaxHight = entry.getValue();
			// �߶ȷ����仯
			if (hight != curMaxHight) {

				int[] newres = new int[2];
				newres[0] = curStation;
				newres[1] = curMaxHight;
				res.add(newres);

				hight = curMaxHight;
				start = curStation;
			}
		}
		return res;

	}

}

//TreeMap�ıȽ���
class NodeComparator implements Comparator<Node> {
	@Override
	public int compare(Node o1, Node o2) {
		// ��ʼλ���Ƿ���ȣ�С�ķ�ǰ��
		if (o1.x != o2.x) {
			return o1.x - o2.x;
		}
		// ���µķ�ǰ��
		if (o1.isUp != o2.isUp) {
			return o1.isUp ? -1 : 1;
		}
		return 0;
	}
}

//�ڵ�
class Node {
	public boolean isUp;
	public int x;
	public int h;

	public Node(boolean flag, int x, int h) {
		this.isUp = flag;
		this.x = x;
		this.h = h;
	}
}
