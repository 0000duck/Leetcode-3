package Contest_College_2019_spring;

/*
	��������ͼ�ı� edges���Լ���ͼ��ʼ�� source ��Ŀ���յ� destination��
	ȷ����ʼ�� source ����������·���Ƿ����ս�����Ŀ���յ� destination������
	
	��ʼ�� source ��Ŀ���յ� destination ��������һ��·��
	������ڴ�ʼ�� source ��û�г��ߵĽڵ��·������ýڵ����·���յ㡣
	��ʼ��source��Ŀ���յ� destination ����·��������������
	����ʼ�� source ����������·�������Ե���Ŀ���յ� destination ʱ���� true�����򷵻� false��	 
	
	ʾ�� 1��	
		���룺n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
		�����false
		˵�����ڵ� 1 �ͽڵ� 2 �����Ե����Ҳ�Ῠ�����
	ʾ�� 2��	
		���룺n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
		�����false
		˵���������ֿ��ܣ��ڽڵ� 3 �������������ڽڵ� 1 �ͽڵ� 2 ֮������ѭ����
	ʾ�� 3��	
		���룺n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
		�����true
	ʾ�� 4��	
		���룺n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
		�����false
		˵������ʼ�����������·������Ŀ���յ���������������޶��·������ 0-1-2��0-1-1-2��0-1-1-1-2��0-1-1-1-1-2 �ȡ�
	ʾ�� 5��	
		���룺n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
		�����false
		˵������Ŀ��ڵ��ϴ������޵��Ի���
	 
	
	��ʾ��	
	������ͼ�п��ܴ����Ի���ƽ�бߡ�
	ͼ�еĽڵ��� n ���� 1 �� 10000 ֮�䡣
	ͼ�еı����� 0 �� 10000 ֮�䡣
	0 <= edges.length <= 10000
	edges[i].length == 2
	0 <= source <= n - 1
	0 <= destination <= n - 1
 */


public class AllPathsfromSourceLeadtoDestination {
	public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

		return false;

	}

}
