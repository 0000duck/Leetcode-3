package Leetcode_070_ClimbingStairs;

import java.util.HashMap;

/*
	������������¥�ݡ���Ҫ n ������ܵ���¥����	
	ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
		
	ע�⣺���� n ��һ����������
	
	ʾ�� 1��	
		���룺 2
		����� 2
		���ͣ� �����ַ�����������¥����
		1.  1 �� + 1 ��
		2.  2 ��
		
	ʾ�� 2��	
		���룺 3
		����� 3
		���ͣ� �����ַ�����������¥����
		1.  1 �� + 1 �� + 1 ��
		2.  1 �� + 2 ��
		3.  2 �� + 1 ��
*/
public class ClimbingStairs {
	// 70.��¥��
	public static int climbStairs(int n) {
		int[] Stairs = new int[n];
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		Stairs[0] = 1;
		Stairs[1] = 2;
		for (int i = 2; i < n; i++) {
			Stairs[i] = Stairs[i - 1] + Stairs[i - 2];
		}
		return Stairs[n - 1];
	}
	
	//�ݹ�(��ʱ)
    public int climbStairs0(int n) {
        if(n<=2) {
        	return 2;
        }
        return climbStairs0(n-1)+climbStairs0(n-2);
    }
    
    //hash����
    private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int climbStairs2(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n<=2) {
        	return n;
        }
        int res =  climbStairs(n-1)+climbStairs(n-2);
        map.put(n,res);
        return res;
    }
}
