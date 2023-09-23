import java.util.Arrays;

public class collectcoins_in_two_steps {
    public static int collectTheCoins(int[]coins,int[][]edges){
        int n=coins.length;
        int[] counts=new int[n];//算每个节点的度数
        int[] store_index=new int[n];//store[i]存的是：edge数组中出现i节点的最后一个index
        int number_leaves=n;
        int useless_leaves=0;
        do {
            Arrays.fill(counts, 0);
            Arrays.fill(store_index, 0);
            for (int i = 0; i < n - 1; i++) {
                if (edges[i][0] == -1) {
                    continue;
                }
                counts[edges[i][0]]++;
                counts[edges[i][1]]++;
                store_index[edges[i][0]] = i;
                store_index[edges[i][1]] = i;
            }
            useless_leaves = 0;
            for (int i = 0; i < n; i++) {
                if (coins[i] == 0 && counts[i] == 1) {
                    n--;
                    coins[i]=-1;
                    useless_leaves++;
                    edges[store_index[i]][0] = -1;
                }
            }
        } while (useless_leaves != 0);//剩下的叶子节点就都是有钱的节点
        Arrays.fill(counts, 0);
        Arrays.fill(store_index, 0);
        for (int i = 0; i < n - 1; i++) {
            if (edges[i][0] == -1) {
                continue;
            }
            counts[edges[i][0]]++;
            counts[edges[i][1]]++;
            store_index[edges[i][0]] = i;
            store_index[edges[i][1]] = i;
        }
        for(int i=0;i<n;i++){
            if(counts[i]==1){
                number_leaves--;
                edges[store_index[i]][0]=-1;
                coins[i]=-1;
            }
        }//删除一次叶子节点

        Arrays.fill(counts, 0);
        Arrays.fill(store_index, 0);
        for (int i = 0; i < n - 1; i++) {
            if (edges[i][0] == -1) {
                continue;
            }
            counts[edges[i][0]]++;
            counts[edges[i][1]]++;
            store_index[edges[i][0]] = i;
            store_index[edges[i][1]] = i;
        }
        for(int i=0;i<n;i++){
            if(counts[i]==1){
                number_leaves--;
                edges[store_index[i]][0]=-1;
                coins[i]=-1;
            }
        }//删除两次叶子节点
        return 2*(number_leaves-1);
    }

}
