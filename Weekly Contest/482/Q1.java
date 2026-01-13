
class Solution {
    public long maximumScore(int[] nums) {

        int n = nums.length;

        // ------------------------------------------------
        // STEP 1: Build suffix minimum array
        // suffMin[i] = minimum value in nums[i ... n-1]
        //
        // Intuition:
        // For a split at index i,
        // we need the minimum element on the RIGHT side (i+1 to n-1).
        // Precomputing this allows O(1) lookup later.
        // ------------------------------------------------
        int[] suffMin = new int[n];
        suffMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }

        // ------------------------------------------------
        // STEP 2: Traverse from left to right
        // - prefSum maintains cumulative sum of left part
        // - MaxScore stores the maximum score found so far
        //
        // Pattern used:
        // Prefix Sum + Suffix Preprocessing
        // ------------------------------------------------
        long prefSum = 0;
        long MaxScore = Long.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            // Build prefix sum dynamically
            prefSum += nums[i];

            // score = prefixSum(i) - suffixMin(i+1)
            long score = prefSum - suffMin[i + 1];

            // Update maximum score
            MaxScore = Math.max(MaxScore, score);
        }

        return MaxScore;
    }
}
