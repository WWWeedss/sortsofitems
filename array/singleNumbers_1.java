public class singleNumbers_1 {
       public static int[] single(int[]nums){
           int[] result=new int[2];
           int temp=0;
           for(int i:nums){
               temp ^=i;
           }
           int classify=1;
           while(true){
               if((classify&temp)==classify){
                   break;
               }
               else{
                   classify<<=1;
               }
           }
           int a=0,b=0;
           for(int i:nums){
               if((i&classify)==0){
                   a^=i;
               }
               else{
                   b^=i;
               }
           }
           result[0]=a;
           result[1]=b;
           return result;
       }
}
