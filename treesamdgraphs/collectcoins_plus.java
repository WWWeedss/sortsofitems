import java.util.ArrayDeque;
import java.util.Queue;

public class collectcoins_plus {
   public static int collectcoins_p(int []coins,int[][]edges){
       int n=coins.length;
       int number_leaves=n;
       int[]counts=new int[n];
       int zero_index=-1;
       Queue<Integer>leaves=new ArrayDeque<>();
       for(int i=1;i<n;i++){
           counts[i]=1;
       }
       for(int i=0;i<n-1;i++){
           counts[edges[i][0]]++;
           if(edges[i][0]==0){
               zero_index=i;
           }
       }
       int useless_leaves=0;
       do{
           useless_leaves=0;
       for(int i=0;i<n;i++){
           if(counts[i]==1&&coins[i]==0){
               useless_leaves++;
               number_leaves--;
               if(i==0){
                   counts[zero_index+1]--;
               }
               counts[i]--;
               counts[edges[i+1][0]]--;
           }
       }
       }while(useless_leaves!=0);
       for(int i=0;i<n;i++){
           if(counts[i]==1){

           }
       }
   }
}
