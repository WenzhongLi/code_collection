package leetcode_google;

public class IslandPerimeter_463 {
//    public int islandPerimeter(int[][] grid) {
//        int length = 0,weight = 0,count = 0;
//        if(grid == null){
//            return 0;
//        }
//        length = grid.length;
//        if(length == 0){
//            return 0;
//        }
//        weight = grid[0].length;
//        for(int x = 0; x < length ; x++){
//            for(int y = 0; y < weight ; y++){
//                if (grid[x][y] == 0){
//                    continue;
//                }
//                count += searchAround(grid, x, y, length, weight);
//            }
//        }
//        return count;
//    }
//    public int searchAround(int[][] map, int x, int y, int length, int weight){
//        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
//        int count = 0;
//        for(int i = 0;i < 4;i++){
//            int newX = x+direction[i][0];
//            int newY = y+direction[i][1];
//            if(newX<0||newX >= length||newY<0||newY >= weight){
//                count++;
//            }else if(map[newX][newY] == 0){
//                count++;
//            }
//        }
//        return count;
//    }
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res += 4;
                    if(i - 1 >= 0 && grid[i - 1][j] == 1){
                        res -= 2;
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == 1){
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }
}
