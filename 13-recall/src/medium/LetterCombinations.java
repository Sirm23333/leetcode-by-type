package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> rs = new ArrayList<>();
        if(digits == null || "".equals(digits))
            return rs;
        char[][] letter = new char[10][];
        letter[2] = new char[]{'a','b','c'};
        letter[3] = new char[]{'d','e','f'};
        letter[4] = new char[]{'g','h','i'};
        letter[5] = new char[]{'j','k','l'};
        letter[6] = new char[]{'m','n','o'};
        letter[7] = new char[]{'p','q','r','s'};
        letter[8] = new char[]{'t','u','v'};
        letter[9] = new char[]{'w','x','y','z'};
        char[] chars = digits.toCharArray();
        letterCombinations(chars , 0 , letter , new StringBuffer() , rs);
        return rs;
    }
    public void letterCombinations(char[] digits , int n , char[][] letter , StringBuffer tmp , List<String> rs){
        if(n == digits.length){
            rs.add(tmp.toString());
            return;
        }
        int digit = digits[n] - '0';
        for(char c : letter[digit]){
            tmp.append(c);
            letterCombinations(digits , n + 1 , letter , tmp , rs);
            tmp.deleteCharAt(n);
        }
    }

}
