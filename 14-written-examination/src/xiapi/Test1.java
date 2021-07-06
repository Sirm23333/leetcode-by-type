package xiapi;

import java.util.Scanner;

public class Test1 {
    // 所有路径的最小值的最大值
    private int totalMax = Integer.MIN_VALUE;
    // 当前遍历路径的最小值
    private int cur = 0;
    private int curMin = Integer.MAX_VALUE;

    public int minValue(int[][] rooms,int[] start , int[] end){
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        cur = 0;
        curMin = Integer.MAX_VALUE;
        dfs(rooms , visited , start[0] , start[1] , end[0], end[1]);
        return totalMax >= 0 ? 1 : 1 - totalMax;
    }
    public void dfs(int[][] rooms , boolean[][] visited , int i , int j , int endI, int endJ){
        visited[i][j] = true;
        cur += rooms[i][j];
        int lastMin = curMin;
        curMin = Math.min(cur, curMin);
        if(i == endI && j == endJ){
            totalMax = Math.max(totalMax , curMin);
        }else {
            // 上
            if(i > 0 && !visited[i - 1][j])
                dfs(rooms , visited , i - 1, j , endI, endJ);
            // 下
            if(i < visited.length - 1 && !visited[i + 1][j])
                dfs(rooms , visited , i + 1, j , endI, endJ);
            // 左
            if(j > 0 && !visited[i][j - 1])
                dfs(rooms , visited , i, j - 1 , endI, endJ);
            // 右
            if(j < visited[0].length - 1 && !visited[i][j + 1])
                dfs(rooms , visited , i, j + 1 , endI, endJ);
        }
        visited[i][j] = false;
        curMin = lastMin;
        cur -= rooms[i][j];
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
//        int i = test1.minValue(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}},new int[]{0,0}, new int[]{2,2});
        int i = test1.minValue(new int[][]{{100}},new int[]{0,0}, new int[]{0,0});
        System.out.println(i);
    }

}
