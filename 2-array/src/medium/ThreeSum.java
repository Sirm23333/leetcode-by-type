package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    /**
     * 暴力法
     * O(n^3)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i + 1; j < len; j++){
                if(j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                for(int k = j + 1; k < len; k++){
                    if(k != j + 1 && nums[k] == nums[k - 1])
                        continue;
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> rsTmp = new ArrayList<>();
                        rsTmp.add(nums[i]);
                        rsTmp.add(nums[j]);
                        rsTmp.add(nums[k]);
                        rs.add(rsTmp);
                    }
                }
            }
        }
        return rs;
    }

    /**
     * 遍历数组，每次访问再在剩下的数组中使用双指针遍历，查询是否存在Nums[j]+nums[k]==-nums[i]
     * 小技巧：正常思维都会把去除操作放到遍历步骤中，先判断改种组合是否重复，再去判断该种组合是否满足条件，这样循环中需要两步判断
     *          不如在循环中只判断是否满足条件，如果满足条件，再把这种情况全部一次去除
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        int len = nums.length , target;
        for(int i = 0; i < len - 2 ; i++){
            if(nums[i] > 0)
                break;
            if( i != 0 && nums[i] == nums[i-1])
                continue;
            // 双指针两头遍历剩下的
            target = -nums[i];
            for(int j = i + 1 , k = len - 1; j < k;){
                if(nums[j] > target)
                    break;
                if(nums[j] + nums[k] < target)
                    j++;
                else if(nums[j] + nums[k] > target)
                    k--;
                else {
                    List<Integer> rsTmp = new ArrayList<>();
                    rsTmp.add(nums[i]);
                    rsTmp.add(nums[j]);
                    rsTmp.add(nums[k]);
                    rs.add(rsTmp);
                    while(nums[++j] == nums[j-1] && j < k);
                    while(nums[--k] == nums[k+1] && j < k);
                }
            }
        }
        return rs;
    }
}
