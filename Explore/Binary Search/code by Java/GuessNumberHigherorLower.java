package BinarySearch_374_GuessNumberHigherorLower;

/*
	����������һ����������Ϸ�� ��Ϸ�������£�
	�Ҵ� 1 �� n ѡ��һ�����֡� ����Ҫ����ѡ�����ĸ����֡�
	ÿ����´��ˣ��һ��������������Ǵ��˻���С�ˡ�
	�����һ��Ԥ�ȶ���õĽӿ� guess(int num)�����᷵�� 3 �����ܵĽ����-1��1 �� 0����
		-1 : �ҵ����ֱȽ�С���Ҳ´���
		 1 : �ҵ����ֱȽϴ��Ҳ�С��
		 0 : ��ϲ����¶��ˣ�
	ʾ�� :
		����: n = 10, pick = 6
		���: 6
*/
/* 
	The guess API is defined in the parent class GuessGame.
	@param num, your guess
	@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   	int guess(int num); 
*/
public class GuessNumberHigherorLower {	
	//374.�����ִ�С
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = 0;;
        while(left <=right) {
        	//int �������
        	//mid = (left +right)/2;
        	mid = left + (right-left)/2;
        	if(guess(mid)==0) {
        		//�Ҳµĸպ�
        		return mid;
        	}else if(guess(mid)>0) {
        		//�Ҳ�midС��
        		left = mid+1;
        	}else {
        		//�Ҳ�mid����
        		right = mid-1;
        	}
        }
        return mid;
    }
    
}
