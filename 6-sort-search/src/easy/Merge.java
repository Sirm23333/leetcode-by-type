package easy;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Merge {

    /**
     * 先合并到一起 再排序
     * 排序复杂度为 O((m+n)log(m+n))
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 使用辅助数组
     * O(m+n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        int i = 0 , j = 0 , k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j])
                tmp[k++] = nums1[i++];
            else
                tmp[k++] = nums2[j++];
        }
        while(i < m)
            tmp[k++] = nums1[i++];
        while(j < n)
            tmp[k++] = nums2[j++];
        System.arraycopy(tmp,0,nums1,0,m+n);
    }

    /**
     * 只需要额外空间存储nums1的m个元素即可
     * 较第2种方式，空间为O(m)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1,0,tmp,0,m);
        int i = 0 , j = 0 , k = 0;
        while(i < m && j < n){
            if(tmp[i] < nums2[j])
                nums1[k++] = tmp[i++];
            else
                nums1[k++] = nums2[j++];
        }
        while(i < m)
            nums1[k++] = tmp[i++];
        while(j < n)
            nums1[k++] = nums2[j++];
    }

}
