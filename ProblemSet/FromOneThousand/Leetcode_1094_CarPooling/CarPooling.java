package Leetcode_1094_CarPooling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
	��������һλ˳�糵˾������������� capacity ������λ���������ؿ͡�
	���ڵ�·�����ƣ��� ֻ�� ��һ��������ʻ��Ҳ����˵���������ͷ��ı䷽������Խ�������Ϊһ����������
	
	�����һ���г̼ƻ��� trips[][]������
	trips[i] = [num_passengers, start_location, end_location] 
	 ��������ĵ� i ���г���Ϣ��	
		������͵ĳ˿�������
		�˿͵��ϳ��ص㣻
		�Լ��˿͵��³��ص㡣
	��Щ�����ĵص�λ���Ǵ���� ��ʼ ����λ����ǰ��ʻ����Щ�ص�����ľ��루����һ���������ʻ�����ϣ���
	
	������ݸ������г̼ƻ���ͳ��ӵ���λ�������ж���ĳ��Ƿ����˳����ɽ������ó˿͵�����
	�����ҽ�������������и������г��н������г˿�ʱ������ true�������뷵�� false����	 
	
	ʾ�� 1��	
		���룺trips = [[2,1,5],[3,3,7]], capacity = 4
		�����false
	ʾ�� 2��	
		���룺trips = [[2,1,5],[3,3,7]], capacity = 5
		�����true
	ʾ�� 3��	
		���룺trips = [[2,1,5],[3,5,7]], capacity = 3
		�����true
	ʾ�� 4��	
		���룺trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
		�����true
	
	��ʾ��	
		����Լ���˿ͻ��Ծ����� �����º��ϡ� ����������
		trips.length <= 1000
		trips[i].length == 3
		1 <= trips[i][0] <= 100
		0 <= trips[i][1] < trips[i][2] <= 1000
		1 <= capacity <= 100000
 */
public class CarPooling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1094. ƴ��
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {        		
        		return o1[1]-o2[1]==0?o1[2]-o2[2]:o1[1]-o2[1];
        	}
		});
        //��¼�ϳ��ĳ˿�
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        int curCapacity = trips[0][0];
        for(int i = 1;i<trips.length;i++) {
        	for(int j = 0;j<list.size();) {
        		//����Ƿ������Ѿ��³�
        		if(trips[i][1]>=trips[list.get(j)][2]) {
        			curCapacity -= trips[list.get(j)][0];
        			list.remove(j);
        		}else {
        			j++;
        		}
        	}
        	//�ϳ�
        	curCapacity+=trips[i][0];
        	if(curCapacity>capacity) {
        		return false;
        	}else {
        		list.add(i);
        	}
        }
        return true;
    }

}
