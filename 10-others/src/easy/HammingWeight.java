package easy;

/**
 *位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 *  
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *  
 *
 * 进阶：
 *
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn1m0i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class HammingWeight {
    /**
     * 按位右移
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int tmp = n;
        int sum = 0;
        while(tmp != 0){
            if((tmp & 1) == 1)
                sum++;
            tmp >>>= 1;
        }
        return sum;
    }
    public int hammingWeight2(int n) {
        int x1 = 0x55555555;
        int x2 = 0xAAAAAAAA;
        int x3 = 0x33333333;
        int x4 = 0xCCCCCCCC;
        int x5 = 0x0F0F0F0F;
        int x6 = 0xF0F0F0F0;
        int x7 = 0x00FF00FF;
        int x8 = 0xFF00FF00;
        int x9 = 0x0000FFFF;
        int x10 = 0xFFFF0000;
        int sum = n;
        sum = (sum & x1) + ((sum & x2) >>> 1) ;
        sum = (sum & x3) + ((sum & x4) >>> 2) ;
        sum = (sum & x5) + ((sum & x6) >>> 4) ;
        sum = (sum & x7) + ((sum & x8) >>> 8) ;
        sum = (sum & x9) + ((sum & x10) >>> 16) ;
        return sum;
    }
    public int hammingWeight3(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
