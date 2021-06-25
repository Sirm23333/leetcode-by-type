package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 */
class MaxQueue {
    private Queue<Integer> queue;
    private Deque<Integer> maxQueue;
    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }
    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while(!maxQueue.isEmpty() && maxQueue.peekLast() < value){
            maxQueue.pollLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        if(queue.peek().equals(maxQueue.peekFirst()))
            maxQueue.pollFirst();
        return queue.poll();
    }
}