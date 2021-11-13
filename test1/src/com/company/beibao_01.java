package com.company;

public class beibao_01 {
    public static int C=20,N=5;
    public static int[][] arr=new int[N+1][C+1];
    public static void main(String[] args) {

        int[] arr1=new int[]{0,2,3,4,5,9};//物品重量
        int[] arr2=new int[]{0,3,4,5,8,10};//物品价值
        int beibao = beibao(arr1,arr2);

       System.out.println(beibao);
    }
    public static int beibao(int[] arr1,int[] arr2){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=C;j++){
                if(arr1[i]>j){//装不下 ：当前物品重量大于当前背包容量
                    arr[i][j]=arr[i-1][j];
                }else{
                    arr[i][j]=Math.max(arr[i-1][j],arr[i-1][j-arr1[i]]+arr2[i]);
                }
            }
        }
        return arr[N][C];
    }
}
