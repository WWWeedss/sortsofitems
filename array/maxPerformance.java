import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class maxPerformance {
    class Staff{
        int speed,efficiency;
        public Staff(int s, int e){
            speed=s;
            efficiency=e;
        }
    }
    public int find(int n, int[] speed, int[] efficiency, int k){
        final int MOD = 1000000007;
        Staff[]sort_1=new Staff[n];
        for(int i=0;i<n;i++){
            sort_1[i]=new Staff(speed[i],efficiency[i]);
        }
        PriorityQueue<Staff>queue=new PriorityQueue<>(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.speed-o2.speed;
            }
        });
        Arrays.sort(sort_1,(x1,x2)->x2.efficiency-x1.efficiency);
        for(int i=0;i<n;i++){
            System.out.println(sort_1[i].efficiency);
        }
        long ans=0,sum=0;
        for(int i=0;i<n;i++){
            long minE=sort_1[i].efficiency;
            long sum_S=sum+sort_1[i].speed;
            sum+=sort_1[i].speed;
            ans=Math.max(ans,minE*sum_S);
            queue.offer(sort_1[i]);
            if(queue.size()==k){
                sum-= Objects.requireNonNull(queue.poll()).speed;
            }
        }
        return (int)(ans%MOD);
    }
 public static void main(String[] args){
        int[] a={2,10,3,1,5,8};
        int[] b={5,4,3,9,7,2};
        new maxPerformance().find(6,a,b,2);
 }
}
