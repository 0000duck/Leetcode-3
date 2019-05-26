package Leetcode_1054_DistantBarcodes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
/*
	��һ���ֿ����һ�������룬���е� i ��������Ϊ barcodes[i]��	
	��������������Щ�����룬ʹ�����������ڵ������� ���� ��ȡ� ����Է����κ������Ҫ��Ĵ𰸣����Ᵽ֤���ڴ𰸡�	 
	
	ʾ�� 1��	
		���룺[1,1,1,2,2,2]
		�����[2,1,2,1,2,1]
	ʾ�� 2��	
		���룺[1,1,1,1,2,2,3,3]
		�����[1,3,1,3,2,1,2,1]
	 
	
	��ʾ��	
		1 <= barcodes.length <= 10000
		1 <= barcodes[i] <= 10000
 */
//1054. ������ȵ�������
public class DistantBarcodes {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}
	
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] res = Arrays.copyOf(barcodes, barcodes.length);
        if(barcodes.length<3) {
        	return res;
        }
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(Integer it : barcodes) {
        	if(hash.containsKey(it)) {
        		hash.put(it, hash.get(it)+1);
        	}else {
        		hash.put(it, 1);
        	}
        }
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		// Ƶ�ʴӸߵ���
        		return o2[0]-o1[0];
        	}
        });
        for(Integer it :hash.keySet()) {
        	que.add(new int[] {hash.get(it),it});
        }
        for(int i = 0;i<res.length;i++) {
        	if(i==0||res[i-1]!=que.peek()[1]) {
        		int[] tem  = que.peek();
        		res[i]=tem[1];
        		tem[0]--;
        		que.poll();
        		que.add(tem);
        	}else {
        		int[] tem1 = que.poll();
        		int[] tem = que.peek();
        		res[i] = tem[1];
        		tem[0]--;
        		que.poll();
        		que.add(tem);
        		que.add(tem1);
        		
        	}
        }
        return res;
    }

}
