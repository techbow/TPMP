public class Solution {
  public String hex(int number) {
    // write your solution here
    if (number == 0) {
      return "0x0";
    }
    StringBuilder sb = new StringBuilder();
    while (number > 0) {
      int remain = number % 16;
      number >>>= 4;
      if (remain <= 9) {
        sb.append((char)(remain + '0'));
      } else {
        sb.append((char)(remain - 10 + 'A'));
      }
    }
    sb.append("x0");
    return sb.reverse().toString();
  }
}