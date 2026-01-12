class Solution {
    public String largestEven(String s) {

        // Traverse from the end to find the last '2'
        for (int i = s.length() - 1; i >= 0; i--) {

            // Since only '1' and '2' exist, '2' is the only even digit
            if (s.charAt(i) == '2') {

                // Largest possible result is the prefix ending at this '2'
                return s.substring(0, i + 1);
            }
        }

        // No '2' found → no even number possible
        return "";
    }
}

Comments
// Even numbers can be identified by their last digit
// Do not initialize unnecessary variables
