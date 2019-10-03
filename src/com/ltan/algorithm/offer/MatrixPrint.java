package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

import java.util.ArrayList;

/**
 * Detail: from Leetcode
 * <p>
 * Created by tanlin on 2019-10-03
 */
public class MatrixPrint {
    /**
     * wenyanliu : https://www.nowcoder.com/questionTerminal/9b4c81a02cd34f76be2659fa0d54342a?f=discussion
     * @param matrix int[][]
     * @return sequence
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> sequence = new ArrayList<>();
        int row = matrix.length;
        int column = 0;
        if (row > 0) {
            column = matrix[0].length;
        } else {
            return sequence;
        }
        int circle = (row <= column ? row - 1 : column - 1) / 2 + 1;
        for (int i = 0; i < circle; i++) {
            // left to right
            for (int j = i; j < column - i; j++) {
                sequence.add(matrix[i][j]);
            }
            // top to bottom
            for (int k = i + 1; k < row - i; k++) {
                sequence.add(matrix[k][column - i - 1]); // -1 => len - 1
            }
            // right to left
            for (int m = column - i - 2; (m >= i && (row - i - 1 != i)); m--) {
                sequence.add(matrix[row - i - 1][m]);
            }
            // bottom to top
            for (int n = row - i - 2; (n > i && (column - i - 1 != i)); n--) {
                sequence.add(matrix[n][i]);
            }
        }
        return sequence;
    }


    public static void run() {
        MatrixPrint matrixPrint = new MatrixPrint();
        int[] nums = Utils.generateArrayByString("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]");
        int[][] matrix = Utils.generateMatrix(nums, 5, 2);
        Utils.printMatrix(matrix);
        ArrayList<Integer> rst = matrixPrint.printMatrix(matrix);
        System.out.println("rst:");
        for (Integer i : rst) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
