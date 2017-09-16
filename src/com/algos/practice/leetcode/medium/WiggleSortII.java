package com.algos.practice.leetcode.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by cdeshpande on 9/10/17.
 */
public class WiggleSortII {

    private Random random;


    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        /*
        Algorithm:
        Find median
        Use median to fold the array.
        Lower values goes to odd indexes
        Higher values goes to even indexes
        Lower Value Index starts from lower index values
        HigherValue Index starts from higher index values
        Note: For Even number of elements, median is usually average of two elements in middle indexes,
        here we dont care about median value but an approximate median number.

        Above folding method has an issue
        It requires use of another array or shifting of array elements


        mistake: forgot to account for "start" when the operation goes left for leftSize
         */

        int left = 1;
        int right = nums.length - 1;
        int median = rank(nums, nums.length / 2);
        int middle = nums.length / 2;
        if(nums.length % 2 != 0) {
            // odd numbered size array
            middle = middle + 1;
        }
        System.out.println("median: " + median);
        System.out.println("Before three way partition: " + Arrays.toString(nums));
        threeWayPartition(nums, median);
        System.out.println("After three way partition: " + Arrays.toString(nums));
        int [] smallerThanEqualToMedian = Arrays.copyOfRange(nums, 0, middle);
        int [] largerThanMedian = Arrays.copyOfRange(nums, middle, nums.length);
        merge(smallerThanEqualToMedian, largerThanMedian, nums);
    }


    protected void threeWayPartition(int [] nums, int mid) {
        int left = 0;
        int i = 0;
        int right = nums.length - 1;
        while(i <= right) {

            if(nums[i] < mid) {
                swap(nums, i, left);
                i++;
                left++;
            } else if(nums[i] > mid) {
                swap(nums, i, right);
                right--;
                // Note: in this case, we dont increment i because we wnat to test
                // for the new number that got swapped from right part to current index
                // on left side, this is not an issue as left is sorted as we are moving
                // ahead. in other words i >= left
            } else {
                i++;
            }
        }
    }

    protected void merge(int[] smallerThanEqualToMedian, int[] largerThanMedian, int[] nums) {
        System.out.println(String.format("sm: %s, lg: %s", Arrays.toString(smallerThanEqualToMedian), Arrays.toString
                (largerThanMedian)));
        int smallerArrayIndex = 0;
        int largerArrayIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                // even
                nums[i] = smallerThanEqualToMedian[smallerArrayIndex];
                smallerArrayIndex++;
            } else {
                nums[i] = largerThanMedian[largerArrayIndex];
                largerArrayIndex++;
            }
        }
    }

    /*
    Bug: This function doesnt work when median has duplicate values
    Example: {5,1,4,3,2,3}; median 3 is duplicate
     */
    protected int findKthSmallest(int [] nums, int k) {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        initRandom();
        return findKthSmallest(nums, k, 0, nums.length - 1);
    }

    /**
     * Implementation using partition function.
     *
     * @param nums
     * @param k
     */
    private int findKthSmallest(int [] nums, int k, int start, int end) {

        int pivotIndex = getRandomIndex(start, end);
        int pivot = nums[pivotIndex];

        int leftEnd = partition(nums, start, end, pivot);
        int leftSize = leftEnd - start;
        if(leftSize == k)
            return pivot;

        if(leftSize > k) {
            return findKthSmallest(nums, k, start, leftEnd - 1);
        } else {
            return findKthSmallest(nums, k - leftSize, leftEnd, end);
        }
    }


    protected int partition(int [] nums, int left, int right, int pivot) {

        while(true) {

            while(left <= right && nums[left] <= pivot) {
                left++;
            }

            while(left <= right && nums[right] > pivot) {
                right--;
            }

            if(left > right) {
                return left;
            }

            swap(nums, left, right);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private int getRandomIndex(int start, int end) {
        return random.nextInt((end - start) + 1) + start;
    }

    private void initRandom() {
        random = new Random();
    }

    private int newIndex(int index, int n) {
        int left = (1 + 2*index);
        // n | 1 => if( n is even ): n + 1, else n
        // why we do it, so that mod of higher numbers ( numbers > n ) will result in odd series of numbers
        int right = (n | 1);
        int total = left % right;
        System.out.println(String.format("left: %s, right: %s, total: %s", left, right, total));
        return total;
    }

    public static void main(String[] args) {
        WiggleSortII solve = new WiggleSortII();
        for(int i = 0; i < 10; i++) {
            System.out.println(String.format("%s : %s", i, solve.newIndex(i, 10)));
            System.out.println(String.format("%s | %s = %s", i, 1, i | 1));
        }

    }

    public void wiggleSortInPlace(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left,n), newIndex(i,n));
                left++;
                i++;
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right,n), newIndex(i,n));
                right--;
            }
            else {
                i++;
            }
        }


    }

    private int findKthLargest(int[] nums, int i) {
        return 0;
    }


    /* Get item with rank. */
    public static int rank(int[] array, int rank) {
        return rank(array, 0, array.length - 1, rank);
    }

    /* Get element with rank between left and right indices. */
    public static int rank(int[] array, int left, int right, int rank) {
        int pivot = array[randomIntInRange(left, right)];
        int leftEnd = partitionCtCi(array, left, right, pivot); // returns end of left partition
        int leftSize = leftEnd - left + 1;
        if (rank == leftSize - 1) {
            return max(array, left, leftEnd);
        } else if (rank < leftSize) {
            return rank(array, left, leftEnd, rank);
        } else {
            return rank(array, leftEnd + 1, right, rank - leftSize);
        }
    }

    /* Get largest element in array between left and right indices. */
    public static int max(int[] array, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }
    /* Partition array around pivot such that all elements <= pivot
     * come before all elements > pivot. */
    public static int partitionCtCi(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            if (array[left] > pivot) {
				/* Left is bigger than pivot. Swap it to the right
				 * side, where we know it should be. */
                swapCtci(array, left, right);
                right--;
            } else if (array[right] <= pivot) {
				/* Right is smaller than the pivot. Swap it to the
				 * left side, where we know it should be. */
                swapCtci(array, left, right);
                left++;
            } else {
				/* Left and right are in correct places. Expand both
				 * sides. */
                left++;
                right--;
            }
        }
        return left - 1;
    }

    /* Get random integer within range, inclusive. */
    public static int randomIntInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max + 1 - min) + min;
    }

    /* Swap values at index i and j. */
    public static void swapCtci(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
