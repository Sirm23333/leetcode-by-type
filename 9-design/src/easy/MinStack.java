package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnkq37/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinStack {

    private int[] stack;
    private int[] minValue;
    private int i;
    private int size;
    private final int initSize = 100;

    public MinStack() {
        stack = new int[initSize];
        minValue = new int[initSize];
        i = 0;
        size = initSize;
    }

    public void push(int x) {
        if(i > size - 1){
            size *= 1.5;
            stack = Arrays.copyOf(stack,size);
            minValue = Arrays.copyOf(minValue,size);
        }
        stack[i] = x;
        minValue[i] = i == 0 ? stack[i] : (x > minValue[i-1] ? minValue[i - 1] : x);
        i++;
    }

    public void pop() {
        i--;
    }

    public int top() {
        return stack[i-1];
    }

    public int getMin() {
        return minValue[i-1];
    }
}
