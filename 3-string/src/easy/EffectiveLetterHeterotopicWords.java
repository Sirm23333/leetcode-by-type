package easy;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class EffectiveLetterHeterotopicWords {

    /**
     * O(n+m)
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(char c : sChars)
            sCount[c - 'a']++;
        for(char c : tChars)
            tCount[c - 'a']++;
        for(int i = 0; i < 26; i++)
            if(sCount[i] != tCount[i])
                return false;
        return true;
    }

    /**
     * 先排序
     * O(nlogn+mlogm)
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.copyValueOf(sChars).equals(String.copyValueOf(tChars));
    }
}
