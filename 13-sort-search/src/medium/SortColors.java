package medium;

/**
 *颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class SortColors {
    /**
     * 0往前放 2往后放
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p0 = 0 , p2 = nums.length - 1 , i = p0;
        while(i <= p2){
            if(nums[i] == 0){
                nums[i] = nums[p0];
                nums[p0] = 0;
                while(p0 < nums.length && nums[p0] == 0) p0++;
                i = p0;
            }else if(nums[i] == 2){
                nums[i] = nums[p2];
                nums[p2] = 2;
                while(p2 >= 0 && nums[p2] == 2) p2--;
            }else {
                while(i < nums.length && nums[i] == 1) i++;
            }
        }
    }
}
