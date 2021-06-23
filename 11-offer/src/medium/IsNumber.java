package medium;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 *
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 *
 *
 * 示例 1：
 *
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "    .1  "
 * 输出：true
 */
public class IsNumber {
    public static boolean isNumber(String s) {
        // 去掉前后空格
        s = s.trim();
        // 是否有e或者E
        int eIdx = s.indexOf('e');
        if(eIdx == -1){
            eIdx = s.indexOf('E');
        }
        // e是否是第一位置或者最后一个位置
        if(eIdx == 0 || eIdx == s.length() - 1)
            return false;
        if(eIdx != -1){
            // 有合法的e/E
            return (zhengshu(s.substring(0 , eIdx)) || xiaoshu(s.substring(0, eIdx)))
                    && zhengshu(s.substring(eIdx + 1));
        }else {
            // 没有e
            return zhengshu(s) || xiaoshu(s);
        }
    }
    private  static  boolean zhengshu(String s){
        char[] chars = s.toCharArray();
        if(chars.length == 0)
            return false;
        if(chars.length == 1 && !isNum(chars[0]))
            return false;
        for(int i = 0; i < chars.length; i++){
            if(i == 0 && (chars[i] == '+' || chars[i] == '-'))
                continue;
            if(!isNum(chars[i]))
                return false;
        }
        return true;
    }
    private static boolean isNum(char c){
        return c >= '0' && c <= '9';
    }
    private static boolean xiaoshu(String s){
        boolean flag = false; // 是否遍历到.
        boolean hasNum = false;
        char[] chars = s.toCharArray();
        if(chars.length == 0)
            return false;
        for(int i = 0; i < chars.length; i++){
            // 过滤掉非第0位的 '+' '-'
            if(i == 0 && (chars[i] == '+' || chars[i] == '-'))
                continue;
            // 过滤掉多个 '.'
            if(chars[i] == '.' && !flag){
                flag = true;
                continue;
            }else if(chars[i] == '.' && flag){
                return false;
            }
            // 过滤掉非数字字符
            if(!isNum(chars[i]))
                return false;
            hasNum = true;
        }
        if(!hasNum || !flag)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("1 "));
    }
}
