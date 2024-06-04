//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> set = new ArrayList<>();
        set.add(0);
        for(int i = 0; i < n; i++){
            sums(arr, i , n, set, 0);
        }
        
        
        return set;
    }
    
    void sums(ArrayList<Integer> arr, int i, int n, ArrayList<Integer> set, int sum){
        if(i == n)
            return;
            
        sum += arr.get(i);
        set.add(sum);
        
        for(int j = i+1; j < n; j++){
            sums(arr, j , n, set, sum);
        }
    }
}