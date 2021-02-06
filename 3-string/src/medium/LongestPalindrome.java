package medium;

/**
 *最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {
    /**
     * 暴力法 O(n^3)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int max = Integer.MIN_VALUE , start = 0, end = 0;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(validPalindrome(chars , i , j)){
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start , end + 1);
    }
    private boolean validPalindrome(char[] chars , int start , int end){
        while(start < end){
            if(chars[start] != chars[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    /**
     * 中心扩散法
     * O(n^2)
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if(s.length() < 2)
            return s;
        int len = s.length();
        char[] chars = s.toCharArray();
        int max = Integer.MIN_VALUE,center = 0;
        for(int i = 0; i < len - 1; i++){
            int len1 = expandAroundCenter(chars , i , i) * 2 - 1; // 中心是一个数
            int len2 = expandAroundCenter(chars , i , i+1) * 2 ; // 中心是一个位置
            if(len1 > len2 && len1 > max){
                max = len1;
                center = i;
            }else if(len2 >= len1 && len2 > max){
                max = len2;
                center = i;
            }
        }
        if(max % 2 == 1)
            return s.substring(center - max / 2 , center + max / 2 + 1);
        return s.substring(center - max / 2 + 1 , center + max / 2 + 1);
    }
    private static  int expandAroundCenter(char[] chars , int i, int j){
        int len = 0;
        while(i >= 0 && j < chars.length  && chars[i--] == chars[j++]) len++;
        return len;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        if(s.length() < 2)
            return s;
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len]; // dp[i][j]表示[i,j]是否是回文
        int max = 0, start = 0 ,  end = 0;
        for(int l = 1; l < len + 1; l++){
            for(int i = 0; i < len - l + 1; i++){
                // 以i开头，长度为l的子串
                int j = i + l - 1;
                if( chars[i] == chars[j] && (l <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(max < j - i + 1){
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start , end + 1);
    }


    public static void main(String[] args) {
        longestPalindrome3("bb");
    }




}
