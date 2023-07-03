//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        int min[] = new int[n]; // minimum form left
        int max[] = new int[n]; // maximum from right
        min[0] = arr[0];
        for(int i =1; i < n; i++)
        {
            min[i] = Math.min(min[i-1], arr[i]);
        }
        max[n-1] = arr[n-1];
        for(int i = n-2; i>= 0; i--)
        {
            max[i] = Math.max(max[i+1], arr[i]);
        }
        int maxDiff = 0;
        int i = 0, j =0;
        while( i<n && j<n)
        {
            if(min[i]<=max[j])
            {
                int diff = j-i;
                maxDiff = Math.max(maxDiff, diff);
                j++;
            }
            else{
                i++;
            }
        }
        return maxDiff;
    }
}