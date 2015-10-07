public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        if(s == null || n == 0){
            return true;
        }
        boolean[] canSegment = new boolean[n + 1];
        canSegment[0] = true;
        for (int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(canSegment[j] && wordDict.contains(s.substring(j, i))){
                    canSegment[i] = true;
                }
            }
        }
        return canSegment[n];
    }
}