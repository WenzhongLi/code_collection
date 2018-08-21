package leetcode_google;

import java.util.TreeSet;

public class heaters_475 {
    public int findRadius(int[] houses, int[] heaters) {
        int n=houses.length;
        TreeSet<Integer> set= new TreeSet<>();
        for (int s: heaters) {
            set.add(s);
        }
        //int[] result= new int[n];
        int result = 0;
        for (int i=0; i<n; i++){
            int h= houses[i];
            Integer lo= set.floor(h), hi=set.ceiling(h);
            int left= lo==null?Integer.MAX_VALUE: h-lo, right= hi==null?Integer.MAX_VALUE: hi-h;
            int current = 0;
            if (left<=right) {
                current = left;
            }
            else
                current = right;
            if (current > result){
                result = current;
            }
        }
        return result;
    }
    public static void main(String[] args){
        heaters_475 a = new heaters_475();
        int[] house = {};
        int[] heater = {};
        System.out.print(a.findRadius(house, heater));
    }
}
