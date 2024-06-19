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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        int low = 2001, max = 0;
        
        for(int i = 0 ; i < R; i++){
            low = Math.min(low, matrix[i][0]);
            max = Math.max(max, matrix[i][C-1]);
        }
        
        int req = (R * C )/2;
        
        
        
        while(low <= max){
            int mid = (low + max) / 2;
            int count = 0;
            for(int i = 0; i < R; i++){
                count += countLesser(matrix, mid, i, C);
            }
            if(count <= req){
                low = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        return low;
    }
    
    int countLesser(int[][] matrix, int mid, int r, int c){
        int count = 0;
        for(int i = 0; i < c; i++){
            if(mid < matrix[r][i]){
                break;
            }
            count++;
        }
        return count;
    }
}