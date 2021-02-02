package easy;

import java.util.Stack;

/**
 *有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnbcaj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ValidBracket {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        if(len == 0)
            return true;
        for(char c : chars){
            if(c == '(' || c == '[' || c == '{')
                stack.add(c);
            else {
                if(stack.isEmpty()
                        || (c == ')' && !stack.peek().equals('('))
                        || (c == ']' && !stack.peek().equals('['))
                        || (c == '}' && !stack.peek().equals('{')))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
