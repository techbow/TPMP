public class Solution {
  public List<String> validParentheses(int n) {
    // write your solution here
    List<String> result = new ArrayList<String>();
    if (n < 0) {
      return result;
    }
    StringBuilder sb = new StringBuilder();
    helper(n, 0, 0, sb, result);
    return result;
  }
  private void helper(int n, int left, int right, StringBuilder sb, List<String> result) {
    if (left == n && right == n) {
      result.add(sb.toString());
      return;
    }
    if (left < n) {
      sb.append('(');
      helper(n, left + 1, right, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (left > right) {
      sb.append(')');
      helper(n, left, right + 1, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}