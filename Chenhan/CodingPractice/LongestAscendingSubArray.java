/*
Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
*/
public class Solution {
  public int longest(int[] array) {
    // write your solution here
    // M[i] represents the longest ascending subarray before i-th element including i
    // M[i] = M[i - 1] + 1  if A[i] >= A[i - 1]
    //      = 1             otherwise
    if (array.length == 0) {
      return 0;
    }
    int[] lengths = new int[array.length];
    lengths[0] = 1;
    int maxLen = lengths[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        lengths[i] = lengths[i - 1] + 1;
      } else {
        lengths[i] = 1;
      }
      maxLen = Math.max(maxLen, lengths[i]);
    }
    return maxLen;
  }
}