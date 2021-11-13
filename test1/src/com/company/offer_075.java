package com.company;

import java.util.Collection;
import java.util.HashMap;

public class offer_075 {
    public static void main(String[] args) {
        int []arr1 = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, arr2 = new int[]{2,42,38,0,43,21};
        int[] ints = relativeSortArray(arr1, arr2);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]);
        }

    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int ints[]=new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            hashMap.put(arr1[i],hashMap.getOrDefault(arr1[i],0)+1);
        }
        int j=0;
        for(int i=0;i<arr2.length;i++){
            Integer counts = hashMap.get(arr2[i]);
                while (j<ints.length&&counts>0){
                    ints[j]=arr2[i];//
                    counts--;
                    hashMap.put(arr2[i],counts);//将hashmap对应的valueg归0 方便找到将没有出现在arr2的值
                    j++;
            }

        }
        int[] temp=new int[arr1.length];
        int temp1=0,temp2=0;
        int max=Integer.MIN_VALUE;
        int k=0;
        for(int i=j;i<ints.length;){
            int flag=0;
            for (Integer item:hashMap.keySet()) {
                if(hashMap.get(item)!=0){
                    Integer integer = hashMap.get(item);
                    while (integer>0){
                        temp[k++]=item;
                        integer--;

                    }

                }
            }
            //数组排序
            int Temp=0;
            for(int m=0;m<k;m++){
                for(int s=0;s<k-m;s++){
                        if(temp[s]>temp[s+1]){
                            Temp= temp[s];
                            temp[s]=temp[s+1];
                            temp[s+1]=Temp;
                        }
                        //ints[i++]=temp[m];
                }
            }
            for(int p=1;p<=k;p++){
                ints[i++]=temp[p];
            }
            break;
        }

        return ints;
    }
}
