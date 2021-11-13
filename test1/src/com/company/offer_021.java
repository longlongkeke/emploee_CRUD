package com.company;

import java.util.Scanner;

public class offer_021 {
    public class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        offer_021 o=new offer_021();
        String s = input.nextLine();
        String[] split = s.split(" ");
        ListNode head=o.new ListNode(Integer.parseInt(split[0]));
        ListNode p=head;
        for(int i=1;i<split.length;i++){
            int temp=Integer.parseInt(split[i]);
            p.next = o.new ListNode(temp);
            p=p.next;
        }

        ListNode listNode = removeNthFromEnd(head,1);
        ListNode pre=listNode;
        while (head!=null){
            System.out.print(head.val);
            if(head.next!=null){
                System.out.print("-->");
            }

            head=head.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode temp=head;
        ListNode re=head;
        ListNode nu=null;
        while(head!=null){
            count++;
            head=head.next;
        }
        if(count==1){
            return nu;
        }

        for(int i=0;i<count-n-1;i++){
            temp=temp.next;
        }

        if(temp==re){
            re=re.next;
            return re;
        }
        if(count==2&&n==1){
            re.next=null;
            return re;
        }

        ListNode temp2=temp;//存储被删结点的前一个结点
        temp=temp.next;
        ListNode temp1=temp.next;//存储被删结点的下一个结点
        temp2.next=temp1;
        return re;


    }
}