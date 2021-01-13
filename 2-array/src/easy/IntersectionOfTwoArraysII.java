package easy;

import java.util.*;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoArraysII {


    /**
     * 排序遍历
     * O(mlogm+nlogn)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        int[] rs = new int[Math.min(len1 , len2)];
        for(int i = 0 , j = 0; i < len1 && j < len2; ){
           if(nums1[i] < nums2[j]){
               i++;
           }else if(nums1[i] > nums2[j]){
               j++;
           }else {
               rs[k++] = nums1[i];
               i++;
               j++;
           }
        }
        return Arrays.copyOf(rs,k);
    }

    /**
     * 哈希表
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length;
        if(len2 < len1){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int lenTmp = len1;
            len1 = len2;
            len2 = lenTmp;
        }
        int k = 0;
        int[] rs = new int[Math.min(len1 , len2)];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < len2; i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0) + 1);
        }
        for(int i = 0; i < len1; i++){
            if(map.getOrDefault(nums1[i] , 0) > 0){
                map.put(nums1[i] , map.getOrDefault(nums1[i] , 0)-1);
                rs[k++] = nums1[i];
            }
        }
        return Arrays.copyOf(rs,k);
    }

}
