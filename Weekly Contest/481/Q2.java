class Solution {
    public long minCost(String s, int[] cost) {

        long min = Long.MAX_VALUE;

        // Try keeping each character from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            long delCost = 0;

            // Delete all characters not equal to ch
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ch) {
                    delCost += cost[i];
                }
            }

            min = Math.min(min, delCost);
        }

        return min;
    }
}
