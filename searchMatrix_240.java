public class searchMatrix_240 {
    /**
     *
     * 240. 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * 解法：
     *      斜角二分查找，左下对角上面的元素都比它小，右边的元素都比它大，
     *      目标值 > 对角元素： 向右移动一列。
     *      目标值 < 对角元素： 向上移动一行。
     *      直到找到或者遍历完整个二维数组。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;
        int M = matrix[0].length;
        // lower left corner
        int row = N - 1;
        int col = 0;

        // start with lower left corner.
        while (row >= 0 && col <= M - 1) {
            if (matrix[row][col] > target) {
                row -= 1;
            } else if (matrix[row][col] < target) {
                col += 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
