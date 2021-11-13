package com.company.Lists;

import java.util.Scanner;

public class offer_025两个链表相加 {
    public class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        offer_025两个链表相加 o=new offer_025两个链表相加();
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

      ListNode listNode = addTwoNumbers(head, head1);
        while (listNode!=null){
            System.out.print(listNode.val);
            if(listNode.next!=null){
                System.out.print("-->");
            }
            listNode=listNode.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = reveserList(l1);
        ListNode listNode1 = reveserList(l2);
        offer_025两个链表相加 o=new offer_025两个链表相加();
        ListNode res=o.new ListNode();
        ListNode temp=res;
        int add=0,c=0;
        while (listNode!=null&&listNode1!=null){
            add = listNode.val + listNode1.val + c;
            c=add/10;
            add=add%10;
            res.next=o.new ListNode(add);
            res=res.next;
            listNode=listNode.next;
            listNode1=listNode1.next;
        }
        while (listNode!=null){
            add=listNode.val+c;
            c=add/10;
            add=add%10;
            res.next=o.new ListNode(add);
            res=res.next;
            listNode=listNode.next;
        }
        while (listNode1!=null){
            add=listNode1.val+c;
            c=add/10;
            add=add%10;
            res.next=o.new ListNode(add);
            res=res.next;
            listNode1=listNode1.next;
        }
        if(c!=0){
            res.val=add;
        }
        return temp.next;

    }
    public  static ListNode reveserList(ListNode head){
        ListNode pre=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;//指针反转指向
            pre=head;//pre向前走
            head=next;//l1向前走
        }
        return pre;
    }
}
