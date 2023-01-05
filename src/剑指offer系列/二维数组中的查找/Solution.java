package 剑指offer系列.二维数组中的查找;

public class Solution {

    /**
     * 直接暴力
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArrayS1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 抽象BFS
     * 从根（右上角）开始搜索，如果当前的节点不等于目标值，可以按照树的搜索顺序进行：
     * 当前节点「大于」目标值，搜索当前节点的「左子树」，也就是当前矩阵位置的「左方格子」，即 c--
     * 当前节点「小于」目标值，搜索当前节点的「右子树」，也就是当前矩阵位置的「下方格子」，即 r++
     */
    static class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            int r = 0, c = n - 1;
            while (r < m && c >= 0) {
                if (matrix[r][c] < target) {
                    //target比当前位置的数字大, 下移一行
                    r++;
                } else if (matrix[r][c] > target) {
                    //target比当前位置的数字小, 左移一列
                    c--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }


}
