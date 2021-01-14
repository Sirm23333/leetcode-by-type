package easy;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MoveZeroes {
    /**
     * 交换位置
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return;
        int firstZero = -1;
        int tmp;
        while(firstZero < len - 1 && nums[++firstZero] != 0);
        for(int i = firstZero + 1; i < len; i++){
            if(nums[i] != 0){
                tmp = nums[i];
                nums[i] = nums[firstZero];
                nums[firstZero] = tmp;
                firstZero++;
            }
        }
    }

    /**
     * 不用交换位置，后面的直接赋值为0即可
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return;
        int firstZero = -1;
        while(firstZero < len - 1 && nums[++firstZero] != 0);
        if(firstZero == len - 1)
            return;
        for(int i = firstZero + 1; i < len; i++){
            if(nums[i] != 0)
                nums[firstZero++] = nums[i];
        }
        for(int i = firstZero ; i < len; i++)
            nums[i] = 0;
    }
}
