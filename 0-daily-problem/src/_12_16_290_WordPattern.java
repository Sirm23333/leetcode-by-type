import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

/**
 *给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _12_16_290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;
        Map<Character,String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        Character tmpC;
        String tmpS;
        for(int i = 0; i < pattern.length(); i++){
            tmpS = p2s.get(pattern.charAt(i));
            tmpC = s2p.get(words[i]);
            if(tmpS == null && tmpC == null){
                p2s.put(pattern.charAt(i),words[i]);
                s2p.put(words[i],pattern.charAt(i));
            }else if(tmpC != null && tmpS != null){
                if(tmpC != pattern.charAt(i) || !tmpS.equals(words[i]))
                    return false;
            }else {
                return false;
            }
        }
        return true;
    }
}
