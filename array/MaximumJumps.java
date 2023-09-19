//dp
public class MaximumJumps {
    public static int maxiMumJumps(int[] nums,int target){
        int[] store=new int[nums.length];
        return maxiMumJumps_1(nums, target,0,store,0,0);
    }
    public static int maxiMumJumps_1(int[] nums,int target,int start,int[] store,int step_now,int repeat){
       if(store[start]==-1){
           return -1;
       }
        if(store[start]!=0){
            return store[start]+step_now;
        }
        int temp=repeat;
        int index=0;
        for(int i=start+1;i<nums.length;i++){
            if(nums[i]-nums[start]>=-target&&nums[i]-nums[start]<=target){
                temp--;
                if(temp==-1){
                index=i;
                break;
                }
            }
        }
        if(index==0){
            return -1;
        }
        if(index==nums.length-1){
            return step_now+1;
        }
        int take_it=maxiMumJumps_1(nums,target,index,store,step_now+1,0);
        int not_take=maxiMumJumps_1(nums,target,start,store,step_now,repeat+1);
        int take_it_1=maxiMumJumps_1(nums,target,index,store,1,0);
        int not_take_1=maxiMumJumps_1(nums,target,start,store,0,repeat+1);
        store[start]=Math.max(take_it_1,not_take_1);
        return Math.max(take_it,not_take);
    }
    public static void main(String[] args){
        int[]nums={221902473,320552703,857586616,-199870060,-259590354,-46454815,850144395,218211184,-145933128,296964897};
        System.out.println(maxiMumJumps(nums,442898025))
        ;
    }
}
