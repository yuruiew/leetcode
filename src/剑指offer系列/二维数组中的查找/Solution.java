package 剑指offer系列.二维数组中的查找;

public class Solution {

    /**
     * 直接暴力
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArrayS1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二分查找
     */
    static class Solution1 {
        public static boolean findNumberIn2DArray(int[][] matrix, int target) {
            int m = matrix.length;
            if (m == 0) {
                return false;
            }
            int n = matrix[0].length;
            if (n == 0) {
                return false;
            }
            int mi = 0;
            int ni = 0;
            while (true) {
                if (mi >= m && ni >= n) {
                    return false;
                } else {
                    if (mi >= m) {
                        mi = m - 1;
                    }
                    if (ni >= n) {
                        ni = n - 1;
                    }
                }
                if (matrix[mi][ni] == target) {
                    return true;
                } else if (matrix[mi][ni] < target) {
                    mi++;
                    ni++;
                } else if (matrix[mi][ni] > target) {
                    for (int ms = mi - 1; ms >= 0; ms--) {
                        for (int ns = ni; ns <= n - 1; ns++) {
                            if (matrix[ms][ns] == target) {
                                return true;
                            }
                        }
                    }
                    for (int ms = mi; ms <= m - 1; ms++) {
                        for (int ns = 0; ns <= ni - 1; ns++) {
                            if (matrix[ms][ns] == target) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
    }

}
