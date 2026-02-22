class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.isEmpty()) {
            return true;
        }
        int n = words.size();
        for (int i = 0; i < n; i++) {
            String row = words.get(i);
            for (int j = 0; j < row.length(); j++) {
                if (j >= n || i >= words.get(j).length() || row.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}