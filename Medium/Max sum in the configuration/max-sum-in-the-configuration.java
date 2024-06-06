//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        // Calculate sum first
        
        long sum = 0, max = 0;
        for(int i = 0; i < n; i++){
            sum += (long)a[i];
            max += (long)i * (long)a[i];
        }
        
        long curr = max;
        
        //Find maximum
        // At each interval sum is increased by sum of all elements
        // And is decreased by n * ith element
        
        for(int i = 1; i < n; i++){
            // System.out.println(curr);
            curr = curr + sum - (long)n * (long)a[n-i];
            max = Math.max(max, curr);
        }
        
        return max;
        
        
    }
}
