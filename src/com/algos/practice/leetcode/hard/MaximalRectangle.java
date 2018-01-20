package com.algos.practice.leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by cdeshpande on 9/23/17.
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        return usingHeightAndRLDiff_DP(matrix);
    }


    /**
     * This is very hard to understand, try using histogram approach.
     * @param matrix
     * @return
     */
    protected int usingHeightAndRLDiff_DP(char [][] matrix) {
        if(matrix.length == 0)
            return 0;

        int m = matrix.length; // row length
        int n = matrix[0].length; // col length

        int [] left = new int[n];
        int [] right = new int[n];
        int [] height = new int[n];

        Arrays.fill(left, 0);
        Arrays.fill(right,n);
        Arrays.fill(height,0);

        int maxA = 0;
        for(int i=0; i<m; i++) {
            int cur_left=0, cur_right=n;
            for(int j=0; j<n; j++) { // compute height (can do this from either side)
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            for(int j=0; j<n; j++) { // compute left (from left to right)
                if(matrix[i][j]=='1')
                    left[j]=Math.max(left[j],cur_left);
                else {left[j]=0; cur_left=j+1;}
            }
            // compute right (from right to left)
            for(int j=n-1; j>=0; j--) {
                if(matrix[i][j]=='1')
                    right[j]=Math.min(right[j],cur_right);
                else {right[j]=n; cur_right=j;}
            }
            // compute the area of rectangle (can do this from either side)
            for(int j=0; j<n; j++)
                maxA = Math.max(maxA,(right[j]-left[j])*height[j]);
        }
        return maxA;
    }

    protected int usingLargestRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        // height array
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;


        for (int row=0;row<rLen;row++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i=0;i<cLen+1;i++) {
                    if(matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;

                if (s.isEmpty()||h[s.peek()]<=h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }

    public int usingLargestRectangle_2(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestInLine(height);
        for(int i = 1; i < matrix.length; i ++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }

        return result;
    }

    private void resetHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }

    public int largestInLine(int[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            int rightPointer = s.isEmpty() ? -1 : s.peek();
            if(s.isEmpty() || h >= height[rightPointer]){
                s.push(i);
            }else{
                int tp = s.pop();
                int base = (s.isEmpty() ? i : i - 1 - s.peek());
                int area = height[tp] * base;
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;
    }

    protected int usingLargestHistogramIdea(char [][] matrix) {
        /*
        1. process one row at a time
        2. for each row accumulate of generate height array - modify the height array
        height[i] = currRow[i] == '1' ? height[i] + 1 : 0;
        3. Find the max area for that row given the height array
        4. Review max area finding algorithm ( largest histogram algorithm )
        scan the height array
        if stack.isEmpty() || height[stack.peek()] <= height[i]
            stack.push(i)
        else
            while(!stack.isEmpty() || height[stack.peek()] > height[i])
                poppedIndex = stack.pop();
                currHeight = height[poppedIndex]
                left = stack.peek();
                right = i; [3,1,3,2,2]
                           [0,1,2,3,4]
                when i = 5, stack - [1,3,4]
                so when 3 is popped, currHeight = 2 and the base should be 3
                covering index positions {2,3,4}.
                thus left = stack.peek(), right = i - 1.
                base = right - left

         */
        int rowLength = matrix[0].length;
        int [] cumulativeHeights = new int[rowLength];
        int maxArea = 0;
        for(int row = 0; row < matrix.length; row++) {

            for(int col = 0; col < rowLength; col++) {
                cumulativeHeights[col] = matrix[row][col] == '1' ? cumulativeHeights[col] + 1 : 0;
            }
            int area = maximalRectangleEndingAtARow(cumulativeHeights);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    protected int maximalRectangleEndingAtARow(int [] cumulativeHeights) {
        Stack<Integer> stack = new Stack<>();
        int currIndex = 0;
        int maxArea = 0;
        while(currIndex < cumulativeHeights.length) {
            if(stack.isEmpty() || cumulativeHeights[stack.peek()] <= cumulativeHeights[currIndex]) {
                stack.push(currIndex++);
            } else {
                while(!stack.isEmpty() && cumulativeHeights[stack.peek()] > cumulativeHeights[currIndex]) {
                    int area = getAreaForIndex(cumulativeHeights, stack, currIndex);
                    maxArea = Math.max(area, maxArea);
                }
                stack.push(currIndex);
            }
        }

        while(!stack.isEmpty()) {
            int area = getAreaForIndex(cumulativeHeights, stack, currIndex);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;

    }

    private int getAreaForIndex(int[] cumulativeHeights, Stack<Integer> stack, int currIndex) {
        int poppedIndex = stack.pop();
        int currHeight = cumulativeHeights[poppedIndex];
        int base = stack.isEmpty() ? currIndex : currIndex - 1 - stack.peek();
        return currHeight * base;
    }


}
