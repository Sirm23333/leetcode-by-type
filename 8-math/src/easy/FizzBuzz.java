package easy;

import java.util.ArrayList;
import java.util.List;

/**
 *Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果n是3的倍数，输出“Fizz”；
 *
 * 2. 如果n是5的倍数，输出“Buzz”；
 *
 * 3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xngt85/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String>rs = new ArrayList<>();
        for(int i = 1; i<= n; i++){
            if(i % 3 == 0 && i % 5 == 0)
                rs.add("FizzBuzz");
            else if(i % 3 == 0)
                rs.add("Fizz");
            else if(i % 5 == 0)
                rs.add("Buzz");
            else
                rs.add(String.valueOf(i));
        }
        return rs;
    }
}
