package offer;

/**
 * @author FL8000
 * ��Ŀ������
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֡�
 * -------------------------------------------------------------
 * ����������ͦ�����ģ���Ҫʵ�����������е����ѵġ�
 * ��Ҫ�ж�ѭ���˳�������ÿһ�ֵĿ�ͷΪ��start�� start������һ�֣�1��1�����ڶ��֣�2��2��
 * ���ֵ� 2 * start < column �� 2 * start < row ʱ�����˳�������
 * ���ž���ѭ�������������������� =�� endX > start
 * ���ϵ��� =�� endY > start
 * ���ҵ��� =�� endX > start && endY > start
 * ���µ��� =�� endX > start && endY - 1 > start
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
