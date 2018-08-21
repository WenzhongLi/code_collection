package leetcode_google;

import java.util.*;

public class OA_2 {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        int[] stores= new int[]{1,3,8,60,5,27};
        int[] houses= new int[]{0,2,4,7,61,33,19};
        getClosest(stores, houses);
    }
    public static int[] getClosest(int[] stores, int[] houses){
        int n=houses.length;
        TreeSet<Integer> set= new TreeSet<>();
        for (int s: stores) set.add(s);
        int[] res= new int[n];
        for (int i=0; i<n; i++){
            int h= houses[i];
            Integer lo= set.floor(h), hi=set.ceiling(h);
            int left= lo==null?Integer.MAX_VALUE: h-lo, right= hi==null?Integer.MAX_VALUE: hi-h;
            if (left<=right) res[i]=lo;
            else res[i]=hi;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

}
