public class Solution {
  public String reverse(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    reverseHelper(array, 0, array.length - 1);
    return new String(array);
  }
  private void reverseHelper(char[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    reverseHelper(array, start + 1, end - 1);
    swap(array, start, end);
  }
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}