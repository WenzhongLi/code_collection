package leetcode_google;

import java.util.ArrayList;
import java.util.List;

public class QueueReconstructionbyHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0){
            return new int[0][0];
        }
        quickSort(people, 0, people.length - 1);
        List<Integer> resultOrder = new ArrayList<Integer>();
        for(int i = 0;i < people.length;i++){
            boolean addNum = true;
            for(int j = 0, count = 0, num = people[i][0], goal = people[i][1];j < resultOrder.size(); j++){
                if(count == goal){
                    resultOrder.add(j,i);
                    addNum = false;
                    break;
                }
                if(people[resultOrder.get(j)][0] >= num){
                    count++;
                }
            }
            if(addNum){
                resultOrder.add(i);
            }
        }
        int[][] result = new int[people.length][2];
        for(int i = 0;i< people.length;i++){
            result[i][0] = people[resultOrder.get(i)][0];
            result[i][1] = people[resultOrder.get(i)][1];
        }
        return result;
    }
    public  void quickSort(int[][] array, int start, int end){
        if(start >= end){
            return;
        }
        int i = start, j = end, current = start;
        int[] temp = new int[2];
        while(i<j){
            while(current < j){
                if(array[current][0] < array[j][0] || (array[current][0] == array[j][0] && array[current][1] > array[j][1]) ){
                    temp[0] = array[current][0];
                    temp[1] = array[current][1];
                    array[current][0] = array[j][0];
                    array[current][1] = array[j][1];
                    array[j][0] = temp[0];
                    array[j][1] = temp[1];
                    current = j;
                    break;
                }
                else{
                    j--;
                }
            }
            while(current > i){
                if(array[i][0] < array[current][0] || (array[i][0] == array[current][0] && array[i][1] > array[current][1]) ){
                    temp[0] = array[current][0];
                    temp[1] = array[current][1];
                    array[current][0] = array[i][0];
                    array[current][1] = array[i][1];
                    array[i][0] = temp[0];
                    array[i][1] = temp[1];
                    current = i;
                    break;
                }
                else{
                    i++;
                }
            }
        }
        quickSort(array, start, current-1);
        quickSort(array, current+1, end);
    }
}
