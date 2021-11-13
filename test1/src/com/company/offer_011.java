package com.company;

import java.util.HashMap;

public class offer_011 {
    public static void main(String[] args) {
        int []nums =new int[]{0,0,1,0,0,0,1,1};//-1,-1,1,-1,-1,-1,1,1
        int maxLength = findMaxLength(nums);
        System.out.println(maxLength);
    }
//    public static int findMaxLength(int[] nums) {    //-1 0  -2 1 -1 2  -2 3 -3 4  -4 5 -3 6 -2 7
//        int len=0,max=0;
//        for(int k=0;k<nums.length;k++){
//            if(nums[k]==0) nums[k]=-1;
//        }
//       for(int i=0;i<nums.length;i++){
//            int sum=0;
//           for(int j=i+1;j<nums.length;j+=2){
//               if(j==1){
//                   sum+=nums[j]+nums[i];
//               }else{
//                   sum+=nums[j-1]+nums[j];
//               }
//               if(sum==0){
//                   len=j-i+1;
//                   if(len>max) max=len;
//               }
//
//           }
//       }
//       return max;
//    }//时间复杂度n的三次方
    public static int findMaxLength(int[] nums) {
        int sum=0,len=0,max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
//        for(int j=0;j<nums.length;j++){
//            if(nums[j]==0) nums[j]=-1;
//        }
        for(int i=0;i<nums.length;i++){

//            if(i%2==0) {
//                sum += nums[i]==0 ? -1:1;
//                continue;
//            }
            sum += nums[i]==0 ? -1:1;
            if(map.containsKey(sum-0)){
                Integer integer = map.get(sum - 0);
                //len=i-integer;
//                if(len>max) max=len;
                max = Math.max(max, i - map.get(sum-0));
            }else{
                map.put(sum,i);
            }

        }
        return max;

    }
}

