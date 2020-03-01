package Leetcode_367_ValidPerfectSquare;

/*
	����һ�������� num����дһ����������� num ��һ����ȫƽ�������򷵻� True�����򷵻� False��
	
	˵������Ҫʹ���κ����õĿ⺯������  sqrt��
	
	ʾ�� 1��	
		���룺16
		�����True
	ʾ�� 2��	
		���룺14
		�����False
*/
public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPerfectSquare vps = new ValidPerfectSquare();
		int num = 5;		
		//System.out.println(1073697800*1073697800);
		System.out.println(vps.isPerfectSquare(num));
	}

	// 367.��Ч����ȫƽ����
	public boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		if (num <= 0) {
			return false;
		}
		// ���ֲ���
		int left = 1;
		int right = num;
		while (left+1 < right) {			
			int mid = left + (right - left) / 2;
			System.out.println("left:"+left+",right:"+right+",mid:"+mid);
			if(num/mid>mid) {
				left = mid;
			}else {
				right = mid;
			}
			//System.out.println("left2:"+left+",right2:"+right+",mid2:"+mid);
		}
		if((left*left==num)||(right*right==num)) {
			return true;
		}		
		return false;
	}

}
