//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int left = 0;;
        int max = -1;
        for(int i = 0; i < len; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c, 0)+1);
            
            while(map.size() > k)
            {
                char temp = s.charAt(left);
                map.put(temp, map.get(temp) - 1);
                if(map.get(temp) == 0)
                    map.remove(temp);
                left++;
            }
            if(map.size() == k)
            {
                max = Math.max(max, i-left+1);
            }
        }
        return max;
    }
}