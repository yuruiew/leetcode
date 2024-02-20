package SwordOfferII.LCR001;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(divide(15, 2));
        System.out.println(divide(7, -3));
        System.out.println(divide(0, 1));
        System.out.println(divide(1, 1));
        System.out.println(divide(-2147483648, -1));
    }
    public static int divide(int a, int b) {

        if (a == Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }

        boolean flag = false;
        if (a < 0){
            a = -a;
            flag  = true;
        }
        if (b < 0){
            b = -b;
            flag = !flag;
        }

        int res = 0;
        a = a - b;
        while (a >= 0){
            a = a - b;
            res++;
           if(res == 2147483647){
               break;
           }
        }
        return flag ? -res : res;
    }

    /**
     * 官方题解1
     * @param a
     * @param b
     * @return
     */
    public static int divide1(int a, int b){
        //考虑被除数最小时的情况
        if (a == Integer.MIN_VALUE){
            if (b == 1){
                return Integer.MIN_VALUE;
            }
            if (b == -1){
                return Integer.MAX_VALUE;
            }
        }
        //考虑除数最小值的情况
        if (b == Integer.MIN_VALUE){
            if (a == Integer.MIN_VALUE){
                return 1;
            }else {
                return 0;
            }
        }
        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean flag = false;
        if (a > 0){
            a = -a;
            flag  = true;
        }
        if (b > 0){
            b = -b;
            flag = !flag;
        }
        int left = 1, right=Integer.MAX_VALUE, res = 0;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(b, mid, a);
            if (check){
                res = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        return flag ? - res : res;


    }

    private static boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }

}
