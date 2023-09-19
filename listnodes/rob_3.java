import java.util.HashMap;

public class rob_3 {
    public int rob(TreeNode root){
        return Math.max(rob_root(root,new HashMap<>(),new HashMap<>(),0),rob_root(root,new HashMap<>(),new HashMap<>(),1));
    }
    public int rob_root(TreeNode root, HashMap<TreeNode,Integer> store_rob,HashMap<TreeNode,Integer>store_not_rob,int standard){
        if(root==null){
            return 0;
       }
        if(root.left==null&&root.right==null){
            if(standard==0){
            return root.val;}
            else{
                return 0;
            }
        }
        if(standard==0){
            if(store_rob.containsKey(root)){
                return store_rob.get(root);
            }
            else{
                int result=root.val+rob_root(root.left,store_rob,store_not_rob,1)+rob_root(root.right,store_rob,store_not_rob,1);
                store_rob.put(root,result);
                return result;
            }
        }
        else{
            if(store_not_rob.containsKey(root)){
                return store_not_rob.get(root);
            }
            int max_left=Math.max(rob_root(root.left,store_rob,store_not_rob,1),rob_root(root.left,store_rob,store_not_rob
            ,0));
            int max_right=Math.max(rob_root(root.right,store_rob,store_not_rob,1),rob_root(root.right,store_rob,store_not_rob
                    ,0));
            store_not_rob.put(root,max_left+max_right);
            return max_left+max_right;
        }
    }//standard=0:偷该节点；standard=1,该根节点不偷
}
