package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray(); // aab
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int left = 0, right = 0; right < chars.length; right++){
            if(!set.add(chars[right])){
                for(;left < right && chars[left] != chars[right];left++){
                    set.remove(chars[left]);
                }
                left++;
            }else {
                max = Math.max(max , right - left + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("tmmzuxt");
    }
}
