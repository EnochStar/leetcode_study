package offer;

/**
 * @author FL8000
 * 题目描述：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * -------------------------------------------------------------
 * 分析：题意挺简单理解的，但要实现起来还是有点困难的。
 * 需要判定循环退出条件。每一轮的开头为（start， start）。第一轮（1，1），第二轮（2，2）
 * 发现当 2 * start < column 和 2 * start < row 时满足退出条件。
 * 接着就是循环遍历的条件。从左到右 =》 endX > start
 * 从上到下 =》 endY > start
 * 从右到左 =》 endX > start && endY > start
 * 从下到上 =》 endX > start && endY - 1 > start
 */
public class NumTwentyNine {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] result = new int[row * column];
        int start = 0;
        int index = 0;
        while(2 * start < row && 2 * start < column){
            index = printMatrix(matrix, result, column, row, index, start);
            start++;
        }
        return result;
    }
    public int printMatrix(int[][] matrix, int[] result, int column, int row, int index, int start){
        int endX = column - start - 1;
        int endY = row - start - 1;
        for(int i = start;i <= endX;i++){
            result[index] = matrix[start][i];
            index++;
        }
        if(endY > start){
            for(int i = start + 1;i <= endY;i++){
                result[index] = matrix[i][endX];
                index++;
            }
        }
        if(endX > start && endY > start){
            for(int i = endX-1; i >= start;i--){
                result[index] = matrix[endY][i];
                index++;
            }
        }
        if(endX > start && endY - 1 > start){
            for(int i = endY - 1;i > start;i--){
                result[index] = matrix[i][start];
                index++;
            }
        }
        return index;
    }
}
