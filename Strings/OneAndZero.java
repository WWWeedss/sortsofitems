public class OneAndZero {
    public static int findMaxForm(String[] strs,int m,int n){
        int[][][]store=new int[strs.length][m+1][n+1];
        return find_dp(strs,0,m,n,store);
    }
    public static int find_dp(String[] strs,int index,int m,int n,int[][][]store){
        if(index>=strs.length){
            return 0;
        }
        if(store[index][m][n]!=0){
            return store[index][m][n];
        }
        int[] count_zero_one=new int[2];
        count(count_zero_one,strs[index]);
        if(count_zero_one[0]>m||count_zero_one[1]>n){
            return find_dp(strs,index+1,m,n,store);
        }
        else{
            int get_now=find_dp(strs,index+1,m-count_zero_one[0],n-count_zero_one[1],store)+1;
            int not_get=find_dp(strs,index+1,m,n,store);
            store[index][m][n]=Math.max(get_now,not_get);
            return store[index][m][n];
        }
    }
    public static void count(int[]count,String target){
        int count_zero=0,count_one=0;
        for(int i=0;i<target.length();i++){
            if(target.charAt(i)=='0'){
                count_zero++;
            }
            else if(target.charAt(i)=='1'){
                count_one++;
            }
            else{
                continue;
            }
        }
        count[0]=count_zero;
        count[1]=count_one;
    }
}
