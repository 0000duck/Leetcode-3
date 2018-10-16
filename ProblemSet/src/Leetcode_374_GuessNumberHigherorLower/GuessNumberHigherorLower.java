package Leetcode_374_GuessNumberHigherorLower;

import java.util.Scanner;

/*
	����������һ����������Ϸ�� ��Ϸ�������£�
	�Ҵ� 1 �� n ѡ��һ�����֡� ����Ҫ����ѡ�����ĸ����֡�
	ÿ����´��ˣ��һ��������������Ǵ��˻���С�ˡ�
	�����һ��Ԥ�ȶ���õĽӿ� guess(int num)�����᷵�� 3 �����ܵĽ����-1��1 �� 0����
		-1 : ����Ƚ�С���´���
		 1 : ����Ƚϴ󡣲�С��
		 0 : ��ϲ���¶��ˣ�
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
    //Ԥ�ȶ���õĽӿ� guess(int num)
    public int guess(int num) {
    	//Ҫ�µ���
    	int result = 99;
    	//�´��ˣ�����-1
    	if(num>result) {
    		return -1;
    	}
    	if(num<result) {
    		return 1;
    	}
    	return 0;
    }
    
}
