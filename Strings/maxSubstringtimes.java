import java.util.*;

public class maxSubstringtimes {
    class Substring{
        int times;
        String value;
        Substring(int times,String value){
            this.times=times;
            this.value=value;
        }
    }
 public int maxFreq(String s, int maxLetters, int minSize, int maxSize){
      HashMap<String,Integer>store=new HashMap<>();
      ArrayList<Substring>wait_to_sort=new ArrayList<>();
            for(int j=0;j+minSize<=s.length();j++){
                String temp=s.substring(j,j+minSize);
                if(store.containsKey(temp)){
                    int pre_time=store.get(temp);
                    store.put(temp,pre_time+1);
                }
                else{
                    store.put(temp,1);
                }
            }
        for(Map.Entry<String,Integer>entry:store.entrySet()){
            Substring hello= new Substring(entry.getValue(),entry.getKey());
            wait_to_sort.add(hello);
        }
     wait_to_sort.sort(new Comparator<Substring>() {
         @Override
         public int compare(Substring o1, Substring o2) {
             return o2.times-o1.times;
         }
     });
     for (Substring substring : wait_to_sort) {
         if (count_different(substring.value) <= maxLetters) {
             return substring.times;
         }
     }
        return 0;
 }
 public static int count_different(String s){
        HashSet<Character>count=new HashSet<>();
        for(int i=0;i<s.length();i++){
            count.add(s.charAt(i));
        }
        return count.size();
 }
 public static void main(String[]args){

 }
}
