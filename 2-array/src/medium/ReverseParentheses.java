package medium;

/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 */
public class ReverseParentheses {
    public String reverseParentheses(String s) {
        return reverseParentheses(new StringBuffer(s)).toString();
    }
    public StringBuffer reverseParentheses(StringBuffer s) {
        if(s.indexOf("(") == -1)
            return s;
        int left = s.lastIndexOf("(");
        int right = s.indexOf(")",left);
        String str = s.substring(left + 1, right  );
        StringBuffer reverse = new StringBuffer(str).reverse();
        StringBuffer replace = s.replace(left, right , reverse.toString());
        return reverseParentheses(replace);
    }
}
