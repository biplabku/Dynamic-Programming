public class longestCommonSubsequence {
    // brute force solution
    // it will be a recursive solution
    public static int getLongestSubsequence(String X, int i, int m, int j, int n, String Y) {
        if(i == m || j == n ) {
            return 0;
        }
        else if(X.charAt(i) == Y.charAt(j)) {
            return 1 + getLongestSubsequence(X, i+1, m, j+1, n, Y);
        }else {
            return Math.max(getLongestSubsequence(X, i, m, j + 1, n, Y), getLongestSubsequence(X, i+1,m, j,n, Y) );
        }
    }


    public static int lcs(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        int[][] LCS = new int[X.length() + 1][Y.length() + 1];
        for(int i = 0; i <= n ; i++) {
            LCS[i][0] = 0;
        }
        for(int i =0; i <= m ; i++) {
            LCS[0][i] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= X.length(); i++) {
            for(int j = 1; j <= Y.length(); j++) {
                if(X.charAt(i -1) == Y.charAt(j-1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    sb.append(X.charAt(i - 1));
                }else {
                    LCS[i][j] = Math.max(LCS[i  - 1][j], LCS[i][j - 1]);
                }
            }
        }

        for(int i = X.length() + 1; i > 0; i--) {
            for(int j = Y.length() + 1; j > 0; j--) {

            }
        }

        System.out.println(sb.toString());
        return LCS[X.length()][Y.length() ];
    }

    // how to get the longest string using the same algorithm.
    // i need to save the smallest match as well as the last match between the two sequence
    // then only i can get the largest sequence from the input string.
    public static String getLargestSequence() {
        return "Not implemnented";
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        System.out.println(getLongestSubsequence(X, 0, 7, 0, 6, Y));
        System.out.println(lcs(X, Y));
    }
}
