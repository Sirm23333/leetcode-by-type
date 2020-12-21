package 每日一题;
/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Stack;

public class _12_20_316_RemoveDuplicateLetters {
    // 87%  66%
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        // 转成字符数组，因为如果遍历String的话，每一次访问会有越界判断，影响速度
        char[] charArray = s.toCharArray();
        // 每个字符出现的最后一次的位置
        int[] lastIndex  = new int[26];
        for(int i = 0; i < len; i++){
            lastIndex[charArray[i] - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        HashSet<Character> exist = new HashSet<>();
        for(int i = 0; i < len; i++){
            if(exist.contains(charArray[i]))
                continue;
            while(!stack.isEmpty() && stack.peek() > charArray[i] && lastIndex[stack.peek() - 'a'] > i){
                exist.remove(stack.peek());
                stack.pop();
            }
            exist.add(charArray[i]);
            stack.push(charArray[i]);
        }
        StringBuffer rs = new StringBuffer();
        while(!stack.isEmpty())
            rs.append(stack.pollFirst());
        return rs.toString();
    }
    public String removeDuplicateLetters2(String s) {
        int len = s.length();
        // 转成字符数组，因为如果遍历String的话，每一次访问会有越界判断，影响速度
        char[] charArray = s.toCharArray();
        // 每个字符出现的最后一次的位置
        int[] lastIndex  = new int[26];
        for(int i = 0; i < len; i++){
            lastIndex[charArray[i] - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        // 栈中存在的元素
        boolean[] exist = new boolean[26];
        for(int i = 0; i < len; i++){
            if(exist[charArray[i] - 'a'])
                continue;
            while(!stack.isEmpty() && stack.peek() > charArray[i] && lastIndex[stack.peek() - 'a'] > i){
                exist[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(charArray[i]);
            exist[stack.peek() - 'a'] = true;
        }
        StringBuffer rs = new StringBuffer();
        while(!stack.isEmpty())
            rs.append(stack.pollLast());
        return rs.toString();
    }


}
