package leetcode_google;

public class FlippingAnImage_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length <= 0){
            return null;
        }
        int[][] result = new int[A.length][A[0].length];
        for (int line = 0;line < A.length;line++){
            for(int i = 0;i<A[0].length;i++ ){
                result[line][i] = A[line][A.length -1 -i] == 1? 0:1;
            }
        }
        return result;
    }
}
