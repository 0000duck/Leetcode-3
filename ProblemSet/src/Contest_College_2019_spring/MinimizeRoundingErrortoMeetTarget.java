package Contest_College_2019_spring;

/*
	����һϵ�м۸� [p1,p2...,pn] ��һ��Ŀ�� target��
	��ÿ���۸� pi ����Ϊ Roundi(pi) ��ʹ���������� [Round1(p1),Round2(p2)...,Roundn(pn)] ֮�ʹﵽ������Ŀ��ֵ target��
	ÿ��������� Roundi(pi) ������������ Floor(pi) Ҳ������������ Ceil(pi)��
	
	�����������֮��������ζ��޷��ﵽĿ��ֵ target���ͷ��� -1��
	�����Ա�����С�������λ���ַ�����ʽ������С���������䶨��Ϊ �� |Roundi(pi) - (pi)|�� i �� 1 �� n ����	 
	
	ʾ�� 1��	
		���룺prices = ["0.700","2.800","4.900"], target = 8
		�����"1.000"
		���ͣ� 
		ʹ�� Floor��Ceil �� Ceil �����õ� (0.7 - 0) + (3 - 2.8) + (5 - 4.9) = 0.7 + 0.2 + 0.1 = 1.0 ��
	ʾ�� 2��	
		���룺prices = ["1.500","2.500","3.500"], target = 10
		�����"-1"
		���ͣ�
		�ﵽĿ���ǲ����ܵġ� 
	
	��ʾ��	
		1 <= prices.length <= 500
		��ʾ�۸��ÿ���ַ��� prices[i] ������һ������ 0 �� 1000 ֮���ʵ�������������� 3 ��С��λ��
		target ���� 0 �� 1000000 ֮�䡣
 */
import java.util.PriorityQueue;

public class MinimizeRoundingErrortoMeetTarget {
	public static void main(String[] args) {
		String[] prices = { "0.700", "2.800", "4.900" };
		int target = 8;
		MinimizeRoundingErrortoMeetTarget mremt = new MinimizeRoundingErrortoMeetTarget();
		System.out.println(mremt.minimizeError(prices, target));
	}

	public String minimizeError0(String[] prices, int target) {
		int n = prices.length;
		// ��һ�� �������� �ڶ��� С������
		String[][] pri = new String[n][2];

		for (int i = 0; i < n; i++) {
			pri[i][0] = prices[i].split("\\.")[0];
			pri[i][1] = prices[i].split("\\.")[1];
		}
		// ����ȡ����
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(pri[i][0]);
		}
		// target̫С
		if (target < sum) {
			return "-1";
		}
		// ��С���� �� С������
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(pri[i][1]);
			if (temp != 0) {
				queue.add(temp);
			}
		}
		// target̫��
		if (sum + queue.size() < target) {
			return "-1";
		}
		int err = 0;
		int size = queue.size();
		for (int i = 0; !queue.isEmpty(); i++) {
			// С������ȡ�����������ȡ��
			// terget-sum������ȡ��
			if (i >= size - target + sum) {
				// ����ȡ��
				err += (1000 - queue.poll());
			} else {
				// ����ȡ��
				err += queue.poll();
			}
		}
		double res = (double) err / 1000;
		return String.format("%.3f", res);
	}

	// clean
	public String minimizeError(String[] prices, int target) {
		int n = prices.length;
		// ��С�����С������
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int sum = 0;// �������ֺ�
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(prices[i].split("\\.")[0]);
			int temp = Integer.parseInt(prices[i].split("\\.")[1]);
			// �������������
			if (temp != 0) {
				queue.add(temp);
			}
		}
		// target̫С��̫��
		if (target < sum || sum + queue.size() < target) {
			return "-1";
		}
		double err = 0;
		// ����ȡ���ĸ���Ϊterget-sum
		int count = queue.size() - target + sum;
		while (!queue.isEmpty()) {
			if (count == 0) {
				// ����ȡ��
				err += (1000 - queue.poll());
			} else {
				// ����ȡ��
				err += queue.poll();
				count--;
			}
		}
		return String.format("%.3f", err / 1000);
	}

}
