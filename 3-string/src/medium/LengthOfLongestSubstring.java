package medium;

import java.util.*;

/**
 *无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    /**
     * 队列+哈希判断是否存在
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(char c : chars){
            if(set.contains(c)){
                Character poll;
                do{
                    poll = deque.pollFirst();
                    set.remove(poll);
                }while (!poll.equals(c));
            }
            deque.addLast(c);
            set.add(c);
            max = Math.max(deque.size() , max);
        }
        return max ;
    }

    /**
     * 双指针+循环判断是否存在 100%
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int len = chars.length , max = Integer.MIN_VALUE;
        for(int left = 0 , right = 0; right < len; right++){
            // 判断[left,right]中是否有right
            for(int i = left; i < right; i++){
                if(chars[i] == chars[right]){
                    left = i + 1;
                    break;
                }
            }
            max = Math.max(max , right - left + 1);
        }
        return max;
    }
    /**
     * 双指针+哈希判断是否存在
     * @param s
     * @return
     */
    public int  lengthOfLongestSubstring3(String s) {
        if(s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        Map<Character , Integer> map = new HashMap<>();
        int len = chars.length , max = Integer.MIN_VALUE;
        for(int left = 0 , right = 0; right < len; right++){
            if(map.containsKey(chars[right])){
                int idx = map.get(chars[right] ) + 1;
                for(int i = left; i < idx ; i++)
                    map.remove(chars[i]);
                left = idx ;
            }

            map.put(chars[right],right);
            max = Math.max(max , right - left + 1);
        }
        return max;
    }


}
