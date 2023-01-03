package 剑指offer系列.数组中重复的数字;

import java.util.HashMap;

public class Solution {
    /**
     * 哈希表存储，有重复值就返回
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberS1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer key = map.get(num);
            if (key == null) {
                //添加
                map.put(num, 1);
            } else {
                return num;
            }
        }
        return 0;
    }

    /**
     * 使用数组模拟哈希,如果对应位置数值大于1,说明该值为重复值
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberS2(int[] nums) {
        int[] numCount = new int[nums.length];
        for (int num : nums) {
            numCount[num]++;
            if (numCount[num] > 1) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 原地哈希
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberS3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == i) {
                continue;
            } else {
                int temp = nums[num];
                if (temp == num) {
                    return temp;
                }
                nums[num] = num;
                nums[i] = temp;
            }

        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 1, 1, 0};
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumberS3(nums));
    }

}
