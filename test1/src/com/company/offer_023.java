package com.company;

import java.util.Scanner;

public class offer_023 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        offer_023 o=new offer_023();
        String s = input.nextLine();
        String s1 = input.nextLine();
        String[] split = s.split(" ");
        String[] split1 = s1.split(" ");
        ListNode head=o.new ListNode(Integer.parseInt(split[0]));
        ListNode head1=o.new ListNode(Integer.parseInt(split1[0]));
        ListNode p=head;
        ListNode q=head1;
        for(int i=1;i<split.length;i++){
            int temp=Integer.parseInt(split[i]);
            p.next = o.new ListNode(temp);
            p=p.next;
        }
        for(int i=1;i<split1.length;i++){
            int temp=Integer.parseInt(split1[i]);
            q.next = o.new ListNode(temp);
            q=q.next;
        }
        ListNode intersectionNode = getIntersectionNode(head, head1);

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        offer_023 o=new offer_023();
        ListNode re = o.new ListNode();
        while (headA!=headB){
            headA=headA!=null?headA.next:tempB;
            headB=headB!=null?headB.next:tempA;
        }
        return headA;
    }
}
