package Leetcode_441_ArrangingCoins;
/*
	���ܹ��� n öӲ�ң�����Ҫ�����ǰڳ�һ��������״���� k �оͱ��������� k öӲ�ҡ�	
	����һ������ n���ҳ����γ����������е���������	
	n ��һ���Ǹ�������������32λ�з������͵ķ�Χ�ڡ�
	
	ʾ�� 1:	
		n = 5
	
		Ӳ�ҿ����г����¼���:
		��
		�� ��
		�� ��
		
		��Ϊ�����в����������Է���2.
		
	ʾ�� 2:	
		n = 8
		
		Ӳ�ҿ����г����¼���:
		��
		�� ��
		�� �� ��
		�� ��
	
		��Ϊ�����в����������Է���3.
 */
public class ArrangingCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrangingCoins ac = new ArrangingCoins();
		System.out.println(ac.arrangeCoins(2));
	}
	//441. ����Ӳ��
	//���ֲ���
	public int arrangeCoins(int n) {
		//0��1����n
		if(n<=1) {
			return n;			
		}
		//n>=2ʱ
		long left = 0;
		long right = n;
		while(left<=right) {
			long mid = left+(right-left)/2;
			long sum = (1+mid)*mid/2;			
			if(sum<=n) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}		
		return (int)right;
	}
	//ֱ�Ӽ���
    public int arrangeCoins2(int n) {    	
    	int i = 1;
        while(n>0) {
        	n -= i;
        	if(n<0) {
        		return i-1;
        	}else if(n==0) {
        		return i;
        	}
        	i++;        	
        }
        return i-1;
    }

}
