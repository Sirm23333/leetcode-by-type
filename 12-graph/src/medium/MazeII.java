package medium;

import java.util.*;

/**
 * 505. 迷宫 II
 * 由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。
 *
 * 给定球的起始位置，目的地和迷宫，找出让球停在目的地的最短距离。距离的定义是球从起始位置（不包括）到目的地（包括）经过的空地个数。如果球无法停在目的地，返回 -1。
 *
 * 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
 */
public class MazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        if(m < 1)
            return -1;
        int n = maze[0].length;
        if(n < 1)
            return -1;
        // 建图,节点为每个靠墙的方格
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(maze[i][j] == 0 && (i == 0 || j == 0 || i == m - 1 || j == n - 1
                        || maze[i-1][j] == 1 || maze[i+1][j] == 1 || maze[i][j-1] == 1 || maze[i][j+1] == 1)){
                    map.put( i * n + j , map.size());
                }
            }
        }
        // start放到map中
        if(!map.containsKey(start[0] * n + start[1]))
            map.put(start[0] * n + start[1] , map.size());
        List<List<int[]>> grids = buildGrid(maze, map);
        Integer e = map.get(destination[0] * n + destination[1]);
        if(e == null)
            return -1;
        Integer s = map.get(start[0] * n + start[1]);
        return dijkstra(grids,s,e);
    }
    private List<List<int[]>> buildGrid(int[][] maze , Map<Integer,Integer> map){
        int nodeSum = map.size();
        int m = maze.length;
        int n = maze[0].length;
        // 使用邻接表
        List<List<int[]>> grid = new ArrayList<>();
        for(int i = 0; i < nodeSum; i++){
            grid.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            int[] point = new int[]{key / maze[0].length , key % maze[0].length};
            int node = entry.getValue();
            List<int[]> out = grid.get(node);
            // 记录所有出边
            // 上
            int upBound = point[0];
            while(upBound - 1 >= 0 && maze[upBound - 1][point[1]] != 1){
                upBound--;
            }
            if(upBound < point[0]){
                out.add(new int[]{map.get(upBound * n + point[1]),point[0] - upBound});
            }
            // 下
            int downBound = point[0];
            while(downBound + 1 < maze.length && maze[downBound + 1][point[1]] != 1){
                downBound++;
            }
            if(downBound > point[0]){
                out.add(new int[]{map.get(downBound * n + point[1]),downBound - point[0]});
            }
            // 左
            int leftBound = point[1];
            while(leftBound - 1 >= 0 && maze[point[0]][leftBound - 1] != 1){
                leftBound--;
            }
            if(leftBound < point[1]){
                out.add(new int[]{map.get(point[0] * n + leftBound),point[1] - leftBound});
            }
            // 右
            int rightBound = point[1];
            while(rightBound + 1 < maze[0].length && maze[point[0]][rightBound + 1] != 1){
                rightBound++;
            }
            if(rightBound > point[1]){
                out.add(new int[]{map.get(point[0] * n + rightBound),rightBound - point[1]});
            }
        }
        return grid;
    }

    public int dijkstra(List<List<int[]>> grids , int start, int end){
        int nodeSum = grids.size();
        boolean[] visited = new boolean[nodeSum];
        int[] dist = new int[nodeSum];
        Queue<int[]> minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        // 初始化数组
        for(int i = 0; i < nodeSum; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        visited[start] = true;
        for (int[] ints : grids.get(start)) {
            dist[ints[0]] = ints[1];
            minQueue.add(ints);
        }
        for(int i = 0; i < nodeSum - 1; i++){
            while(!minQueue.isEmpty() && visited[minQueue.peek()[0]]){
                minQueue.poll();
            }
            if(minQueue.isEmpty())
                break;
            int[] minEdge = minQueue.poll();
            visited[minEdge[0]] = true;
            for (int[] ints : grids.get(minEdge[0])) {
                if(!visited[ints[0]]){
                    dist[ints[0]] = Math.min(dist[ints[0]] , dist[minEdge[0]] + ints[1]);
                    minQueue.add(new int[]{ints[0] , dist[ints[0]]});
                }
            }
        }
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }

    public static void main(String[] args) {
        MazeII mazeII = new MazeII();
        mazeII.shortestDistance(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}},new int[]{0,4},new int[]{4,4});
    }
}
/*
[0,0]:0
[0,1]:1
[0,3]:2
[0,4]:3
[1,0]:4
[1,2]:5
[1,3]:6
[1,4]:7
[2,0]:8
[2,1]:9
[2,2]:10
[2,4]:11
[3,2]:12
[4,0]:13
[4,1]:14
[4,2]:15
[4,3]:16
[4,4]:17
[0,4]:18
,,,,,,,,,,,,,,,,,,
 */