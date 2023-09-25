//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> al = new ArrayList<Integer>();
        int arr[] = new int[n+1];
        for(int i = 2; i*i <= n; i++)
        {
            if(arr[i] != 1)
            {
                for(int j = i*i; j <= n; j+=i)
                {
                    arr[j] = 1;
                }
            }
        }
        for(int i = 2; i < n+1; i++)
        {
            if(arr[i] == 0)
                al.add(i);
        }
        return al;
    }
}