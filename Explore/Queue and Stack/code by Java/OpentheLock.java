package Leetcode_752_OpentheLock;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
	����һ�������ĸ�Բ�β��ֵ�ת������
	ÿ�����ֶ���10�����֣� '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ��
	ÿ�����ֿ���������ת������� '9' ��Ϊ  '0'��'0' ��Ϊ '9' ��ÿ����ת��ֻ����תһ�����ֵ�һλ���֡�
	
	���ĳ�ʼ����Ϊ '0000' ��һ�������ĸ����ֵ����ֵ��ַ�����	
	�б� deadends ������һ���������֣�һ�����ֵ����ֺ��б�����κ�һ��Ԫ����ͬ����������ᱻ�����������޷��ٱ���ת��	
	�ַ��� target ������Խ��������֣�����Ҫ������С����ת���������������β��ܽ��������� -1�� 
	
	ʾ�� 1:	
		���룺deadends = ["0201","0101","0102","1212","2002"], target = "0202"
		�����6
	���ͣ�
		���ܵ��ƶ�����Ϊ "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"��
		ע�� "0000" -> "0001" -> "0002" -> "0102" -> "0202" �����������ǲ��ܽ����ģ�
		��Ϊ�������� "0102" ʱ������ͻᱻ������
		
	ʾ�� 2:	
		����: deadends = ["8888"], target = "0009"
		�����1
	���ͣ�
		�����һλ������תһ�μ��� "0000" -> "0009"��
		
	ʾ�� 3:	
		����: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
		�����-1
	���ͣ�
		�޷���ת��Ŀ�������Ҳ���������
		
	ʾ�� 4:	
		����: deadends = ["0000"], target = "8888"
		�����-1	 
	
	��ʾ��	
		�����б� deadends �ĳ��ȷ�ΧΪ [1, 500]��
		Ŀ������ target ������ deadends ֮�С�
		ÿ�� deadends �� target �е��ַ��������ֻ��� 10,000 �����ܵ���� '0000' �� '9999' �в�����
 */
public class OpentheLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] deadends = { "0000" };
		String target = "8888";
		OpentheLock ol = new OpentheLock();
		System.out.println(ol.openLock(deadends, target));
		// System.out.println(ol.back("9", 0));
	}

	// 752. ��ת����
	public int openLock(String[] deadends, String target) {
		Set<String> deadset = new HashSet<String>();
		Set<String> set = new HashSet<String>();
		for (String str : deadends) {
			deadset.add(str);
		}
		if (deadset.contains("0000")) {
			return -1;
		}

		Queue<String> queue = new LinkedList<String>();
		queue.offer("0000");
		set.add("0000");
		int step = 0;
		while (!queue.isEmpty()) {
			step++;

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.peek();

				// ת��
				for (int j = 0; j < 4; j++) {
					String temp = forward(cur, j);
					if (!deadset.contains(temp) && !set.contains(temp)) {
						if (temp.equals(target)) {
							return step;
						}
						queue.offer(temp);
						set.add(temp);
					}
					String temp2 = back(cur, j);
					if (!deadset.contains(temp2) && !set.contains(temp2)) {

						if (temp2.equals(target)) {

							return step;
						}
						queue.offer(temp2);
						set.add(temp2);
					}
				}
				queue.poll();
			}
		}
		return -1;
	}

	// ���ת��
	public String back(String cur, int j) {
		StringBuilder sb = new StringBuilder(cur);
		char temp = sb.charAt(j);
		sb.deleteCharAt(j);
		temp = (char) ((temp - '0' + 9) % 10 + '0');
		sb.insert(j, temp);
		return sb.toString();
	}

	// ��ǰת��
	public String forward(String cur, int j) {
		StringBuilder sb = new StringBuilder(cur);
		char temp = sb.charAt(j);
		sb.deleteCharAt(j);
		temp = (char) ((temp - '0' + 1) % 10 + '0');
		sb.insert(j, temp);
		return sb.toString();
	}

	// 18ms
	public int openLock0(String[] deadends, String target) {
		boolean[] isVisit = new boolean[10000];
		boolean[] isDead = new boolean[10000];
		for (String deadEnd : deadends) {
			int deadNum = Integer.parseInt(deadEnd);
			isDead[deadNum] = true;
		}
		// ���"0000"��deadEnds�У�����-1
		if (isDead[0]) {
			return -1;
		}
		if ("0000".equals(target)) {
			return 0;
		}

		int step = 0;

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(Integer.parseInt(target));
		isVisit[Integer.parseInt(target)] = true;
		int last = Integer.parseInt(target);
		int cenglast = last;
		while (!queue.isEmpty()) {
			while (true) {
				int[] neighbor = new int[8];
				int head = queue.poll();
				if (head == 0) {
					return step;
				}
				int[] nei = neighbor(head);
				for (int i = 0; i < 8; i++) {
					int trans = nei[i];
					if (isVisit[trans] || isDead[trans]) {
						continue;
					}
					queue.offer(trans);
					last = trans;
					isVisit[trans] = true;
				}
				if (head == cenglast) {
					break;
				}
			}
			step++;
			cenglast = last;
		}
		return -1;

	}

	private int[] neighbor(int code) {
		int[] res = new int[8];
		int a = code % 10;
		int b = (code / 10) % 10;
		int c = (code / 100) % 10;
		int d = (code / 1000) % 10;
		res[0] = d * 1000 + c * 100 + b * 10 + (a + 10 - 1) % 10;
		res[1] = d * 1000 + c * 100 + b * 10 + (a + 1) % 10;
		res[2] = d * 1000 + c * 100 + ((b + 10 - 1) % 10) * 10 + a;
		res[3] = d * 1000 + c * 100 + ((b + 1) % 10) * 10 + a;
		res[4] = d * 1000 + ((c + 10 - 1) % 10) * 100 + b * 10 + a;
		res[5] = d * 1000 + ((c + 1) % 10) * 100 + b * 10 + a;
		res[6] = ((d + 10 - 1) % 10) * 1000 + c * 100 + b * 10 + a;
		res[7] = ((d + 1) % 10) * 1000 + c * 100 + b * 10 + a;
		return res;
	}

}
