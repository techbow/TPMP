/*
Word “book” can be abbreviated to 4, b3, b2k, etc. 
Given a string and an abbreviation, return if the string matches the abbreviation.
*/
public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here.
    //input and pattern not null
    return helper(input, pattern, 0, 0);
  }
  private boolean helper(String input, String pattern, int inputS, int patternS) {
    if (inputS == input.length() && patternS == pattern.length()) {
      return true;
    } else if (inputS >= input.length() || patternS >= pattern.length()) {
      return false;
    }
    if (isDigit(pattern.charAt(patternS))) {
      int num = 0;
      while (patternS < pattern.length() && isDigit(pattern.charAt(patternS))) {
        num = num * 10 + (pattern.charAt(patternS++) - '0');
      }
      return helper(input, pattern, inputS + num, patternS);
    } else {
      if (input.charAt(inputS) == pattern.charAt(patternS)) {
        return helper(input, pattern, inputS + 1, patternS + 1);
      } else {
        return false;
      }
    }
  }
  private boolean isDigit(char a) {
    if (a >= '0' && a <= '9') {
      return true;
    } else {
      return false;
    }
  }
}