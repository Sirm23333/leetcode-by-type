package _1二分求下标;

/**
 * 1095. 山脉数组中查找目标值
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *  
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 *
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
interface MountainArray {
    public int get(int index) ;
    public int length() ;
}
public class _1095_FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if(mountainArr.length() < 1)
            return -1;
        // 二分法找峰值
        int start = 0, end = mountainArr.length() - 1,mid;
        // 这样不会死循环，因为当start=end-1时，mid=start，即使走了else，也会跳出循环
        while (start < end) {
            mid = (start + end) / 2;
            if(mid < mountainArr.length() - 1 && mountainArr.get(mid) < mountainArr.get(mid + 1)){
                // 峰值在[mid+1,end]中
                start = mid + 1;
            }else {
                // 峰值在[start,mid]中
                end = mid;
            }
        }
        int peek = start;
        // 两次二分找target
        start = 0 ;
        end = peek ;
        int tmpMid ;
        while(start < end){
            tmpMid = (start + end) / 2;
            if(mountainArr.get(tmpMid) < target){
                start = tmpMid + 1;
            }else if(mountainArr.get(tmpMid) > target) {
                end = tmpMid - 1;
            }else {
                return tmpMid;
            }
        }
        if(mountainArr.get(start) == target)
            return start;

        start = peek ;
        end = mountainArr.length() ;
        while(start < end){
            tmpMid = (start + end) / 2;
            if(mountainArr.get(tmpMid) < target){
                end = tmpMid - 1;
            }else if(mountainArr.get(tmpMid) > target) {
                start = tmpMid + 1;
            }else {
                return tmpMid;
            }
        }
        if(mountainArr.get(start) == target)
            return start;
        return -1;
    }
}
