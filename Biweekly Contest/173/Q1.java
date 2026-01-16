class Solution {
    public String reversePrefix(String s, int k) {

        // Convert string to character array since strings are immutable in Java
        char[] arr = s.toCharArray();

        // Initialize two pointers:
        // left starts at beginning, right at k-1 (end of prefix)
        int left = 0, right = k - 1;

        // Reverse only the first k characters using two-pointer technique
        while (left < right) {
            // Swap characters at left and right positions
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers towards the center
            left++;
            right--;
        }

        // Convert the modified character array back to string
        return new String(arr);
    }
}
---------------------------------------------------------------------------------
class Solution {
    public String reversePrefix(String s, int k) {

        // StringBuilder allows easy string manipulation
        StringBuilder sb = new StringBuilder();

        // Take the first k characters, reverse them, and append
        sb.append(new StringBuilder(s.substring(0, k)).reverse());

        // Append the remaining part of the string (from index k to end)
        sb.append(s.substring(k));

        // Convert StringBuilder back to string
        return sb.toString();
    }
}

