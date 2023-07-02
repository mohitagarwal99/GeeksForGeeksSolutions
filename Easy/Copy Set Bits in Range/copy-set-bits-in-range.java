//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        int tempx = x;
        x /= Math.pow(2, l-1);
        y /= Math.pow(2, l-1);
        for(int i = l; i <= r; i++)
        {
            if(x % 2 == 0 && y % 2 == 1)
            {
                tempx += Math.pow(2, i-1);
            }
            x = x / 2;
            y = y / 2;
        }
        return tempx;
    }
}