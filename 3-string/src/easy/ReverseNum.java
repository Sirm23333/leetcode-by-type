package easy;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 注意：
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−231, 231− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * 提示：
 * -231 <= x <= 231 - 1
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseNum {

    /**
     * 主要问题是怎么检测溢出，这里用的long有点投机取巧了
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long rs = 0;
        while(x != 0){
            rs *= 10;
            rs += (x % 10);
            x /= 10;
        }
        if(rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE)
            return 0;
        return (int)rs;
    }

    /**
     * 操作前检测溢出
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int rs = 0;
        while(x != 0){
            if(rs > 0 && (rs > Integer.MAX_VALUE / 10 || (rs == Integer.MAX_VALUE / 10 && x % 10 > 7))){
                return 0;
            }else if(rs < 0 && (rs < Integer.MIN_VALUE / 10 || (rs == Integer.MIN_VALUE / 10 && x % 10 < -8))){
                return 0;
            }
            rs *= 10;
            rs += (x % 10);
            x /= 10;
        }
        return rs;
    }

    public static void main(String[] args) {
        reverse(-2147483648);
    }
}
