class Solution {
    public int countBinarySubstrings(String s) {
       int previous = 0; // pichle group ki size
       int current = 1; // abhi wale group ki size
       int answer = 0; // final answer

       for(int i = 1; i < s.length(); i++){
        if(s.charAt(i) == s.charAt(i - 1)){
            current++; //same character hai toh current group badhega
        } else{
            answer += Math.min(previous, current); //pichle or current ka minimum select karenge
            previous = current; // current ko previous mein bana denge
            current = 1; // naya group start 1 se hoga
        }
       }
       answer += Math.min(previous, current); // last pair 
       return answer;
    }
}