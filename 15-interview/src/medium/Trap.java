package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 */
public class Trap {
    // [0,1,0,2,1,0,1,3,2,1,2,1]
    /**
     * 记录左右的最大值
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        int rs = 0;
        int leftMax = 0, rightMax = 0;
        // 左边最大值好算，右边的不好算，使用单调队列
        Deque<Integer> maxQueue = new ArrayDeque<>();
        for(int i = 1; i < height.length; i++){
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < height[i]){
                maxQueue.pollLast();
            }
            maxQueue.addLast(height[i]);
        }
        for(int i = 1; i < height.length - 1; i++){
            leftMax = Math.max(leftMax , height[i-1]);
            if(maxQueue.peekFirst().equals(height[i]))
                maxQueue.pollFirst();
            rightMax = maxQueue.peekFirst();
            int min = Math.min(leftMax,rightMax);
            if(min > height[i])
                rs += min - height[i];
        }
        return rs;
    }

    /**
     * 补成最大的
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if(height.length < 3)
            return 0;
        int rs = 0;
        // 最大值
        int maxIdx = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if(max < height[i]){
                max = height[i];
                maxIdx = i;
            }
        }
        // 补为凸的
        for(int i = 1; i < maxIdx ; i++){
            if(height[i] < height[i-1]){
                rs += (height[i] - height[i-1]);
                height[i] = height[i-1];
            }
        }
        for(int i = height.length-1; i > maxIdx; i--){
            if(height[i] < height[i+1]){
                rs += (height[i+1] - height[i]);
                height[i] = height[i+1];
            }
        }
        return rs;
    }
}
