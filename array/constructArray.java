import java.util.Arrays;

public class constructArray {
    public static int[] construct(int n,int k){
        int[] result=new int[n];
        for(int i=0;i<n;i++){result[i]=i+1;}
        int count=0;
        while(k>1){
            if(k==2){
                int temp=result[n-1];
                result[n-1]=result[n-2];
                result[n-2]=temp;
                k--;
            }
            else{
                result[n-k]=n-count;
                fulfill_sort(result,n-k+1,n-k+1-count);
                k-=2;
                count++;
            }
        }
        return result;
    }
    public static void fulfill_sort(int[] nums,int start_index,int start_number){
        for(int i=start_index;i<nums.length;i++){
            nums[i]=start_number;
            start_number++;
        }
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(construct(3, 2)));
    }

}
