//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        int cur = 0;
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else{
            int prev1 = 0;
            int prev2 = 1;
            for(int i = 2; i <= n; i++)
            {
                cur = (prev1  + prev2) % 1000000007;
                
                prev1 = prev2 % 1000000007;
                prev2 = cur % 1000000007;
            }
        }
        return cur ;
    }
}