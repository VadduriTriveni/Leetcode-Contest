class Solution {
    public String reverseWords(String s) {

        String[] words = s.split(" ");

        // Step 1: Count vowels in the first word
        int firstVowelCount = vowelCount(words[0]);

        StringBuilder sb = new StringBuilder();

        // Step 2: Append first word as-is
        sb.append(words[0]);

        // Step 3: Process remaining words
        for (int i = 1; i < words.length; i++) {
            sb.append(" "); // add space before every new word

            // If vowel count matches, reverse the word
            if (vowelCount(words[i]) == firstVowelCount) {
                sb.append(reverse(words[i]));
            } else {
                sb.append(words[i]);
            }
        }

        return sb.toString();
    }

    // Helper function to count vowels
    int vowelCount(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    // Helper function to reverse a string
    String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
