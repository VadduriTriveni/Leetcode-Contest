class Solution {

    // Prime check
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public boolean completePrime(int num) {

        String nums = String.valueOf(num);
        int n = nums.length();
        String temp = "";

        // Check all prefixes
        for (int i = 0; i < n; i++) {
            temp += nums.charAt(i);
            int val = Integer.parseInt(temp);
            if (!isPrime(val)) return false;
        }

        temp = "";

        // Check all suffixes
        for (int i = n - 1; i >= 0; i--) {
            temp = nums.charAt(i) + temp;
            int val = Integer.parseInt(temp);
            if (!isPrime(val)) return false;
        }

        return true;
    }
}

