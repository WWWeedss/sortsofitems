import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class merge_plus {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head_result=new ListNode();
        ListNode tail_result=head_result;
        List<ListNode>heads=new ArrayList<>();
        for (ListNode list : lists) {
            if (list != null) {
                heads.add(list);
            }
        }
        if(heads.size()==0){
            return null;
        }
        PriorityQueue<ListNode>mini=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        mini.addAll(heads);
        ListNode  temp1=mini.poll();
        head_result=temp1;
        tail_result=temp1;
        if(temp1.next!=null){
            mini.add(temp1.next);
        }
        while(mini.size()!=0){
            ListNode temp=mini.poll();
            tail_result.next=temp;
            tail_result=tail_result.next;
            if(temp.next!=null){
            mini.add(temp.next);}
        }
        return head_result;
    }
}
