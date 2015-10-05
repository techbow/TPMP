/*
Determine if the characters of a given string are all unique.
*/
public class Solution {
  public boolean allUnique(String word) {
    // write your solution here
    int[] bitMap = new int[8];
    for (int i = 0; i < word.length(); i++) {
      int a = (int)word.charAt(i);
      int row = a / 32;
      int mask = 1 << (a % 32);
      if ((mask & bitMap[row]) != 0) {
        return false;
      }
      bitMap[row] |= mask;
    }
    return true;
  }
}