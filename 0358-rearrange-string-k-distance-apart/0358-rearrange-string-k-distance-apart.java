class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }
        Queue<int[]> waitQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            result.append((char)('a' + current[0]));
            current[1]--;
            waitQueue.offer(current);
            if (waitQueue.size() >= k) {
                int[] release = waitQueue.poll();
                if (release[1] > 0) {
                    maxHeap.offer(release);
                }
            }
        }
        return result.length() == s.length() ? result.toString() : "";
    }
}