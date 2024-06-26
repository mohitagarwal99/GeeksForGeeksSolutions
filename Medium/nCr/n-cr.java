//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int mod = 1000000007;
    static int nCr(int n, int r)
    {
        // if(r > n)
        //     return 0;
        // if(n-r < r)
        //     r = n-r;
        // long long ans = 1;
        // for(int i = 0; i < r; i++)
        // {
        //     ans = ans * (n-i);
        //     ans = ans / (r)
        //     // System.out.println("up" + up + " n-i" + (n-i));
        // }
        
        // return (int)((up/low) % 1000000007);
        int[][] dp = new int[n + 1][r + 1];

        // Calculate combinations using dynamic programming
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
                }
            }
        }

        return dp[n][r];
    }
}