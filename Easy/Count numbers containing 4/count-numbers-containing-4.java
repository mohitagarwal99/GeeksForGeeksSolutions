//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countNumberswith4(int n) {
        int count = 0;
        int i = 4;
        while( i<=n){
            int temp = i;
            while( temp >= 4){
                int rem = temp%10;
                if ( rem ==4 )
                {
                    count++;
                    break;
                }
                temp /= 10;
            }
            i++;
        }
        return count;
    }
}
