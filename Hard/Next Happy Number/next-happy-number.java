//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int nextHappy(int n){
        ArrayList<Integer> al = new ArrayList<>();
        while(true)
        {
            n++;
            int temp = n;
            while(true){
            int sum = 0;
            while(temp != 0)
            {
                int x = temp % 10;
                sum += x*x;
                temp /= 10;
            }
            //System.out.println(sum);
            if( sum == 2 || sum == 3 || sum == 4 || sum == 5|| sum == 6|| sum == 8|| sum == 9 || al.contains(sum))
                break;
            else if(sum == 1 || sum == 7)
                return n;
            else
            {
                al.add(sum);
                temp = sum;
            }
            }
        }

    }
}