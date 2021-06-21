package medium;

import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
class Permutation {
    public static String[] permutation(String s) {
        List<String> rs = new ArrayList<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        if(len == 0)
            return new String[0];
        permutation(chars,0 , rs);
        return rs.toArray(new String[rs.size()]);
    }
    private static void permutation(char[] chars , int idx , List<String> rs){
        if(idx == chars.length - 1){
            rs.add(String.copyValueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = idx ; i < chars.length; i++){
            if(!set.add(chars[i])){
                continue;
            }
            {char tmp = chars[i]; chars[i] = chars[idx]; chars[idx] = tmp;}
            permutation(chars, idx + 1 , rs);
            {char tmp = chars[i]; chars[i] = chars[idx]; chars[idx] = tmp;}
        }
    }
}