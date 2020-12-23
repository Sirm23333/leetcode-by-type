package _1二分求下标;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. 寻找两个正序数组的中位数
 *给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _4_MedianOfTwoSortedArrays {
    // 先归并排序，在找中位数 O(n+m)
    //80% 60%
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length, len = len1 + len2;
        int[] nums = new int[len];
        int i = 0, j =0 , k = 0;
        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < nums1.length){
            nums[k++] = nums1[i++];
        }
        while(j < nums2.length){
            nums[k++] = nums2[j++];
        }
        if(len % 2 == 1){
            return nums[len / 2];
        }else {
            return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length, len = len1 + len2;
        int i = 0, j = 0 , k = 0;
        while(i < len1 && j < len2 && i + j < len / 2.0){
            if(nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        while (i < nums1.length && i + j < len / 2.0){
            i++;
        }
        while(j < nums2.length && i + j < len / 2.0){
            j++;
        }
        if(len % 2 == 1){
            // 奇数，找[len/2-1]，max{nums1[i-1],nums2[j-1]}
            return Math.max(i > 0 ?  nums1[i-1] : Integer.MIN_VALUE , j > 0 ? nums2[j-1] : Integer.MIN_VALUE);
        }else {
            // 偶数，找[len/2-1]和[len/2]
            return (Math.max(i > 0 ?  nums1[i-1] : Integer.MIN_VALUE , j > 0 ? nums2[j-1] : Integer.MIN_VALUE) +
                    Math.min(i < len1 ?  nums1[i] : Integer.MAX_VALUE , j < len2 ? nums2[j] : Integer.MAX_VALUE)) / 2.0;
        }
    }


}
