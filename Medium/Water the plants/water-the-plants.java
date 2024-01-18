//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    // int min_sprinklers(int gallery[], int n)
    // {
    //     List<List<Integer>> list = new LinkedList<>();
    //     for(int i = 0; i < n ; i++)
    //     {
    //         if(gallery[i] != -1){
    //             List<Integer> range = new LinkedList<>();
    //             range.add(i - gallery[i]);
    //             range.add(i + gallery[i]);
    //             list.add(range);
    //         }
    //     }

    //     Collections.sort(list, (list1, list2) -> {
    //         // Compare logic for sorting the LinkedLists
    //         // For example, you can compare based on the size of the LinkedLists
    //         return Integer.compare(list1.size(), list2.size());
    //     });
        
    //     int take = 0, index = 0, ans = 0;
    //     while(take < n){
    //         int max = take-1;
    //         while(index < n && list.get(index).get(0) <= take){
    //             max = Math.max(max, list.get(index++).get(1));
    //         }
    //         if(max + 1 > take){
    //             ++ans;
    //             take = max + 1;
    //         }
    //         else 
    //             return -1;
    //     }
        
    //     return ans;
    
    int min_sprinklers(int arr[], int n)

    {

        int[]arr2=new int[n];

        for(int j=0;j<n;j++)

        {

            if(arr[j]==-1)continue;

            int st=Math.max(0,j-arr[j]),end=Math.min(n-1,j+arr[j]);

            arr2[st]=Math.max(arr2[st],end);

        }

        for(int j=1;j<n;j++)arr2[j]=Math.max(arr2[j],arr2[j-1]);

        int cnt=0,in=0;

        while(in<n)

        {

            cnt++;

            if(in>arr2[in])return -1;

            in=arr2[in]+1;

        }

        return cnt;

    
    }
}
