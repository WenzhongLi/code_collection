package leetcode_google;

public class LongestAbsoluteFilePath_388 {
    public int lengthLongestPath(String input) {
        String[] files = input.split("\n");
        String[] path = new String[256];
        if(files.length == 0){
            return 0;
        }
        String longest = "";
        int level = 0;
        //path[0] = files[0];
        for(int i = 0;i< files.length;i++){
            //System.out.println(files[i]);
            int currentLevel = countLevel(files[i]);
            String name = getName(files[i]);
            path[currentLevel] = name;
            if (isFile(files[i])){
                String fullPath = formStirng(path, currentLevel);
                //System.out.println(fullPath);
                if(fullPath.length() > longest.length()){
                    longest = fullPath;
                }
            }
        }
        return longest.length();
    }
    private String formStirng(String[] path, int level){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<= level;i++){
            if(i!=0){
                sb.append('/');
            }
            sb.append(path[i]);
        }
        return sb.toString();
    }
    private int countLevel(String s){
        String[] data = s.split("\t");
        //System.out.println(data.length - 1);
        return data.length - 1;
    }
    private String getName(String s){
        String[] data = s.split("\t");
        //System.out.println(data[data.length - 1]);
        return data[data.length - 1];
    }
    private boolean isFile(String s){
        String[] data = s.split("\\.");
        //System.out.println(data.length);
        return data.length >= 2;
    }
}
