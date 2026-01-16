class Solution {
    public int minOperations(int[] nums) {

        // Step 1: Build a frequency map
        // map stores how many times each number appears in the array
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // idx will store the last index where
        // an element had frequency >= 2
        int idx = -1;

        // Step 2: Traverse the array again
        // If the current number still has frequency >= 2,
        // reduce its count by 1 and update idx
        for (int i = 0; i < nums.length; i++) {

            // Check if the number exists in map and has at least 2 occurrences
            if (map.containsKey(nums[i]) && map.get(nums[i]) >= 2) {

                // Decrease the frequency by 1
                map.put(nums[i], map.get(nums[i]) - 1);

                // If frequency becomes 0, remove it from the map
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                // Update idx to the current index
                // This represents the farthest position where
                // a valid operation could be applied
                idx = i;
            }
        }

        // Step 3: If no valid index was found,
        // it means no operation was possible
        if (idx == -1) return 0;

        // Step 4: Count elements involved in operations
        // cnt is the number of elements up to index idx
        int cnt = idx + 1;

        // Step 5: Calculate minimum operations
        // Each operation can remove 2 or 3 elements
        int mod = cnt % 3;

        // If divisible by 3, use cnt/3 operations
        if (mod == 0) return cnt / 3;

        // Otherwise, one extra operation is needed
        return cnt / 3 + 1;
    }
}

========================================

class Solution {
    public int minOperations(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        int i = nums.length - 1;

        // Find longest suffix with all distinct elements
        while (i >= 0) {
            if (seen.contains(nums[i])) {
                break;
            }
            seen.add(nums[i]);
            i--;
        }

        // Entire array already distinct
        if (i == -1) return 0;

        int count = i + 1;  // prefix length to remove
        return (count + 2) / 3;  // ceil(count / 3)
    }
}

//
We want: ceil(count / 3)
But in integer math, division always rounds down.
So we use this formula:
ceil(a / b) = (a + b - 1) / b
Here:
a = count
b = 3
So:
ceil(count / 3) = (count + 3 - 1) / 3 = (count + 2) / 3
