package leetcode_google;

import java.util.*;

public class DailyTemperatures_739 {
//    public int[] dailyTemperatures(int[] temperatures) {
//        HashMap<Integer,Integer> list = new HashMap<Integer,Integer>();
//        int[] result = new int[temperatures.length];
//        for(int i = 0;i<temperatures.length;i++ ){
//            List<Integer> remove = new ArrayList<Integer>();
//            for (Integer index : list.keySet()){
//                if(list.get(index) < temperatures[i]){
//                    remove.add(index);
//                    result[index] = i - index;
//                }
//            }
//            for(int j =0 ; j<remove.size();j++){
//                list.remove(remove.get(j));
//            }
//            list.put(i,temperatures[i]);
//
//        }
//        return result;
//    }// OT
    public int[] dailyTemperatures(int[] temperatures) {
        int[] list = new int[temperatures.length];
        int top = -1;
        int[] result = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++ ){
            while(top >= 0 && temperatures[i] > temperatures[list[top]]){
                result[list[top]] = i - list[top];
                top--;
            }
            top++;
            list[top] = i;
        }
        return result;
    }
    public static void main(String[] args){
        DailyTemperatures_739 a = new DailyTemperatures_739();
        int[] tp= {73, 74, 75, 71, 69, 72, 76, 73};
        a.dailyTemperatures(tp);
    }
}
