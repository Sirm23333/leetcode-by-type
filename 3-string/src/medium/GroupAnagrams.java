package medium;

import java.util.*;

/**
 *
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rss = new ArrayList<>();
        boolean set ;
        for(String str : strs){
            set = false;
            for(List<String> rs : rss){
                String tmp = rs.get(0);
                if(isAnagram(tmp , str)){
                    set = true;
                    rs.add(str);
                }
            }
            if(!set){
                List<String> rs = new ArrayList<>();
                rs.add(str);
                rss.add(rs);
            }
        }
        return rss;
    }

    boolean isAnagram(String s , String t){
        if(s.length() != t.length())
            return false;
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        int  len1 = s.length() , len2 = t.length();
        for(int i = 0; i < len1; i++)
            sCount[s.charAt(i) - 'a']++;
        for(int i = 0; i < len2; i++)
            tCount[t.charAt(i) - 'a']++;
        for(int i = 0; i < 26; i++)
            if(sCount[i] != tCount[i])
                return false;
        return true;
    }

    /**
     * 哈希记录
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> rss = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            List<String> list = map.getOrDefault(tmp, new ArrayList<>());
            if(list.isEmpty()){
                rss.add(list);
                map.put(tmp,list);
            }
            list.add(str);
        }
        return rss;
    }


}
