public class Solution {
  public int maxProduct(int n) {
    // write your solution here
    // M[i] represents the max product can be made by cutting the rope with length i
    // M[i] = max(M[i - n] * n)
    int[] maxP = new int[n + 1];
    maxP[0] = 0;
    maxP[1] = 0;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i / 2; j++) {
        maxP[i] = Math.max(maxP[i], Math.max(maxP[i - j], i - j) * j);
      }
    }
    return maxP[n];
  }
}