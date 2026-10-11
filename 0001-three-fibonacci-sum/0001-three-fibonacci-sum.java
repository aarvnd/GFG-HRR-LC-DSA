class Solution {
    public boolean threeFibonacciSum(int n) {
        if(n%2 !=0) return false;
        int half = n/2;
        long a = 1, b = 2;
        while(a < half){
            long next = a + b;
            a = b;
            b = next;
        }
        return a == half;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna