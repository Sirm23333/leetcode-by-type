package medium;

import java.util.List;
import java.util.Stack;

/**
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {


    /**
     * dfs
     * 超时
     * @param coins
     * @param amount
     * @return
     */
    int minRs = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        quickSort(coins,0,coins.length-1);
        Stack<Integer> stack = new Stack<>();
        for(int coin : coins){
            stack.push(coin);
            int rs = dfs(coins,amount,stack,coin);
            if(rs > -1){
                minRs = Math.min(minRs,rs);
            }
            stack.pop();
        }
        return minRs == Integer.MAX_VALUE ? -1 : minRs;
    }
    public int dfs(int[] coins , int amount, Stack<Integer> stack , int sum){
        if(sum == amount)
            return stack.size();
        if(sum > amount)
            return -1;
        int peek = stack.peek();
        for(int coin : coins){
            if(coin <= peek){
                stack.push(coin);
                int rs = dfs(coins , amount , stack , sum + coin);
                stack.pop();
                if(rs > -1){
                    minRs = Math.min(minRs,rs);
                }
            }
        }
        return -1;
    }
    public void quickSort(int[] arr , int start , int end){
        if(start >= end)
            return;
        int candidate = arr[start];
        int i = start , j = end;
        while(i < j){
            while( i < j && arr[j] < candidate  ) j--;
            if(i < j){
                arr[i] = arr[j];
            }
            while( i < j && arr[i] > candidate) i++;
            if(i < j){
                arr[j] = arr[i];
            }
        }
        arr[i] = candidate;
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
    }

}
