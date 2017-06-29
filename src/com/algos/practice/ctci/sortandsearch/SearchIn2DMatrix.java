package com.algos.practice.ctci.sortandsearch;

/**
 * Created by cdeshpande on 6/26/17.
 */
public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;

        int heigth = matrix.length;
        int width = matrix[0].length;

        if(matrix[0][0] > target || matrix[heigth-1][width-1] < target)
            return false;

        int head = 0, tail = heigth-1, mid;

        while(head != tail && matrix[tail][0] > target){
            mid = (head+tail+1)/2;

            if(matrix[mid][0] < target)
                head = mid;
            else if(matrix[mid][0] > target)
                tail = mid-1;
            else
                return true;
        }

        int row = tail;
        head = 0;
        tail = width-1;

        while(head <= tail) {
            mid = (head+tail)/2;
            if(matrix[row][mid] < target)
                head = mid + 1;
            else if(matrix[row][mid] > target)
                tail = mid -1;
            else
                return true;
        }
        return false;
    }
}
