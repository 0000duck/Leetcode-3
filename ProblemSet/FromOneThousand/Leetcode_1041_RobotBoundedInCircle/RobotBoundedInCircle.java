package Leetcode_1041_RobotBoundedInCircle;

/*
	�����޵�ƽ���ϣ����������λ�� (0, 0) �����泯�����������˿��Խ�����������ָ��֮һ��	
		"G"��ֱ�� 1 ����λ
		"L"����ת 90 ��
		"R"����ת 90 ��
		�����˰�˳��ִ��ָ�� instructions����һֱ�ظ����ǡ�	
	ֻ����ƽ���д��ڻ�ʹ�û�������Զ�޷��뿪ʱ������ true�����򣬷��� false��
	
	ʾ�� 1��	
		���룺"GGLLGG"
		�����true
		���ͣ�
		�����˴� (0,0) �ƶ��� (0,2)��ת 180 �ȣ�Ȼ��ص� (0,0)��
		�ظ���Щָ������˽���������ԭ��Ϊ���ģ�2 Ϊ�뾶�Ļ��н����ƶ���
	ʾ�� 2��	
		���룺"GG"
		�����false
		���ͣ�
		�������������ƶ���
	ʾ�� 3��	
		���룺"GL"
		�����true
		���ͣ�
		�����˰� (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... �����ƶ���	
	��ʾ��	
		1 <= instructions.length <= 100
		instructions[i] �� {'G', 'L', 'R'} ��
 */
//1041.���ڻ��еĻ�����
public class RobotBoundedInCircle {
	// �ֳ��ֳ�
	public boolean isRobotBounded(String instructions) {
		int[] cur = { 0, 0 };
		int curf = 3;
		return isRobotBounded(instructions, curf, cur);
	}

	public boolean isRobotBounded(String instructions, int curf, int[] cur) {
		// �����ϱ�
		int[][] dirc = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int i = 0; i < instructions.length(); i++) {
			switch (instructions.charAt(i)) {
			case 'G':
				cur[0] += dirc[curf][0];
				cur[1] += dirc[curf][1];
				break;
			case 'L':
				if (curf == 0) {
					curf = 3;
				} else if (curf == 1) {
					curf = 2;
				} else if (curf == 2) {
					curf = 0;
				} else {
					curf = 1;
				}
				break;
			case 'R':
				if (curf == 0) {
					curf = 2;
				} else if (curf == 1) {
					curf = 3;
				} else if (curf == 2) {
					curf = 1;
				} else {
					curf = 0;
				}
				break;
			}
		}
		System.out.println(curf);
		System.out.println(cur[0] + "," + cur[1]);
		if (cur[0] == 0 && cur[1] == 0) {
			return true;
		}
		if (curf == 3) {
			return false;
		} else {
			return true;
		}

	}

	// 1ms
	public boolean isRobotBounded0(String instructions) {
		// ������ʼλ��
		int x = 0;
		int y = 0;

		// �� -R->�� +1
		// �� -R->�� +1
		// �� -R->�� +1
		// �� -R->�� +1
		// L=RRR

		// ��ʼ������Ϊ��
		int i = 0;
		// ���巽��:��0����1����2����3
		int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		for (char ch : instructions.toCharArray()) {
			switch (ch) {
			case 'R':
				i = (i + 1) % 4;
				break;
			case 'L':
				i = (i + 3) % 4;
				break;
			default:
				x += d[i][0];
				y += d[i][1];
			}
		}
		return (x == 0 && y == 0) || i > 0;
	}

}
