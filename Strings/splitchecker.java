import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class splitchecker {
    public static String[] spellchecker_1(String[] wordlist, String[] queries){
        HashSet<String>word_perfect=new HashSet<>();
        HashMap<String,String>word_case=new HashMap<>();
        HashMap<String,String>word_vowels=new HashMap<>();
        for(String s:wordlist){
            word_perfect.add(s);
            word_case.putIfAbsent(s.toLowerCase(),s);
            word_vowels.putIfAbsent(vary_now(s),s);
        }
        for(int i=0;i<queries.length;i++){
            if(word_perfect.contains(queries[i])){
                continue;
            }
            if(word_case.containsKey(queries[i].toLowerCase())){
                queries[i]=word_case.get(queries[i].toLowerCase());
                continue;
            }
            if(word_vowels.containsKey(vary_now(queries[i]))){
                queries[i]=word_vowels.get(vary_now(queries[i]));
                continue;
            }
            queries[i]="";
        }
        return queries;
    }
    public static String vary_now(String origin){
        origin=origin.toLowerCase();
        StringBuffer result=new StringBuffer();
            for(int i=0;i<origin.length();i++){
                if(isVowel(origin.charAt(i))){
                    result.append('a');
                }
                else{
                    result.append(origin.charAt(i));
                }
            }
            return result.toString();
    }
    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[]args){
        String[]a={"KiTe"};
        String[]b={"keet"};
        System.out.println(Arrays.toString(spellchecker_1(a, b)));
    }
}
