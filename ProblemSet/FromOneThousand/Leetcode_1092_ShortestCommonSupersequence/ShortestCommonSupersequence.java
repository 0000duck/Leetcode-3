package Leetcode_1092_ShortestCommonSupersequence;
/*
	���������ַ��� str1 �� str2������ͬʱ�� str1 �� str2 ��Ϊ�����е�����ַ�����
	����𰸲�ֹһ��������Է�����������������һ���𰸡�
	
	��������ַ��� T ��ɾ��һЩ�ַ���Ҳ���ܲ�ɾ��������ѡ������Щ�ַ�����λ�� T �е� ����λ�ã���
	���Եõ��ַ��� S����ô S ���� T �������У�	 
	
	ʾ����	
		���룺str1 = "abac", str2 = "cab"
		�����"cabac"
		���ͣ�
		str1 = "abac" �� "cabac" ��һ���Ӵ�����Ϊ���ǿ���ɾȥ "cabac" �ĵ�һ�� "c"�õ� "abac"�� 
		str2 = "cab" �� "cabac" ��һ���Ӵ�����Ϊ���ǿ���ɾȥ "cabac" ĩβ�� "ac" �õ� "cab"��
		�������Ǹ����Ĵ��������������Ե�����ַ����� 
	
	��ʾ��	
		1 <= str1.length, str2.length <= 1000
		str1 �� str2 ����СдӢ����ĸ��ɡ�
 */
//1092. ��̹���������
public class ShortestCommonSupersequence {
	public static void main(String[] args) {
		new ShortestCommonSupersequence().shortestCommonSupersequence2("abac", "cab");
	}
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0;i<m;i++) {
        	for(int j = 0;j<n;j++) {
        		dp[i+1][j+1] = 
        				str1.charAt(i)==str2.charAt(j)
        				?dp[i][j]+1
        				:Math.max(dp[i][j+1], dp[i+1][j]);
        	}
        }
        
        String res = "";
        int i = m;
        int j = n;
        int len = dp[m][n];
        
        while(len>0) {
        	while(dp[i][j]==len) {
        		res += str1.charAt(--i);
        	}
        	i++;
        	res  = res.substring(0, res.length()-1);
        	while(dp[i][j]==len) {
        		res += str2.charAt(--j);
        	}
        	i--;
        	len--;        	
        }
        while(i>0)res+=str1.charAt(--i);
        while(j>0)res+=str2.charAt(--j);
        res = new StringBuilder(res).reverse().toString();
        return res;
    }
    public String shortestCommonSupersequence2(String str1, String str2) {
        int len1=str1.length();
        int len2=str2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=len1,j=len2;i>0||j>0;){
            if(i<=0){
            	//ֻʣ��str2
                sb.append(str2.charAt(--j));
            }else if(j<=0){
            	//ֻʣ��str1
                sb.append(str1.charAt(--i));
            }else if(dp[i][j]>dp[i-1][j]&&dp[i][j]>dp[i][j-1]){
            	//str1.i��str2.j��ͬ
                sb.append(str1.charAt(--i));
                --j;
            }else if(dp[i][j]>dp[i-1][j]){
            	//dp[i][j]=dp[i][j-1]  -> str1.i��str2.j-1��ͬ
                sb.append(str2.charAt(--j));
            }else{
            	//dp[i][j]=dp[i-1][j]  -> str1.i-1��str2.j��ͬ
                sb.append(str1.charAt(--i));
            }
        }
        return sb.reverse().toString();
    }
    
}
