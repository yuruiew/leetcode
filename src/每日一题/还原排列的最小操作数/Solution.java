package 每日一题.还原排列的最小操作数;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int n = 6;
        Solution solution = new Solution();
        for (int i = 0; i < n; i++) {
            System.out.println(i + ":" + solution.reinitializePermutationS1(i * 2));
        }
    }

    /**
     * 完全模拟
     *
     * @param n
     * @return
     */
    public int reinitializePermutationS1(int n) {
        int[] originalArray = generateArray(n);
        int[] currentArray = operateArray(originalArray);
        int count = 1;
        while (!Arrays.equals(originalArray, currentArray)) {
            currentArray = operateArray(currentArray);
            count++;
        }
        return count;
    }

    /**
     * 当某一个数字返回原值之后，也就代表着真个数组返回排列了，所以只需要对非头尾的任意一个值进行位置变换模拟就可以了
     *
     * @param n
     * @return
     */
    public int reinitializePermutationS2(int n) {
        int idx = n / 2;
        int count = 1;
        while (idx != 1) {
            if (idx % 2 == 0) {
                idx = idx / 2;
            } else {
                idx = n / 2 + (idx - 1) / 2;
            }
            count ++;
        }
        return count;
    }

    /**
     * 根据n生成数组
     *
     * @param n
     * @return
     */
    private int[] generateArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
     * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
     *
     * @param array
     * @return
     */
    private int[] operateArray(int[] array) {
        int[] clone = array.clone();
        for (int i = 0; i < clone.length; i++) {
            if (i % 2 == 0) {
                clone[i] = array[i / 2];
            } else {
                clone[i] = array[array.length / 2 + (i - 1) / 2];
            }
        }
        return clone;
    }
}
