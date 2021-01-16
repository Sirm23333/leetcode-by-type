package easy;

/**
 * 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 *     countAndSay(1) = "1"
 *     countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CountAndSay {

    /**
     * 递归 55%
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String pre = countAndSay(n - 1);
        if(pre.length() == 1){
            return "1" + pre;
        }
        char[] chars = pre.toCharArray();
        StringBuffer sb = new StringBuffer();
        int cnt = 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i-1])
                cnt++;
            else {
                sb.append(cnt).append(chars[i-1]);
                cnt = 1;
            }
        }
        sb.append(cnt).append(chars[chars.length-1]);
        return sb.toString();
    }

    /**
     * 地推 45%
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        StringBuffer pre ;
        StringBuffer cur = new StringBuffer("1");
        for(int k = 1; k < n; k++){
            pre = cur;
            cur = new StringBuffer();
            char[] chars = pre.toString().toCharArray();
            int cnt = 1;
            for(int i = 1; i < chars.length; i++){
                if(chars[i] == chars[i-1])
                    cnt++;
                else {
                    cur.append(cnt).append(chars[i-1]);
                    cnt = 1;
                }
            }
            cur.append(cnt).append(chars[chars.length-1]);
        }

        return cur.toString();
    }
}
