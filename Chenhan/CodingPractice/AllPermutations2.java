public class Solution {
  public List<String> permutations(String set) {
    // write your solution here
    List<String> result = new ArrayList<String>();
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray();
    permutationsHelper(array, 0, result);
    return result;
  }
  private void permutationsHelper(char[] array, int index, List<String> result) {
    if (index >= array.length) {
      result.add(new String(array));
      return;
    }
    Set<Character> set = new HashSet<Character>();
    for (int i = index; i < array.length; i++) {
      if (set.contains(array[i])) {
        continue;
      }
      set.add(array[i]);
      swap(array, index, i);
      permutationsHelper(array, index + 1, result);
      swap(array, index, i);
    }
  }
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}