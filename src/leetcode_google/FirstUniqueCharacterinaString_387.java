package leetcode_google;

public class FirstUniqueCharacterinaString_387 {
    public int firstUniqChar(String s) {
        int[] table = new int[256];
        for(int i = s.length() - 1;i>=0;i--){
            int c = (int)s.charAt(i);
            table[c]++;
        }
        for(int i = 0;i< s.length(); i++){
            int c = (int)s.charAt(i);
            if(table[c] == 1){
                return i;
            }
        }
        return -1;
    }
}
