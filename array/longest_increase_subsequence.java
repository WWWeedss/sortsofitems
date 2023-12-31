import java.util.Arrays;

public class longest_increase_subsequence {
    public int lengthOfLis(int []nums){
        int[]dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        return find_max(dp);
    }
    public static int find_max(int[]x){
        int result=0;
        for(int i=0;i<x.length;i++){
            if(result<x[i]){
                result=x[i];
            }
        }
        return result;
    }
}
