import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class getIntersectionNode {
    public ListNode getInter_sectionNode(ListNode headA,ListNode headB) {
        HashSet<ListNode>A=new HashSet<>();
        if(headA==null||headB==null){
            return null;
        }
        ListNode tailA=headA;
        while(tailA!=null){
            A.add(tailA);
            tailA=tailA.next;
        }
        ListNode tailB=headB;
        while(tailB!=null){
            if(A.contains(tailB)){
                return tailB;
            }
            tailB=tailB.next;
        }
        return null;
        }
    }
