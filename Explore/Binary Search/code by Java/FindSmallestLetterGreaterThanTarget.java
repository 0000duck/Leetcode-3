package Leetcode_744_FindSmallestLetterGreaterThanTarget;
/*
	����һ��ֻ����Сд��ĸ����������letters ��һ��Ŀ����ĸ target��Ѱ���������������Ŀ����ĸ�����С��ĸ��	
	��������ĸ��˳����ѭ���ġ�
	�ٸ����ӣ����Ŀ����ĸtarget = 'z' ������������Ϊ letters = ['a', 'b']����𰸷��� 'a'��
	
	ʾ��:	
		����:
			letters = ["c", "f", "j"]
			target = "a"
		���: "c"
	
		����:
			letters = ["c", "f", "j"]
			target = "c"
		���: "f"
	
		����:
			letters = ["c", "f", "j"]
			target = "d"
		���: "f"
	
		����:
			letters = ["c", "f", "j"]
			target = "g"
		���: "j"
		
		����:
			letters = ["c", "f", "j"]
			target = "j"
		���: "c"
		
		����:
			letters = ["c", "f", "j"]
			target = "k"
		���: "c"
	ע:	
		letters���ȷ�Χ��[2, 10000]�����ڡ�
		letters ����Сд��ĸ��ɣ����ٰ���������ͬ����ĸ��
		Ŀ����ĸtarget ��һ��Сд��ĸ��
*/
public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSmallestLetterGreaterThanTarget fslgtt = new FindSmallestLetterGreaterThanTarget();
		char[] letters = {'e','e','e','k','q','q','q','v','v','y'};
		char target = 'e';
		System.out.println(fslgtt.nextGreatestLetter(letters, target));
		
		
	}
	//744. Ѱ�ұ�Ŀ����ĸ�����С��ĸ
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        //���<����ߵģ�>=���ұߵ�
        if((target<letters[left])||(target>=letters[right])){
        	return letters[left];
        }
       
        while(left+1<right) {
        	int mid = left+(right-left)/2;
        	if(letters[mid]>target){
        		//target�����
        		right = mid;        		
        	}else {
        		left = mid;
        	}
        	System.out.println("left:"+left+",right:"+right);
        }
        //target<left<right
        if(letters[left]>target){
        	return letters[left];
        }
        //target=left< right
        if((letters[left]<=target)&&(letters[right]>target)) {
        	return letters[right];
        }
       return letters[left];        
        
    }

}
