package dp;

public class LongestPalindromeSubString
{

    public static void main(String[] args)
    {
        longestPalindrome("caba");
    }
    static String longestPalindrome(String s)
    {
        // dp approach
        char[] chars = s.toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        // substring of length 1
        for (int i = 0; i < len; i++)
        {
            dp[i][i] = true;

        }

        // substring of two length
        int[] index = { 0, 0 };
        int max = 1;
        for (int i = 0; i < len - 1; i++)
        {
            if (chars[i] == chars[i + 1])
            {
                dp[i][i + 1] = true;
                index = new int[] { i, i + 1 };
                max = 2;
            }
        }

        for (int l = 3; l < len+1; l++)
        {
            for (int i = 0; i + l - 1 < len; l++)
            {
                int j = i + l - 1;
                if (chars[i] == chars[j] && dp[i + 1][j - 1] == true)
                {
                    dp[i][j] = true;
                    if (j - i + 1 > max)
                        max = j - i + 1;
                    index = new int[] { i, j };
                }

            }
        }

        return s.substring(index[0], index[1]+1);
    }
}
