import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class editDistance {

    private static int helper(String s1, String s2) {
        /* s1 = cb , s2 = abc
        *      a b c  (n)
        *    0 1 2 3
        * c  1
        * b  2
        *
        * (m)
        * */
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<n+1; i++){
            dp[0][i] = i;
        }
        for(int i = 0; i<m+1; i++){
            dp[i][0] = i;
        }
        for(int i =1; i< m+1; i++){
            for(int j = 1; j< n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    int min = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    dp[i][j] = min +1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) throws IOException {
        //read line by line:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {

            String line2 = reader.readLine(); //read extra line

            System.out.println(helper(line, line2));
        }
    }


}