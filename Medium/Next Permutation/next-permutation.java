//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        List<Integer> list = new ArrayList<>();
        boolean found = false;
        int k = -1, l = -1;
        for(int i = 0; i < N-1; i++)
        {
            if(arr[i] < arr[i+1])
            {
                found = true;
                k = i;
            }
        }
        if(!found)
        {
            Arrays.sort(arr);
            for (int i : arr)
                {
                   list.add(i);
                }
           return list;
        }
        
        for(int i = k+1; i < N; i++)
        {
            if(arr[k] < arr[i])
            {
                l = i;
            }
        }
        int temp = arr[k];
        arr[k] = arr[l];
        arr[l] = temp;
        for(int i = 0; i <= k; i++)
        {
            list.add(arr[i]);
        }
        for(int i = N-1; i >= k+1; i--){
            list.add(arr[i]);
        }
        return list;
    }
}