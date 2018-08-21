package leetcode_google;

public class NextClosestTime_681 {
    long min = 200000000;
    String r = "";
    String base;
    public String nextClosestTime(String time) {
        base = time;
        char[] numbers = new char[4];
        for(int i = 0, index = 0;index<5;i++, index++){
            if(i == 2){
                index++;
            }
            numbers[i] = time.charAt(index);
        }
        dfs("",numbers);
        return r;
    }
    public void dfs (String time, char[] numbers){
        for (char num:numbers){
            if (time.length() == 4){
                long det = 200000000;
                det = compareTime(base, time+ num);
                if (det <= 0){
                    continue;
                }
                if(det < min){
                    r = time+ num;
                    min = det;
                }
            }
            else if (time.length() == 2){
                dfs(time+":"+num,numbers);
            }
            else{
                dfs(time+num,numbers);
            }
        }
    }
    public long compareTime(String base, String time){
        String sOneDay = "24:00";
        if ((getTime(sOneDay) < getTime(time)) || getTime(time) < 0){
            return -1;
        }
        if (getTime(base)>= getTime(time)){
            return getTime(time) + getTime(sOneDay) - getTime(base);
        }
        else{
            return getTime(time) - getTime(base);
        }
    }
    public long getTime(String time){
        long r = 0;
        r = r + (time.charAt(3) - '0')*10;
        r = r + (time.charAt(4) - '0');
        if(r >= 60)
            return -1;
        r = r + (time.charAt(0) - '0')*10*60;
        r = r + (time.charAt(1) - '0')*60;
        return r;
    }
    public static void main(String[] args){
        NextClosestTime_681 a = new NextClosestTime_681();
        String time = "23:59";
        System.out.println(a.nextClosestTime(time));
    }
}
