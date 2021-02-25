package medium;

import java.util.Arrays;

/**
 *
 */
public class LengthOfLIS {
    /**
     * O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] length = new int[len];
        Arrays.fill(length,1);
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(nums[j] > nums[i]){
                    length[j] = Math.max(length[j] , length[i] + 1);
                }
            }
        }
        int max = -1;
        for(int l : length)
            max = Math.max(l,max);
        return max;
    }
}
