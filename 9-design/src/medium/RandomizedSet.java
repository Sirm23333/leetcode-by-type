package medium;

import java.util.*;

/**
 * 常数时间插入、删除和获取随机元素
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xw5rt1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RandomizedSet {

    Map<Integer , Integer> idxMap ;

    List<Integer> value ;

    Random random;

    public RandomizedSet() {
        idxMap = new HashMap<>();
        value = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(idxMap.containsKey(val))
            return false;
        value.add(val);
        idxMap.put(val,value.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(idxMap.containsKey(val)){
            Integer idx = idxMap.get(val);
            value.set(idx,value.get(value.size()-1));
            idxMap.put(value.get(value.size()-1) , idx);
            value.remove(value.size()-1);
            idxMap.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return value.get(random.nextInt(value.size()));
    }

}
