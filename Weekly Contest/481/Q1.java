class Solution {
    public int mirrorDistance(int n) {

        // Store original number
        int nCopy = n;

        // rev will store the reversed (mirror) number
        int rev = 0;

        // ------------------------------------------------
        // Reverse the number digit by digit
        //
        // Intuition:
        // - Extract last digit using % 10
        // - Shift existing reversed number left (* 10)
        // - Add extracted digit
        //
        // Pattern:
        // Classic "reverse a number" using math
        // ------------------------------------------------
        while (n > 0) {
            int rem = n % 10;        // get last digit
            rev = rev * 10 + rem;   // build reversed number
            n /= 10;                // remove last digit
        }

        // ------------------------------------------------
        // Mirror distance is the absolute difference
        // between original number and its reverse
        // ------------------------------------------------
        return Math.abs(nCopy - rev);
    }
}

