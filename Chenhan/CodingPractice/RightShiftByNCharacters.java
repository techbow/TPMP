public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here.
    if (input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    n = n % array.length;
    reverse(array, 0, array.length - 1);
    reverse(array, 0, n - 1);
    reverse(array, n, array.length - 1);
    return new String(array);
  }
  private void reverse(char[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    reverse(array, start + 1, end - 1);
    swap(array, start, end);
  }
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}