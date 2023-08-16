//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {

    public static int findCatalan(int n) {
        
        int catalan[] = new int[n+2];
        catalan[0] = 1;
        catalan[1] = 1;
        long mod = 1000000007L;
        for(int i = 2; i <= n; i++)
        {
            long ans = 0;
            for(int j = 0; j < i; j++)
            {
                ans = (ans + ((long)catalan[j] * catalan[i-j-1]) % mod ) % mod;
            }
            catalan[i] = (int)ans;
        }
        return catalan[n] ;
    }
}
        
