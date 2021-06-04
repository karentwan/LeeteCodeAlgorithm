package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 
 * @author wan
 * @date 2021.06.04
 ********************************************/
public class SubrectangleQueries {

    private int[][] data;

    private int m;
    private int n;

    public SubrectangleQueries(int[][] rectangle) {
        data = rectangle;
        m = rectangle.length;
        if( m > 0) n = rectangle[0].length;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                data[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public static void main(String[] args) {

    }

}
