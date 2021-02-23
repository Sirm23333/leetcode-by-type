package medium;

/**
 * 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 */
public class CanJump {


    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] flag = new boolean[len];
        flag[0] = true;
        for(int i = 0; i < len; i++){
            if(!flag[i]){
                for(int j = i - 1; j >= 0; j--){
                    if(flag[j] && nums[j] >= i - j){
                        flag[i] = true;
                        break;
                    }
                }
            }
        }
        return flag[len - 1];
    }
    public boolean canJump2(int[] nums) {
        int len = nums.length;
        int maxIdx = nums[0];
        for(int i = 0; i <= maxIdx; i++){
            if(i + nums[i] > maxIdx)
                maxIdx = i + nums[i];
            if(maxIdx >= len - 1)
                return true;
        }
        return false;
    }
}
