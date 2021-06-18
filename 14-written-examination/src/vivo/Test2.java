package vivo;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = Integer.parseInt(scanner.nextLine());
        String wStr = scanner.nextLine();
        String vStr = scanner.nextLine();
        String[] ws = wStr.split(",");
        String[] vs = vStr.split(",");
        int[] w = new int[ws.length];
        int[] v = new int[vs.length];
        for(int i = 0; i < ws.length;i++){
            w[i] = Integer.parseInt(ws[i]);
            v[i] = Integer.parseInt(vs[i]);
        }
        System.out.println(value(c,w,v,0));
    }
    public static int value(int c, int[] w, int[] v , int idx){
        if(idx == w.length)
            return 0;
        return Math.max(value(c,w,v,idx+1) , c >= w[idx] ? v[idx] + value(c - w[idx] , w, v, idx + 1) : 0);
    }
}
