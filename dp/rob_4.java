public class rob_4 {
    public static int minCapability(int[] nums,int k){
        return minCapability_dp(nums,k,0,new int[nums.length][k]);
    }
    public static int minCapability_dp(int []nums,int k,int index,int[][] store){
        if(k>0&&index>=nums.length){
            return Integer.MAX_VALUE;
        }
        if(k==1){
            int result=Integer.MAX_VALUE;
            for(int i=index;i<nums.length;i++){
                if(result>nums[i]){
                    result=nums[i];
                }
            }
            return result;

        }
        if(store[index][k-1]!=0){
            return store[index][k-1];
        }
        int rob_result=Math.max(nums[index],minCapability_dp(nums,k-1,index+2,store));
        int not_rob_result=minCapability_dp(nums,k,index+1,store);
        store[index][k-1]=Math.min(rob_result,not_rob_result);
        return Math.min(rob_result,not_rob_result);
    }
    public static void main(String[] args){
        System.out.print(minCapability(new int[]{7,3,9,5},2));
    }
}
