import java.util.HashSet;

class Solution {
    public int centeredSubarrays(int[] nums) {

        int n = nums.length;        // length of the array
        int count = 0;              // counter for centered subarrays

        // ------------------------------------------------
        // Fix the starting index of the subarray
        // ------------------------------------------------
        for (int i = 0; i < n; i++) {

            int currSum = 0;                // running sum of current subarray
            HashSet<Integer> hs = new HashSet<>();  // store elements in current subarray

            // ------------------------------------------------
            // Expand the subarray to the right
            // ------------------------------------------------
            for (int j = i; j < n; j++) {

                currSum += nums[j];      // update running sum
                hs.add(nums[j]);         // add current element to set

                // ------------------------------------------------
                // Check if the running sum exists in the subarray
                // If yes, it's a centered subarray
                // ------------------------------------------------
                if (hs.contains(currSum)) {
                    count++;
                }
            }
        }

        return count;
    }
}
