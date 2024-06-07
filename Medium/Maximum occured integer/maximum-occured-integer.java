//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking size of array
            int n = Integer.parseInt(br.readLine().trim());
            int l[] = new int[n];
            int r[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to array L
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int maxx = Integer.MIN_VALUE;

            // adding elements to array R
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(inputLine[i]);
                if (r[i] > maxx) {
                    maxx = r[i];
                }
            }

            Solution obj = new Solution();

            // calling maxOccured() function
            System.out.println(obj.maxOccured(n, l, r, maxx));
        }
    }
}


// } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000

class Solution {
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int n, int l[], int r[], int maxx) {
    //     int maxE = 0, maxCount = 0, currCount;
        
    //     int arr[][] = new int[n][2];
    //     for(int i = 0; i < n; i++){
    //         arr[i][0] = l[i];
    //         arr[i][1] = r[i];
    //     }
    //     Arrays.sort(arr, new Comparator<int[]>() {
    //         @Override
    //         public int compare(int[] a, int[] b) {
    //             return Integer.compare(a[0], b[0]);
    //         }
    //     });
        
    //     for(int i = 0; i < n; i++){
            
    //         currCount = 0;
    //         for(int j = 0; j < n && arr[j][0] <= arr[i][0]; j++){
                
                
    //             // System.out.println(l[j] + " "+ l[i]);
            
    //             if(arr[j][1] >= arr[i][0] ){
    //                 // System.out.println("Under if " + l[j] + " "+ l[i]);
    //                 currCount++;
                    
    //             }
    //         }
    //         if(currCount > maxCount){
    //             // System.out.println("Max "+ l[i] + " Count "+ currCount);
    //             maxE = arr[i][0];
    //             maxCount = currCount;
    //         }
           
    //     }
    //     return maxE;
    
        int hash[] = new int[maxx+2];
        hash[maxx+1] = -1;
        
        for(int i = 0; i < n; i++){
            
            hash[l[i]]++;
            hash[r[i]+1]--;
        }
        int maxE = 0, maxCount = 0, currCount = 0;
        for(int i = 0; i <= maxx; i++){
            currCount += hash[i];
            if(currCount > maxCount){
                maxCount = currCount;
                maxE = i;
            }
        }
        return maxE;
    }
}

//{ Driver Code Starts.

// } Driver Code Ends