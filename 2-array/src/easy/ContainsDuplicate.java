package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * 哈希表记录已有的数字
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> exist = new HashSet<>();
        for(int num : nums){
            if(!exist.add(num))
                return true;
        }
        return false;
    }

}
