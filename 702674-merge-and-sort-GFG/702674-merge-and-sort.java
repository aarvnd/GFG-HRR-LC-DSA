class Solution {
    public ArrayList<Integer> mergeNsort(int[] arr1, int[] arr2) {
     TreeSet<Integer> set = new TreeSet<>();
     
     for(int x : arr1) set.add(x);
     for(int x : arr2) set.add(x);
     
     return new ArrayList<>(set);
 
        
    }
}
