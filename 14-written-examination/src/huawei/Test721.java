package huawei;

import java.util.Scanner;

public class Test721 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.substring(2,str.length() - 2);
        String[] split = str.split("\\],\\[");
        int[][] edge = new int[split.length][];
        int N = 0;
        int eIdx = 0;
        for (String s : split) {
            String[] e  = s.split(",");
            edge[eIdx] = new int[3];
            edge[eIdx][0] = Integer.parseInt(e[0]);
            edge[eIdx][1] = Integer.parseInt(e[1]);
            edge[eIdx][2] = Integer.parseInt(e[2]);
            N = Math.max(N , Math.max(edge[eIdx][0] , edge[eIdx][1]));
            eIdx++;
        }
        int[][] dist = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N + 1; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] e : edge){
            dist[e[0]][e[1]] = -e[2];
        }
        for(int k = 0; k < N + 1; k++){
            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < N + 1; j++) {
                    if(i != j && dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int rs = Integer.MAX_VALUE;
        for(int i = 0; i < N + 1; i++){
            for(int j = 0; j < N + 1; j++){
                if(dist[i][j] != Integer.MAX_VALUE){
                    rs = Math.min(rs , dist[i][j]);
                }
            }
        }
        System.out.println(-rs);
    }
}
