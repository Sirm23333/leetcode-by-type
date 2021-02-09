package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rss = new ArrayList<>();
        subsets(nums,0,rss , new ArrayList<>());
        return rss;
    }
    public void subsets(int[] nums , int i , List<List<Integer>> rss , List<Integer> rs){
        if(i == nums.length ){
            rss.add(new ArrayList<>(rs));
            return;
        }
        rs.add(nums[i]);
        subsets(nums , i + 1 , rss, rs);
        rs.remove(rs.size() - 1);
        subsets(nums, i + 1 , rss , rs);
    }
}
