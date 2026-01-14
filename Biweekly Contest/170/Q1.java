class Solution {
    public int minimumFlips(int n) {

        // Convert number to binary string (no leading zeros)
        String s = Integer.toBinaryString(n);

        int i = 0, j = s.length() - 1;
        int count = 0;

        // Compare symmetric characters
        while (i < j) {

            // If bits are different, both need flipping
            if (s.charAt(i) != s.charAt(j)) {
                count++;
            }

            i++;
            j--;
        }

        // Each mismatch requires 2 flips
        return count * 2;
    }
}

