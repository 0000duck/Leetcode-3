package Leetcode_1052_GrumpyBookstoreOwner;
/*
	���죬����ϰ���һ�ҵ������Ӫҵ customers.length ���ӡ�
	ÿ���Ӷ���һЩ�˿ͣ�customers[i]���������꣬������Щ�˿Ͷ�������һ���ӽ������뿪��
	
	��ĳЩʱ������ϰ�������� �������ϰ��ڵ� i ������������ô grumpy[i] = 1��
	���� grumpy[i] = 0�� ������ϰ�����ʱ����һ���ӵĹ˿;ͻ᲻���⣬������������������ġ�
	
	����ϰ�֪��һ�����ܼ��ɣ��������Լ����������������Լ����� X ���Ӳ���������ȴֻ��ʹ��һ�Ρ�
	
	���㷵����һ��Ӫҵ����������ж��ٿͻ��ܹ��е������������
	ʾ����
		���룺customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
		�����16
	���ͣ�
		����ϰ������ 3 ���ӱ����侲��
		�е���������ͻ����� = 1 + 1 + 1 + 1 + 7 + 5 = 16.
	
	��ʾ��	
		1 <= X <= customers.length == grumpy.length <= 20000
		0 <= customers[i] <= 1000
		0 <= grumpy[i] <= 1
	 
 */

//1052. ������������ϰ�
public class GrumpyBookstoreOwner {
	public static void main(String[] args) {
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int X=3;
		System.out.println(new GrumpyBookstoreOwner().maxSatisfied(customers, grumpy, X));
	}
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    	int result = 0;
        int j = 0;
    	int max = 0;
    	int temp = 0;
    	for(int i = 0;i<customers.length;i++) {
        	if(grumpy[i]==0) {
        		result += customers[i];
        	}
        	if(i-j+1<=X) {
    			if(grumpy[i]==1) {
    				temp += customers[i];
    			}    			
    		}else {
    			if(grumpy[j]==1) {
    				temp -= customers[j];
    			}
    			if(grumpy[i]==1) {
    				temp += customers[i];
    			}
    			j++;
    		}    		
    		max = Math.max(max, temp);
        }
        return result+max;
    }
}
