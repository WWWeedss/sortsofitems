public class getIntersectionNode_Plus {
    public ListNode get(ListNode headA,ListNode headB){
        if(headA==null||headB==null){
            return null;
        }
       ListNode tailA=headA;
       ListNode tailB=headB;
       while(tailA!=tailB){
          tailA=tailA==null?headB:tailA.next;
          tailB=tailB==null?headA:tailB.next;
       }
       return tailA;
    }//如果A走完了，就让他走B，B走完了，就让她走A，两个指针都走完了A+B，所以最后是同时到达的，
    // 而两个指针必定会在结合处相遇，如果没有结合处则不会相遇,而是都变为null。
}
