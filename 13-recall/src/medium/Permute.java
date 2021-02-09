package medium;

import java.util.*;

/**
 *全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rss = new ArrayList<>();
        permute(nums , 0 , rss);
        return rss;
    }
    public void permute(int[] nums , int n , List<List<Integer>> rss) {
        if(n == nums.length){
            List<Integer> rs = new ArrayList<>();
            for(int num : nums)
                rs.add(num);
            rss.add(rs);
        }
        for(int i = n; i < nums.length; i++){
            {int tmp = nums[n];  nums[n] = nums[i]; nums[i] = tmp;}
            permute(nums , n + 1 , rss);
            {int tmp = nums[n];  nums[n] = nums[i]; nums[i] = tmp;}
        }
    }
}
