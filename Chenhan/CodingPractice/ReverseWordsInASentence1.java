public class Solution {
  public String reverseWords(String input) {
    // write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    int prev = -1;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == ' ') {
        reverse(array, prev + 1, i - 1);
        prev = i;
      } else if (i == array.length - 1) {
        reverse(array, prev + 1, i);
      }
    }
    reverse(array, 0, array.length - 1);
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