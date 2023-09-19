import java.util.Arrays;

public class singleNumbers {
    public static int[] single(int[] nums){
        Arrays.sort(nums);
        int[]result=new int[2];
        int head=0;
        for(int i=0;i<nums.length;i++ ){
            if(i==0){
                if(nums[i]!=nums[i+1]){
                    result[head]=nums[i];
                    head++;
                }
            }
            if(i==nums.length-1){
                if(nums[i]!=nums[i-1]){
                    result[head]=nums[i];
                }
            }
            else{
                if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                    result[head]=nums[i];
                    head++;
                }
            }
        }
        return result;
    }
}
