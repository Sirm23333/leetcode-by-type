package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> rs = new ArrayList<>();
        generateParenthesis(rs , new StringBuffer() , 0 , 0 , n);
        return rs;
    }
    public void generateParenthesis(List<String> rs , StringBuffer tmp , int left , int right , int n){
        if(left == n && right == n){
            rs.add(tmp.toString());
            return;
        }
        if(left < n){
            tmp.append('(');
            generateParenthesis(rs , tmp , left + 1 , right , n);
            tmp.deleteCharAt(left + right );
        }
        if(right < left){
            tmp.append(')');
            generateParenthesis(rs , tmp , left  , right + 1 , n);
            tmp.deleteCharAt(left + right );
        }
    }
}
