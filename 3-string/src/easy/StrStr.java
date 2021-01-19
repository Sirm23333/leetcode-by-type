package easy;

/**
 * 实现 strStr()
 * 实现strStr()函数。
 *
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class StrStr {
    /**
     * 双指针
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return  0;
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        int hLen = hChars.length , nLen = nChars.length;
        int i = 0 , k = i ;
        boolean founded = false;
        for(; i < hLen && !founded; i++){
            if(hLen - i < nLen)
                break;
            founded = true;
            k = i;
            for(int j = 0; j < nLen; j++,k++){
                if(hChars[k] != nChars[j]){
                    founded = false;
                    break;
                }
            }
        }
        return founded ? i - 1 : -1;
    }

    /**
     * kmp算法
     * @param haystack
     * @param needle
     * @return
     */
    public  int strStr2(String haystack, String needle) {
        if(needle.length() == 0)
            return  0;
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        int hLen = hChars.length , nLen = nChars.length;
        // 求next数组
        int[] next = new int[nLen];
        next[0] = -1;
        int i = 0 , j = -1;
        while(i < nLen - 1){
            if(j == -1 || nChars[i] == nChars[j])
                next[++i] = ++j; // j一直为nChars[i]的next值
            else j = next[j];
        }
        // strStr()
        i = 0;
        j = 0;
        while(j < nLen && hLen - i >= nLen - j){
            if(nChars[j] == hChars[i]){
                i++;
                j++;
            }else {
                j = next[j];
                if(j == -1){
                    j = 0;
                    i++;
                }
            }
        }
        return j == nLen  ? i - nLen : -1;

    }





}
