package easy;

import java.util.HashMap;
import java.util.Map;

/**
 *剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {
    /**
     * 哈希记录，两次遍历
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        Map<Character , Integer> map = new HashMap<>();
        for(char c : chars)
            map.put(c , map.getOrDefault(c , 0) + 1 );
        for(char c : chars)
            if(map.get(c) == 1)
                return c;
        return ' ';
    }

    /**
     * 出现"只有小写字母"、"只有大写字母"，要记得考虑使用"数组代替哈希"
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int[] letter = new int[26];
        for(char c : chars)
            letter[c - 'a']++;
        for(char c : chars)
            if(letter[c - 'a'] == 1)
                return c;
        return ' ';
    }
}
