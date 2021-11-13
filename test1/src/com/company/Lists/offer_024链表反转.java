package com.company.Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class offer_024链表反转 {
    public class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        offer_024链表反转 o=new offer_024链表反转();
        ArrayList<ListNode> listNodes=new ArrayList<>();
//        ListNode listNode = o.new ListNode();
// /*链表的输入*/
        String s = input.nextLine();
        String[] split = s.split(" ");
        ListNode head=o.new ListNode(Integer.parseInt(split[0]));
        ListNode p=head;
        for(int i=1;i<split.length;i++){
            int temp=Integer.parseInt(split[i]);
           p.next = o.new ListNode(temp);
           p=p.next;
        }
/*链表的输入*/
        System.out.println(split.length);
        /*链表的输出*/
        ListNode pre=head;
        while (head!=null){
            System.out.print(head.val);
            if(head.next!=null){
                System.out.print("-->");
            }

            head=head.next;
        }
        /*链表的输出*/
        ListNode listNode = reverseList(pre);
        while (listNode!=null){
            System.out.print(listNode.val);
            if(listNode.next!=null){
                System.out.print("-->");
            }
            listNode=listNode.next;
        }


    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        if((head==null)||(head.next==null)){
            return head;
        }
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;

    }
}
