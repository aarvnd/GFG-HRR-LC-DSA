class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int lastPosition = -1;
        int position = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (lastPosition != -1) {
                    maxGap = Math.max(maxGap, position - lastPosition);
                }
                lastPosition = position;
            }
            n >>= 1;
            position++;
        }
        return maxGap;
    }
}