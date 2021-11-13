package com.company;

public class offer_101 {
    public static void main(String[] args) {
        int[]arr=new int[]{1,5,11,5};
        boolean b = canPartition(arr);
        System.out.println(b);
    }
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int C=sum/2;
        int[][] arr=new int[nums.length+1][C+1];
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=C;j++){
                if(j<nums[i-1]){
                    arr[i][j]=arr[i-1][j];
                }else{
                    arr[i][j]=Math.max(arr[i-1][j],arr[i-1][j-nums[i-1]]+nums[i-1]);
                }
            }
        }
        return arr[nums.length][C]==C;
    }
}
