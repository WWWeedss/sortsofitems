public class longestPalindrome {
    public int longest_Palindrome(String s){
         int[][]store=new int[s.length()][s.length()];
         for(int i=0;i<s.length();i++){
             store[i][i]=1;
         }
         for(int i=s.length()-1;i>=0;i--){
             for(int j=i+1;j<s.length();j++){
                 if(s.charAt(i)==s.charAt(j)){
                     store[i][j]=store[i+1][j-1]+2;
                 }
                 else{
                     store[i][j]=Math.max(store[i][j-1],store[i+1][j]);
                 }
             }
         }
         return store[0][s.length()-1];
    }
}
