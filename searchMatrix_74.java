public class searchMatrix_74 {
    /**
     * 74. 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     *
     * 解法：
     *      二分查找。
     *      矩阵从头到尾是非递减，可视作一个长度为 m*n 的数组，每个数字在二维数组中的位置通过 (i / n, i % n)确定即可。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int length = m * n;
        return helper(matrix, target, 0, length - 1);
    }

    private boolean helper(int[][] matrix, int target, int lo, int hi) {
        if (lo > hi) {
            return false;
        }
        int mid = (lo + hi) / 2;
        int mid_x = mid / matrix[0].length;
        int mid_y = mid % matrix[0].length;
        if (matrix[mid_x][mid_y] > target) {
            return helper(matrix, target, lo, mid - 1);
        } else if (matrix[mid_x][mid_y] < target) {
            return helper(matrix, target, mid + 1, hi);
        } else {
            return true;
        }
    }
}
