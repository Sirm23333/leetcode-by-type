package easy;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        boolean[] exist = new boolean[14];
        int max = -1 , min = 14 , sum0 = 0;
        for(int num : nums){
            if(num > 0) {
                if(exist[num]){ // 有重复
                    return false;
                }else {
                    exist[num] = true;
                    max = Math.max(max,num);
                    min = Math.min(min,num);
                }
            }
        }
        return max - min + 1 <= 5;
    }
}
