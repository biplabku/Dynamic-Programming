public class isMatch {

    // Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

       //     '.' Matches any single character.
       //     '*' Matches zero or more of the preceding element.
    // The matching should cover the entire input string (not partial).

    // Note:

    // s could be empty and contains only lowercase letters a-z.
    // p could be empty and contains only lowercase letters a-z, and characters like . or *.

    public boolean checkMatch(String str, String pattern, int idx1 , int idx2) {
        if(pattern.length() == idx2 && str.length() != idx1) {
            return false;
        }
        if(str.length() < idx1 && pattern.length() < idx2) {
            return false;
        }
        if(str.charAt(idx1) == str.charAt(idx2)) {
            ++idx1;
            ++idx2;
            return checkMatch(str, pattern, idx1, idx2);
        }else if(pattern.charAt(idx2) == '.') {
            ++idx1;
            ++idx2;
            return checkMatch(str, pattern, idx1, idx2);
        }
        else if(pattern.charAt(idx2) == '*') {
            if(pattern.charAt(idx2 - 1) != str.charAt(idx1) || pattern.charAt(idx2 - 1) != '.') {
                ++idx1;
                --idx2;
                return checkMatch(str, pattern, idx1, idx2);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        isMatch match = new isMatch();
        System.out.println(match.checkMatch("aab", "aab", 0, 0));
    }
}
