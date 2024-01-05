//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int n)
    {
        int mod = 1000000007;
        long a = 1, b = 1;
        long ans;
        for (int i = 1; i <= n; i++) {
            ans = (a + b) % mod;
            a = b;
            b = ans;
        }

        return (int)((b * b) % 1000000007);
        
    }
    
}