package 每日一题;

import java.util.Scanner;

public class Huawei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();
        String s = scanner.nextLine();
        int idx = scanner.nextInt();
        char[] pChars = p.toCharArray();
        char[] sChars = s.toCharArray();
        int len = pChars.length;
        int sum = 0;
        for(char ss : sChars){
            boolean find = false;
            for(int i = idx; i < idx + len / 2 && !find; i++){
                if(pChars[i % len] == ss){
                    sum += i - idx;
                    idx = i % len;
                    find = true;
                }
            }
            for(int i = idx; i > idx - len / 2 && !find; i--){
                if(pChars[(i + len) % len] == ss){
                    sum += i - idx;
                    i = (i + len) % len;
                    find = true;
                }
            }
        }
        System.out.println(sum);

    }
}
