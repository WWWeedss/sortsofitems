public class MaxRepeating {
    public int maxRepeating(String sequence,String word){
        int result=0;
        int count_now=0;
        int index_now=0;
        index_now=sequence.indexOf(word);
        if(index_now==-1){
            return 0;
        }
        while(index_now<sequence.length()){
            if(sequence.indexOf(word,index_now)==index_now){
                count_now++;
                index_now+=word.length();
                if(index_now==sequence.length()){
                    return Math.max(result,count_now);
                }
            }
            else{
                result=Math.max(result,count_now);
                count_now=0;
                if(sequence.indexOf(word,index_now)==-1){
                    break;
                }
                index_now=sequence.indexOf(word,index_now-word.length()+1);
            }
        }
        return result;
    }
}
