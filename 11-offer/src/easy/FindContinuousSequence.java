package easy;

import java.util.ArrayList;
import java.util.List;

/**
 *剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> rs = new ArrayList<>();
        int left = 1 , right = 2 , sum = 3;
        while(left < right && 2 * left < target){
            if(sum < target){
                right++;
                sum += right;
            }else if(sum > target){
                sum -= left;
                left++;
            }else {
                int[] r = new int[right - left + 1];
                for(int i = left ; i <= right ; i++){
                    r[i-left] = i;
                }
                rs.add(r);
                sum -= left;
                left++;
            }
        }
        int[][] rss = new int[rs.size()][];
        for(int i = 0; i < rs.size(); i++){
            rss[i] = rs.get(i);
        }
        return rss;
    }
}
