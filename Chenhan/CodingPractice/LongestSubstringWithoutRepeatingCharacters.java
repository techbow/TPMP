public class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int start = 0;
    int end = 0;
    int maxL = 0;
    Set<Character> set = new HashSet<Character>();
    while (end < s.length()) {
      if (!set.contains(s.charAt(end))) {
        set.add(s.charAt(end++));
        maxL = Math.max(maxL, end - start);
      } else {
        set.remove(s.charAt(start++));
      }
    }
    return maxL;
  }
}