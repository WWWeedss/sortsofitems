public class longestPalindrome_substring {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(dp[i+1][j-1]==1&&s.charAt(i)==s.charAt(j)){
                    dp[i][j]=1;
                }
            }
        }
        int left=0;
        int right=0;
        int result_length=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
             if(j-i+1>result_length&&dp[i][j]==1){
                 result_length=j-i+1;
                 left=i;
                 right=j;
             }
            }
        }
        return s.substring(left,right+1);
    }
}
