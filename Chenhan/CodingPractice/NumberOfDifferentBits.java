public class Solution {
  public int diffBits(int a, int b) {
    // write your solution here
    int count = 0;
    while (a != 0 || b != 0) {
      if (((a ^ b) & 1) == 1) {
        count++;
      }
      a >>>= 1;
      b >>>= 1;
    }
    return count;
  }
}
