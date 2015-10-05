/*
Determine if a given integer is power of 2.
*/
public class Solution {
  public boolean isPowerOfTwo(int number) {
    // write your solution here
    if (number <= 0) {
      return false;
    }
    while ((number & 1) == 0) {
      number >>>= 1;
    }
    return number == 1;
  }
}