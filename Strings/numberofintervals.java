import java.util.ArrayList;
import java.util.List;

public class numberofintervals {
    public static int numberOfways(String corridor){
        int chairs_now=0;
        long result=1;
        int left = 0,right=0;
        List<Integer> store=new ArrayList<>();
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                chairs_now++;
            }
        }
        if(chairs_now%2==1||chairs_now==0){
            return 0;
        }
        else if(chairs_now==2){
            return 1;
        }
        chairs_now=0;
        for(int i =0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                chairs_now++;
            }
            if(chairs_now==2){
                left=i+1;
                break;
            }
        }
        chairs_now=0;
        for(int i=corridor.length()-1;i>=0;i--){
            if(corridor.charAt(i)=='S'){
                chairs_now++;
            }
            if(chairs_now==2){
                right=i-1;
                break;
            }
        }
        String corridor_1=corridor.substring(left,right+1);
        chairs_now=0;
        int plants_now=0;
        for(int i=0;i<corridor_1.length();i++){
            if(corridor_1.charAt(i)=='S'){
                chairs_now++;
            }
            if(chairs_now==0&&corridor_1.charAt(i)=='P'){
                plants_now++;
            }
            if(chairs_now==2){
                chairs_now=0;
                store.add(plants_now+1);
                plants_now=0;
            }
        }
        store.add(plants_now+1);
        for (Integer integer : store) {
            result = (long) ((result * integer) % 1000000007);
        }
        return (int)result;
    }
}
