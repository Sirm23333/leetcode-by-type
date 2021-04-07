package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Huawei2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if("[]".equals(s)){
            System.out.println(0);
            return;
        }
        String[] split = s.substring(1, s.length() - 1).split("\\s*,\\s*");

        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0; i < arr.length; ){
            sum += arr[i] + 1;
            int j = i;
            while(j < i + arr[i] + 1 && j < arr.length && arr[j] == arr[i]) j++;
            i = j;
        }
        System.out.println(sum);

    }
}
