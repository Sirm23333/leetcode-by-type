package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class _12_27_205_IsomorphicStrings {
    // 双映射 17% 86%
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if(len < 2)
            return true;
        Map<Character,Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(int i = 0; i < len; i++){
            if(s2t.get(sChars[i]) != null && t2s.get(tChars[i]) != null && s2t.get(sChars[i]).equals(tChars[i])
                    && t2s.get(tChars[i]).equals(sChars[i]) ){
                continue;
            }else if(s2t.get(sChars[i]) == null && t2s.get(tChars[i]) == null){
                s2t.put(sChars[i],tChars[i]);
                t2s.put(tChars[i],sChars[i]);
            }else {
                return false;
            }
        }
        return true;
    }


}
