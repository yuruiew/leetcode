package 剑指offer系列.数组中重复的数字;

import java.util.HashMap;

public class Solution {
    /**
     * 哈希表存储，有重复值就返回
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer key = map.get(num);
            if (key == null){
                //添加
                map.put(num, 1);
            }else {
                return num;
            }
        }
        return 0;
    }
}
