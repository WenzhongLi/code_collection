package leetcode_google;

import java.util.HashMap;
import java.util.*;

public class OA_1 {
    public int getMinDiff(int[] list){
        if(list.length == 0){
            return 0;
        }
        if(list.length == 1){
            return list[0];
        }
        int sum = 0;
        for (int num: list){
            sum += num;
        }
        int min = Math.abs(sum)/2;
        HashMap<Integer,Boolean> DP = new  HashMap<Integer,Boolean>();
        for(int num : list){
            if(Math.abs(sum/2 - num) < min){
                min = sum/2 - num;
            }
            List<Integer> add=new ArrayList<Integer>();
            for(Integer i : DP.keySet()){
                int current = num + i;
                if((Math.abs(sum/2 - current) < min)){
                    min = sum/2 - current;
                }
                add.add(current);
            }
            DP.put(num,true);
            for (int index = 0;index<add.size(); index++){
                DP.put(add.get(index),true);
            }
        }
        return Math.abs((sum - (sum/2 - min)) - (sum/2 - min));
    }
    public static void main(String[] args){
        OA_1 a = new OA_1();
        int[] list = {-11,-10,20000};
        System.out.println(a.getMinDiff(list));
    }
//    public static void main(String[] args) {
//        OA_1 a = new OA_1();
//        int[] nums= new int[]{1,4,5,9,14};
//        System.out.println(a.getMinDiff(nums));
//    }
//    public static int getMinDiff(int[] nums){
//        int sum=0;
//        for (int n: nums) sum+=n;
//        int max=sum/2;
//        boolean[] dp= new boolean[max+1];
//        dp[0]=true;
//        for (int n: nums){
//            for (int i=max; i-n>-1; i--){
//                dp[i]|=dp[i-n];
//            }
//        }
//        int i=max;
//        while (i>-1 && !dp[i]) i--;
//        System.out.println(sum+" "+Arrays.toString(dp));
//        return sum-2*i;
//    }

}
