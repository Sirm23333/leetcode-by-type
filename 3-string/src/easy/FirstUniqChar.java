package easy;

import java.util.*;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FirstUniqChar {

    /**
     * 哈希 + 两遍遍历
     * 45%
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character , Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            map.put(c , map.getOrDefault(c , 0) + 1);
        }
        for(int i = 0; i < chars.length; i++){
            if(map.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }

    /**
     * 用数组记录索引
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] charIndex = new int[26];
        Arrays.fill(charIndex , -1);
        for(int i = 0; i < length; i++){
            if(charIndex[chars[i] - 'a'] == -1)
                charIndex[chars[i] - 'a']  = i;
            else if(charIndex[chars[i] - 'a'] > -1)
                charIndex[chars[i] - 'a'] = -2;
        }
        int rs = Integer.MAX_VALUE;
        for(int idx : charIndex){
            if(idx > -1)
                rs = Math.min(rs , idx);
        }
        return rs == Integer.MAX_VALUE ? -1 : rs;
    }
    /**
     * 用数组记录索引 进一步优化速度
     * @param s
     * @return
     */
    public int firstUniqChar3(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex , -1);
        for(int i = 0; i < length; i++){
            if(charIndex[chars[i]] == -1)
                charIndex[chars[i]]  = i;
            else
                charIndex[chars[i]] = -2;
        }
        int rs = Integer.MAX_VALUE;
        for(int i = 'a';i <= 'z'; i++){
            if(charIndex[i] > -1)
                rs = Math.min(rs , charIndex[i]);
        }
        return rs == Integer.MAX_VALUE ? -1 : rs;
    }

    /**
     * 直接查找 100%
     * @param s
     * @return
     */
    public int firstUniqChar4(String s) {
        int idx , rs = Integer.MAX_VALUE;
        for(char c = 'a' ; c <= 'z'; c++){
            idx = s.indexOf(c);
            if(idx != -1 && idx == s.lastIndexOf(c)){
                rs = Math.min(rs , idx);
            }
        }
        return rs == Integer.MAX_VALUE ? -1 : rs;
    }
    /**
     * 队列+哈希
     * @param s
     * @return
     */
    public int firstUniqChar5(String s) {
        char[] chars = s.toCharArray();
        Map<Character , Integer> map = new HashMap<>();
        Deque<Pair> deque = new ArrayDeque<>();
        for(int i = 0 ; i < chars.length; i++){
            if(!map.containsKey(chars[i])){
                map.put(chars[i] , 1);
                deque.addLast(new Pair(chars[i],i));
            }else {
                map.put(chars[i] , -1);
                while(!deque.isEmpty() && map.get(deque.peekFirst().c) == -1)
                    deque.pollFirst();
            }
        }
        return deque.isEmpty() ? -1 : deque.pollFirst().idx;
    }
    class Pair{
        char c;
        int idx;

        public Pair(char aChar, int i) {
            c = aChar;
            idx = i;
        }
    }
}
