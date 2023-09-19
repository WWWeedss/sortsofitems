public class MagicDictionary {
    String[]store;
    /** Initialize your data structure here. */
    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
store=dictionary;
    }

    public boolean search(String searchWord) {
        for(int i=0;i<store.length;i++){
        if(store[i].length()!=searchWord.length()){
            continue;
        }
        else{
            if(judge_different(searchWord,store[i])==1){
                return true;
            }
        }
        }
        return false;
    }
    public static int judge_different(String a,String b){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
