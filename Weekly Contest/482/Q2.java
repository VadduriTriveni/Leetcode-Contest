class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        // If no items are required
        if (need1 == 0 && need2 == 0) return 0;

        long ans = Long.MAX_VALUE;

        // Strategy 1: Buy type1 and type2 separately
        ans = Math.min(ans,
                (long) need1 * cost1 + (long) need2 * cost2);

        // Strategy 2: Use typeBoth only for overlap
        int common = Math.min(need1, need2);
        long costOverlap =
                (long) common * costBoth +
                (long) (need1 - common) * cost1 +
                (long) (need2 - common) * cost2;

        ans = Math.min(ans, costOverlap);

        // Strategy 3: Overshoot with typeBoth
        // Valid only if typeBoth is cheaper than at least one single type
        if (costBoth < cost1 || costBoth < cost2) {
            ans = Math.min(ans,
                    (long) Math.max(need1, need2) * costBoth);
        }

        return ans;
    }
}
