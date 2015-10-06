public class Solution {
  public boolean canJump(int[] array) {
    // write your solution here
    // M[i] represents whether can reach i from 0;
    // M[i] = (A[j] >= i - j) if M[j] = true;
    //      = false           otherwise
    boolean[] canJump = new boolean[array.length];
    canJump[0] = true;
    for (int i = 1; i < array.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (canJump[j] && array[j] >= i - j) {
          canJump[i] = true;
          break;
        }
      }
    }
    return canJump[array.length - 1];
  }
}