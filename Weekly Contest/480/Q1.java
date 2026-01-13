import java.util.Arrays;

class Solution {
    public int absDifference(int[] nums, int k) {

        int n = nums.length;

        // ------------------------------------------------
        // Step 1: Sort the array
        // After sorting:
        // - Smallest elements are on the left
        // - Largest elements are on the right
        // ------------------------------------------------
        Arrays.sort(nums);

        int smalsum = 0;  // sum of k smallest elements
        int larsum = 0;  // sum of k largest elements

        int l = 0;       // left pointer (smallest values)
        int r = n - 1;   // right pointer (largest values)

        // ------------------------------------------------
        // Step 2: Two-pointer approach
        // Pick k smallest from left
        // Pick k largest from right
        //
        // Pattern:
        // Sorting + Two Pointers
        // ------------------------------------------------
        while (l < k) {
            smalsum += nums[l++];   // take smallest
            larsum += nums[r--];   // take largest
        }

        // ------------------------------------------------
        // Step 3: Return absolute difference
        // ------------------------------------------------
        return Math.abs(larsum - smalsum);
    }
}

