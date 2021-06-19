package easy;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class Add {

    public int add(int a, int b) {
        if(b == 0)
            return a;
        return add(a ^ b , (a & b) << 1);
    }

    public int add2(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1; // 进位
            a ^= b; // 非进位和
            b = c;
        }
        return a;
    }
}
