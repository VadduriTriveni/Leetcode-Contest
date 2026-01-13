class Solution {

    // Stores all valid word squares
    List<List<String>> anslst;

    public List<List<String>> wordSquares(String[] words) {

        anslst = new ArrayList<>();

        // Backtracking using permutation of words
        solution(new boolean[words.length], new ArrayList<>(), words);

        // Sort results lexicographically by (top, left, right, bottom)
        Collections.sort(anslst, (a, b) -> {
            for (int i = 0; i < 4; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return anslst;
    }

    /**
     * Backtracking function
     * vis[]   -> tracks used words
     * currlst -> current selection of words (top, left, right, bottom)
     */
    void solution(boolean[] vis, ArrayList<String> currlst, String[] words) {

        // Base case: 4 words selected
        if (currlst.size() == 4) {

            // Convert each word into char array for easy index access
            char[] top = currlst.get(0).toCharArray();
            char[] left = currlst.get(1).toCharArray();
            char[] right = currlst.get(2).toCharArray();
            char[] bottom = currlst.get(3).toCharArray();

            // Check the 4 corner constraints
            if (top[0] == left[0] &&          // top-left corner
                top[3] == right[0] &&         // top-right corner
                bottom[0] == left[3] &&       // bottom-left corner
                bottom[3] == right[3]) {      // bottom-right corner

                // Valid word square found
                anslst.add(new ArrayList<>(currlst));
            }

            // Stop further recursion once size == 4
            return;
        }

        // Try adding each unused word
        for (int i = 0; i < words.length; i++) {
            if (!vis[i]) {

                vis[i] = true;                // mark word as used
                currlst.add(words[i]);        // choose word

                solution(vis, currlst, words); // recurse

                // Backtrack
                currlst.remove(currlst.size() - 1);
                vis[i] = false;
            }
        }
    }
}
