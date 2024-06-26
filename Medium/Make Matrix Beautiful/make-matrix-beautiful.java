//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        int ansCol[] = new int[matrix.length];
        int ansRow[] = new int[matrix.length];
        int row = matrix.length, col = matrix[0].length; int maxR = 0, maxC = 0;
        for(int i = 0; i < row; i++)
        {
            int sum = 0;
            int sum1 = 0;
            for(int j = 0; j < col; j++)
            {
                sum += matrix[i][j];
                sum1 += matrix[j][i];
            }
            maxR = Math.max(sum, maxR);
            maxC = Math.max(sum1, maxC);
            ansRow[i] = sum;
            ansCol[i] = sum1;
        }
        int count1 = 0, count2 = 0;
        for(int i = 0; i < row; i++)
        {
            count1 += (maxR - ansRow[i]);
            count2 += (maxC - ansCol[i]);
        }
        return Math.max(count1, count2);
    }
}
        
