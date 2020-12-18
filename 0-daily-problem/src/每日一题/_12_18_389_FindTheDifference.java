package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 *  389. 找不同
 *  给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _12_18_389_FindTheDifference {
    // map映射  5.5% / 25%
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            if(map.get(t.charAt(i)) == null || map.get(t.charAt(i)) == 0 )
                return t.charAt(i);
            else
                map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
        }
        return ' ';
    }

    // 求和 45% / 45%
    public char findTheDifference2(String s, String t) {
        int sum = 0;
        for(int i = 0; i < t.length(); i++){
            sum += t.charAt(i);
        }
        for(int i = 0; i < s.length(); i++){
            sum -= s.charAt(i);
        }
        return (char) sum;
    }

    // 位运算 76% / 83%
    public char findTheDifference3(String s, String t) {
        char rs = 0;
        int tSize = t.length() , sSize = s.length();
        for(int i = 0; i < tSize; i++){
            rs ^= t.charAt(i);
        }
        for(int i = 0; i < sSize; i++){
            rs ^= s.charAt(i);
        }
        return rs;
    }
}
