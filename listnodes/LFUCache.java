import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;

public class LFUCache {
    int capacity;
    int minFrequency;
    public static class value_node{
        int value;
        int cnt;
    }

    HashMap<Integer,value_node>key_to_node;
    HashMap<Integer, LinkedHashSet<Integer>>f_k_list;
    public LFUCache(int capacity) {
        minFrequency=0;
        this.capacity=capacity;
        key_to_node=new HashMap<>();
        f_k_list=new HashMap<>();
    }

    public int get(int key) {
        if(key_to_node.containsKey(key)){
            increase_fre(key);
            return key_to_node.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(key_to_node.containsKey(key)){
            key_to_node.get(key).value=value;
            increase_fre(key);
        }
        else{
            if(key_to_node.size()+1>capacity){
                remove_oldest();
            }
            value_node temp=new value_node();
            temp.value=value;
            temp.cnt=1;
            key_to_node.put(key,temp);
            f_k_list.putIfAbsent(1,new LinkedHashSet<>());
            f_k_list.get(1).add(key);
            this.minFrequency=1;
        }
    }
    public void increase_fre(int key){
        value_node temp=key_to_node.get(key);
        temp.cnt++;
        f_k_list.putIfAbsent(temp.cnt,new LinkedHashSet<>());
        f_k_list.get(temp.cnt).add(key);
        f_k_list.get(temp.cnt-1).remove(key);
        if(f_k_list.get(temp.cnt - 1).isEmpty() &&temp.cnt-1==minFrequency){
            minFrequency++;
        }
    }
    public void remove_oldest(){
        int to_delete=f_k_list.get(minFrequency).iterator().next();
        f_k_list.get(minFrequency).remove(to_delete);
        key_to_node.remove(to_delete);
    }
}
