package leetcode_google;

public class KEmptySlots_683 {
    public int kEmptySlots(int[] list, int k) {
        int min = -1;
        int[][] garden = new int[list.length][2];
        for (int i = list.length - 1;i>=0;i--){
            garden[i][0] = i-1;
            garden[i][1] = i+1;
        }
        garden[list.length - 1][1] = -1;
        for (int i = list.length - 1;i>=0;i--) {
            int right = garden[list[i]-1][1];
            int left = garden[list[i]-1][0];
            if (right != -1 && right - (list[i]-1) - 1 == k) {
                min = i + 1;
            }
            if (left != -1 && list[i]-1 - left - 1 == k){
                min = i + 1;
            }
            if (right != -1)
                garden[right][0] = left;
            if (left != -1)
                garden[left][1] = right;
        }
        return min;
    }
    public static void main(String[] args){
        KEmptySlots_683 a = new KEmptySlots_683();
        int[] l = {1,2,3,4,5};
        System.out.println(a.kEmptySlots(l,1));

    }
}
