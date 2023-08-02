//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
   int shortestDistance(int N, int M, int A[][], int X, int Y) {
       // code here
       if(X==0 && Y==0)return 0;
       Queue<Pair> q=new LinkedList<>();
       boolean visited[][]=new boolean[N][M];
       int count=0;
       if(A[0][0]==0)return -1;
       
       int row[]={1,0,-1,0};
       int col[]={0,1,0,-1};
       
       q.add(new Pair(0,0));
       visited[0][0]=true;
       while(!q.isEmpty()){
           int n=q.size();
           count++;
       //    System.out.println(n);
           for(int i=0;i<n;i++){
               Pair c=q.remove();
             for(int j=0;j<4;j++){
                 int a=c.x+row[j];
                 int b=c.y+col[j];
                 if(a>=N || b>=M || a<0 || b<0 || visited[a][b] || A[a][b]==0)continue;
                q.add(new Pair(a,b));
                if(a==X && b==Y)return count;
                visited[a][b]=true;
              }
               
           }
       }
       return -1;
       
   }
   
   class Pair{
       int x;
       int y;
       Pair(int x,int y){
           this.x=x;
           this.y=y;
       }
   }
};