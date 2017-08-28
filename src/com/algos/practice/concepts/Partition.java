package com.algos.practice.concepts;

import java.util.Arrays;

/**
 * Created by cdeshpande on 8/24/17.
 */
public class Partition {

    public int parition(int [] array, int left, int right, int pivot) {
        while (true) {
            while(left <= right && array[left] <= pivot) {
                left++;
            }

            while(left <= right && array[right] > pivot) {
                right--;
            }

            if(left > right) {
                return left - 1;
            }

            swap(array, left, right);
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{5,9,1,2,7};
        int prt = new Partition().parition(arr, 0, 4, 9);
        System.out.println("Partition: " + prt);
        System.out.println("Array: " + Arrays.toString(arr));
    }

}
