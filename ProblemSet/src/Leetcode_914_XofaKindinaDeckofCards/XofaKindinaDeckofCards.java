package Leetcode_914_XofaKindinaDeckofCards;

import java.util.HashMap;
import java.util.Set;

/*
	����һ���ƣ�ÿ�����϶�д��һ��������
	��ʱ������Ҫѡ��һ������ X��ʹ���ǿ��Խ������ư���������ֳ� 1 �������飺
		ÿ�鶼�� X ���ơ�
		�������е����϶�д����ͬ��������
	�������ѡ�� X >= 2 ʱ���� true�� 
	
	ʾ�� 1��
		���룺[1,2,3,4,4,3,2,1]
		�����true
		���ͣ����еķ����� [1,1]��[2,2]��[3,3]��[4,4]
	
	ʾ�� 2��
		���룺[1,1,1,2,2,2,3,3]
		�����false
		���ͣ�û������Ҫ��ķ��顣
	
	ʾ�� 3��
		���룺[1]
		�����false
		���ͣ�û������Ҫ��ķ��顣
	
	ʾ�� 4��
		���룺[1,1]
		�����true
		���ͣ����еķ����� [1,1]
	
	ʾ�� 5��
		���룺[1,1,2,2,2,2]
		�����true
		���ͣ����еķ����� [1,1]��[2,2]��[2,2]
	
	��ʾ��
		1 <= deck.length <= 10000
		0 <= deck[i] < 10000
 */
public class XofaKindinaDeckofCards {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	// 914. ���Ʒ���(36ms)
	public boolean hasGroupsSizeX(int[] deck) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < deck.length; i++) {
			if (map.containsKey(deck[i])) {
				int count = map.get(deck[i]);
				count++;
				map.put(deck[i], count);
			} else {
				map.put(deck[i], 1);
			}
		}

		int mincount = Integer.MAX_VALUE;
		int maxcount = 0;
		Set<Integer> keyset = map.keySet();
		int[] valarr = new int[keyset.size()];
		int index = 0;
		for (Integer temp : keyset) {
			valarr[index] = map.get(temp);
			mincount = Math.min(mincount, valarr[index]);
			maxcount = Math.max(maxcount, valarr[index]);
			index++;			
		}
		if(mincount<=1) {
			return false;
		}
		for(int i = 2;i<=maxcount;i++) {
			for(int j = 0;j<valarr.length;j++) {
				if(valarr[j]%i!=0) {
					break;
				}
				if(j==valarr.length-1) {
					return true;
				}
			}			
		}
		return false;
		
	}
	//��ţ����
	public boolean hasGroupsSizeX2(int[] deck) {
		int res = 0;
	    int[] times = new int[10000];
	    //ͳ�Ƹ���Ԫ�س��ֵĸ���
	    for(int i:deck) {
	    	times[i]++;
	    }	            
	    for(int i:times){
	        if(i!=0){
	        	//����times����������Ԫ�ص���С��Լ��
	        	res = gcd(i,res); 
	        }
	    }
	     return res>1;
	}
	//����������С��Լ��
	public static int gcd(int a,int b){
	        return b>0 ? gcd(b,a%b) : a;
	    }
}
