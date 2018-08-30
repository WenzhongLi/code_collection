package leetcode_google;

public class JudgeRouteCircle_657 {
    public boolean judgeCircle(String moves) {
        int h = 0, v = 0;
        for(int i = 0;i< moves.length();i++){
            if(moves.charAt(i) == 'U'){
                h++;
            }else if(moves.charAt(i) == 'D'){
                h--;
            }else if(moves.charAt(i) == 'L'){
                v--;
            }else if(moves.charAt(i) == 'R'){
                v++;
            }
        }
        return (v==0&&h==0);
    }
}
