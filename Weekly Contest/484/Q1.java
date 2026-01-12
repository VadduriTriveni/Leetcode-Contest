class Solution {
    public int residuePrefixes(String s) {

        // HashSet to store distinct characters in the current prefix
        HashSet<Character> hs = new HashSet<>();

        int prefixLen = 0; // length of current prefix
        int count = 0;     // number of residue prefixes

        // Iterate over the string to build prefixes
        for (int i = 0; i < s.length(); i++) {

            // Add current character to HashSet
            // HashSet automatically avoids duplicates
            char ch = s.charAt(i);
            hs.add(ch);

            // Increase prefix length
            prefixLen++;

            // Calculate length modulo 3
            int rem = prefixLen % 3;

            // If number of distinct characters equals len % 3
            // then this prefix is a residue
            if (hs.size() == rem) {
                count++;
            }
        }

        return count;
    }
}
--------------------------------------------------------------------
class Solution {
    public int residuePrefixes(String s) {

        // Frequency array to track character occurrences
        int[] freq = new int[26];

        int count = 0; // number of residue prefixes
        int dis = 0;   // number of distinct characters

        // Traverse each prefix
        for (int i = 0; i < s.length(); i++) {

            // Convert character to index (0 to 25)
            int chn = s.charAt(i) - 'a';

            // If character appears for the first time,
            // it increases the distinct count
            if (freq[chn] == 0) {
                dis++;
            }

            // Increase frequency of current character
            freq[chn]++;

            // (i + 1) represents prefix length
            // Check residue condition
            if (dis == (i + 1) % 3) {
                count++;
            }
        }

        return count;
    }
}
