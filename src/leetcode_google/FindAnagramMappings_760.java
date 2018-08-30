package leetcode_google;

import java.util.HashMap;

public class FindAnagramMappings_760 {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        for (int i = 0;i < A.length;i++){
            mapping.put(B[i],i);
        }
        int[] result = new int[A.length];
        for (int i = 0;i < A.length;i++){
            result[i] = mapping.get(A[i]);
        }
        return result;
    }
}
