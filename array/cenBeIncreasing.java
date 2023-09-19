public class cenBeIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        int count=0;
        int temp_index=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]<=nums[i]){
                count++;
                temp_index=i;
            }
        }
        if(count>1){
            return false;
        }
        else if(count==0){
            return true;
        }
        else{
         if(temp_index==nums.length-2||temp_index==0){
             return true;
         }
            return nums[temp_index - 1] < nums[temp_index + 1]||nums[temp_index]<nums[temp_index+2];
        }
    }
}
