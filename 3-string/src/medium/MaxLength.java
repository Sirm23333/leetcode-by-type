package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1239. 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 *
 * 请返回所有可行解 s 中最长长度。
 *
 * 示例 1：
 *
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 */
public class MaxLength {

    public int maxLength(List<String> arr) {
        int[] remain = new int[arr.size()];
        int i = 0;
        for(String str : arr){
            boolean flag = true;
            char[] chars = str.toCharArray();
            int bitmap = 0;
            for(char c : chars){
                int tmp = 1 << (c - 'a');
                if( (bitmap & tmp) == 0 )
                    bitmap |= tmp;
                else {
                    flag = false;
                    break;
                }
            }
            if(flag)
                remain[i++] = bitmap;
        }
        return getRs(remain ,  i,0 , 0);
    }
    private int getRs(int[] arr , int size, int idx , int tmp){
        if(idx == size)
            return get1Sum(tmp);
        return Math.max(getRs(arr,size , idx + 1 , tmp) , (tmp & arr[idx]) == 0 ? getRs(arr,size , idx + 1 , tmp | arr[idx]) : 0);
    }
    private int get1Sum(int m){
        int sum = 0;
        while(m != 0){
            sum++;
            m &= (m-1);
        }
        return sum;
    }

}
