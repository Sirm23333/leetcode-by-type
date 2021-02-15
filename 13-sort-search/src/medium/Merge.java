package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class Merge {
    /**
     * 排序+线性遍历
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> rssList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int i = 0;
        int left,right;
        while(i < intervals.length){
            left = intervals[i][0];
            right = intervals[i][1];
            while(i < intervals.length - 1 && intervals[i+1][0] <= right){
                right = Math.max(intervals[i+1][1] , right);
                i++;
            }
            rssList.add(new int[]{left,right});
            i++;
        }
        int[][] rss = new int[rssList.size()][2];
        for(int j = 0; j < rss.length; j++){
            rss[j] = rssList.get(j);
        }
        return rss;
    }

    /**
     * 换一种写法
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        List<int[]> rssList = new ArrayList<>();
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        quickSort(intervals,0,intervals.length-1);
        int left = intervals[0][0],right = intervals[0][1];
        int i = 1;
        while(i < intervals.length){
            if(right >= intervals[i][0])
                right = Math.max(right , intervals[i][1]);
            else {
                rssList.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
            i++;
        }
        rssList.add(new int[]{left,right});
        int[][] rss = new int[rssList.size()][2];
        for(int j = 0; j < rss.length; j++){
            rss[j] = rssList.get(j);
        }
        return rss;
    }

    /**
     * 手写快排
     * @param intervals
     * @param left
     * @param right
     */
    public void quickSort(int[][] intervals , int left , int right){
        if(left >= right)
            return;
        int[] target = intervals[left];
        int i = left  , j = right;
        while(i < j){
            while(i < j && intervals[j][0] >= target[0]) j--;
            if(i < j)
                intervals[i] = intervals[j];
            while(i < j && intervals[i][0] <= target[0]) i++;
            if(i < j)
                intervals[j] = intervals[i];
        }
        intervals[i] = target;
        quickSort(intervals , left , i - 1);
        quickSort(intervals , i + 1 , right);
    }

}
