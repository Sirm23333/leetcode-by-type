package 每日一题;

import java.util.Arrays;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _12_23_387_FirstUniqueCharacterInString {

    // O(2N) 91% 73%
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] exist = new int[26];
        for(char c :chars){
            exist[c - 'a'] ++;
        }
        for(int i = 0; i < len; i++){
            if(exist[chars[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }
    // O(N)
    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] index = new int[26];
        Arrays.fill(index,-1);
        for(int i = 0; i < len; i++){
            if(index[chars[i] - 'a'] == -1)
                index[chars[i] - 'a'] = i;
            else if(index[chars[i] - 'a'] != -2)
                index[chars[i] - 'a']  = -2 ;
        }
        int rs = Integer.MAX_VALUE;
        for(int i : index){
            rs = Math.min(index[i] , rs);
        }
        if(rs == -2)
            return -1;
        return rs;
    }
}
