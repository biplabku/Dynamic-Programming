import java.util.Collection;

public class isMatch {

    // Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

       //     '.' Matches any single character.
       //     '*' Matches zero or more of the preceding element.
    // The matching should cover the entire input string (not partial).

    // Note:

    // s could be empty and contains only lowercase letters a-z.
    // p could be empty and contains only lowercase letters a-z, and characters like . or *.
    public boolean isMatch(String str, String pattern, int idx1, int idx2) {
        if(pattern.length() == idx2 && str.length() != idx1) {
            return false;
        }
        if(str.length() < idx1 && pattern.length() < idx2) {
            return false;
        }
        if(pattern.charAt(idx2) == '.' || str.charAt(idx1) == str.charAt(idx2)) {
            ++idx1;
            ++idx2;
            return checkMatch(str, pattern, idx1, idx2);
        }
        else if(pattern.charAt(idx2) == '*') {
            if(pattern.charAt(idx2 - 1) != str.charAt(idx1) ) {
                ++idx2;
                return checkMatch(str, pattern, idx1, idx2);
            }else if(pattern.charAt(idx2 - 1) == str.charAt(idx1) || pattern.charAt(idx2) == '.') {
                ++idx1;
                ++idx2;
                return isMatch(str, pattern, idx1, idx2);
            }

        }
        return true;
    }

    // initial solution

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

    // understanding recursivre calls
    public String testRecursive(int index, String str) {
        if(index == 0) {
            return "Am done";
        }
        System.out.println(index);
        if(index == -1) {
            ++index;
            testRecursive(index, "not done");
        }
        return null;
    }

    // using dynamic programming
    public boolean testMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // p[0.., j - 3, j - 2, j - 1] matches empty iff p[j - 1] is '*' and p[0..j - 3] matches empty
        for (int j = 1; j < n; j += 2)
            if (p.charAt(j) == '*')     dp[0][j + 1] = dp[0][j - 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (p.charAt(j - 1) != '*')
                    dp[i][j] = dp[i - 1][j - 1] && isCharMatch(s.charAt(i - 1), p.charAt(j - 1));
                else
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && isCharMatch(s.charAt(i - 1), p.charAt(j - 2));
        return dp[m][n];
    }

    private boolean isCharMatch(char s, char p) {
        return p == '.' || s == p;
    }


    public static void main(String[] args) {
        isMatch match = new isMatch();
        // System.out.println(match.checkMatch("aab", "aab", 0, 0));
        // System.out.println(match.testRecursive(-1, "Not done"));
        // System.out.println(match.isMatch("aa", "a.", 0, 0));
        System.out.println(match.testMatch("aab", "c*a*b"));
    }
}
