//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            ArrayList<Integer> ans = new Solution().repeatedRows(arr, n, m);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i)+" ");
                
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        HashSet<String> set=new HashSet<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int row=0;row<m;row++){
            StringBuilder sb=new StringBuilder();
            int col=0;
            while(col<n){
                int ones=0;
                while(col<n && matrix[row][col]==1){
                    ones++;
                    col++;
                }
                if(ones>0) sb.append("O"+ones);  //O for ones
                int zeros=0;
                while(col<n && matrix[row][col]==0){
                    zeros++;
                    col++;
                }
                if(zeros>0) sb.append("Z"+zeros);  ///Z for zeros
            }
            if(!set.add(sb.toString())) res.add(row);
        }
        return res;
    }
}