package easy;

import java.util.HashMap;
import java.util.Map;

/**
 *多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class MajorityElement {
    /**
     * 哈希
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length , tmp = 0;
        for(int num : nums){
            tmp = map.getOrDefault(num,0);
            if(tmp + 1 > len / 2)
                return num;
            map.put(num,tmp + 1);
        }
        return 0;
    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0 ,candidate = 0;
        for(int num : nums){
            if(count == 0)
                candidate = num;
            if(num == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}
