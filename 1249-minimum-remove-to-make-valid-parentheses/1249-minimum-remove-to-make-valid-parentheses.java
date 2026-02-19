class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();

        int open = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(') open++;
            else if(arr[i] == ')'){
                if(open > 0) open--;
                else arr[i] = '#';
            }
        }
        int close = 0;
        for(int i = arr.length -1; i >= 0; i--){
            if(arr[i] == ')') close++;
            else if(arr[i] == '('){
                if(close > 0) close--;
                else arr[i] = '#';
            }
        }
            close = 0;
            for(int i = arr.length - 1; i >= 0; i--){
                if(arr[i] == ')') close++;
                else if(arr[i] == '('){
                    if(close > 0 ) close--;
                    else arr[i] = '#';
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : arr){
                if(c != '#') sb.append(c);
            }
            return sb.toString();
        }
    }
        