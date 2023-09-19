import java.util.Arrays;

public class maxiMumJumps_1 {
    public static int maxiMumJumps(int[]nums,int target){
        int[]store=new int[nums.length];
        Arrays.fill(store,-1);
        store[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(store[j]!=-1){
                    if(Math.abs(nums[i]-nums[j])<=target){
                        store[i]=Math.max(store[j]+1,store[i]);
                    }
                }
            }
        }
        return store[nums.length-1];
    }
}
