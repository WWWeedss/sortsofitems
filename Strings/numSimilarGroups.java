import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class numSimilarGroups {
    static int[]f;
    public static int numSimilarGroups_1(String[] strs){
        f=new int[strs.length];
        for(int i=0;i<strs.length;i++){
            f[i]=i;
        }
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                int fi=find(i);
                int fj=find(j);
                if(fi==fj){
                    continue;
                }
                if(is_similar(strs[i],strs[j])){
                    f[fi]=fj;
                }
            }
        }
        int count=0;
        for(int i=0;i<f.length;i++){
            if(f[i]==i){
                count++;
            }
        }
        return count;
    }
    public static int find(int x){
        return f[x]==x?x:(find(f[x]));
    }
    public static boolean is_similar(String a,String b){
        List<Integer>store_index=new ArrayList<>();
        if(a.length()!=b.length()){
            return false;
        }
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                store_index.add(i);
                if(store_index.size()>2){
                    return false;
                }
            }
        }
        if(store_index.size()==0){
            return true;
        }
        if(store_index.size()==1){
            return false;
        }
        else{
            int index1=store_index.get(0);
            int index2=store_index.get(1);
            return a.charAt(index1) == b.charAt(index2) && a.charAt(index2) == b.charAt(index1);
        }
    }
    public static void main(String[]args){
        String[]hello={"omv","ovm"};
        System.out.println(numSimilarGroups_1(hello));
    }
}
