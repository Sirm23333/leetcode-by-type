package easy;

import java.util.HashMap;
import java.util.Map;

/**
 *罗马数字转整数
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 *
 *  
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn4n7c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RomanToInt {

    public int romanToInt(String s) {
        int rs = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i = 0; i < len  ; i++){
            switch (chars[i]){
                case 'I':
                    if(i < len - 1 && chars[i+1] == 'V'){
                        rs += 4;
                        i++;
                    }else if(i < len - 1 && chars[i+1] == 'X'){
                        rs += 9;
                        i++;
                    }else{
                        rs += 1;
                    }
                    break;
                case 'V':
                    rs += 5;
                    break;
                case 'X':
                    if(i < len - 1 && chars[i+1] == 'L'){
                        rs += 40;
                        i++;
                    }else if(i < len - 1 && chars[i+1] == 'C'){
                        rs += 90;
                        i++;
                    }else{
                        rs += 10;
                    }
                    break;
                case 'L':
                    rs += 50;
                    break;
                case 'C':
                    if(i < len - 1 && chars[i+1] == 'D'){
                        rs += 400;
                        i++;
                    }else if(i < len - 1 && chars[i+1] == 'M'){
                        rs += 900;
                        i++;
                    }else{
                        rs += 100;
                    }
                    break;
                case 'D':
                    rs += 500;
                    break;
                case 'M':
                    rs += 1000;
                    break;
                default:
                    break;
            }
        }
        return rs;
    }


}
