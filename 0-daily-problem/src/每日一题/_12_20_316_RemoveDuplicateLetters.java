package 每日一题;

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
