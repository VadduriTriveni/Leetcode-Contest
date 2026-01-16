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
