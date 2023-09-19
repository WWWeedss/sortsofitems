import java.util.Arrays;

public class rob_4_binarySearch {
    public static int minCapability(int []nums,int k){
        int upper= Arrays.stream(nums).max().getAsInt();
        int lower=Arrays.stream(nums).min().getAsInt();
      int middle=0;
        while(lower<=upper){
            middle=(upper+lower)/2;
            int temp=can_visit(nums,middle);
            if(temp>=k){
                upper=middle-1;
            }
            if(temp<k){
                lower=middle+1;
            }
        }
        return lower;
    }
    public static int can_visit(int[]nums,int x){
        boolean visited=false;
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=x&&!visited){
                result++;
                visited=true;
            }
            else{
                visited=false;
            }
        }
        return result;
    }
}
