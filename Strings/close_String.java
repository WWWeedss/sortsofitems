import java.util.*;

public class close_String {
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        HashSet<Character>char_1=new HashSet<>();
        HashSet<Character>char_2=new HashSet<>();
        ArrayList<Integer> int_1=new ArrayList<>();
        ArrayList<Integer> int_2=new ArrayList<>();
        fill(char_1,int_1,word1);
        fill(char_2,int_2,word2);
        if(char_1.size()!=char_2.size()){
            return false;
        }
        int size=char_1.size();
        char_1.addAll(char_2);
        if(char_1.size()!=size){
            return false;
        }
        return judge(int_1,int_2);
    }
    public static void fill(HashSet<Character>characters,ArrayList<Integer>integers,String word) {
        int[] bucket = new int[130];
        for (int i = 0; i < word.length(); i++) {
            bucket[word.charAt(i)]++;
        }
        for(int i='A';i<='z';i++){
            if(bucket[i]!=0){
                characters.add((char)i);
                integers.add(bucket[i]);
            }
        }
    }
    public static boolean judge(ArrayList<Integer>list1,ArrayList<Integer>list2){
     list1.sort(new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
             return o1-o2;
         }
     });
     list2.sort(new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
             return o1-o2;
         }
     });
     for(int i=0;i<list1.size();i++){
         if(!Objects.equals(list1.get(i), list2.get(i))){
             return false;
         }
     }
      return true;
    }
    public static void main(String[]args){
        System.out.println(closeStrings("abbzccca", "babzzczc"));
    }
}
