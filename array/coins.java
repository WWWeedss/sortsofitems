public class coins {
    public int minCount(int[] coins){
        int result=0;
        for(int i=0;i<coins.length;i++){
            result+=(coins[i]+1)/2;
        }
        return result;
    }
}
