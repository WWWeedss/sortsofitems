import java.util.HashSet;

public class hasAllCodes {
    public static boolean hasAllCode(String s,int k){
        HashSet<String>store=new HashSet<>();
        for(int i=k;i<=s.length();i++){
            store.add(s.substring(i-k,i));
        }
        if(store.size()==Math.pow(2,k)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[]args){


    }}
