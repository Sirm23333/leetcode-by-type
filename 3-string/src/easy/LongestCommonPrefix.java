package easy;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    /**
     * 纵向比较
     * O(mn) n为平均长度，m为str数量
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for(String str : strs){
            minLen = Math.min(minLen , str.length());
        }
        for(int i = 0; i < minLen; i++){
            char c = strs[0].charAt(i);
            for(String str : strs){
                if(c != str.charAt(i))
                    return str.substring(0,i);
            }
        }
        return strs[0].substring(0,minLen);
    }

    /**
     * 横向查找
     * 时间复杂度 O(mn) n为平均长度，m为str数量
     * 空间复杂度 O(n)
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        int comIdx = strs[0].length();
        for(int i = 1 , j ; i < strs.length; i++){
            j = 0;
            for(; j < comIdx && j < strs[i].length(); j++){
                if(strs[0].charAt(j) != strs[i].charAt(j)){
                    comIdx = j;
                    break;
                }
            }
            if(j == strs[i].length()){
                comIdx = strs[i].length();
            }
        }
        return strs[0].substring(0,comIdx);
    }

    /**
     * 分治法
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs ) {
        if(strs.length == 0)
            return "";
        return longestCommonPrefix3_sub(strs,0,strs.length);
    }
    public String longestCommonPrefix3_sub(String[] strs , int start , int end) {
        if(start == end)
            return strs[start];
        String left = longestCommonPrefix3_sub(strs , start , (start + end) / 2);
        String right = longestCommonPrefix3_sub(strs , (start + end) / 2 + 1 , end);
        for(int i = 0; i < left.length() && i < right.length(); i++){
            if(left.charAt(i) != right.charAt(i))
                return left.substring(0,i);
        }
        return left.length() > right.length() ? right : left;
    }
}
