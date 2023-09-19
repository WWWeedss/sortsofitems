import java.util.ArrayList;
import java.util.List;

public class CombinationSum_1 {
    public List<List<Integer>>combinationSum(int[]candidates,int target){
        List<List<Integer>>result=new ArrayList<>();
        dfs(result,candidates,target,0,new ArrayList<>());
        return result;
    }
    public void dfs(List<List<Integer>>result,int []candidates,int target,int index,List<Integer>combination_now){
        if(index>=candidates.length){
            return;
        }
        if(target==0){
            result.add(combination_now);
            return;
        }
        if(target<0){
            return;
        }
        List<Integer> temp_store = new ArrayList<>(combination_now);
        combination_now.add(candidates[index]);
        dfs(result,candidates,target-candidates[index],index,combination_now);
        dfs(result,candidates,target,index+1,temp_store);
    }
}
