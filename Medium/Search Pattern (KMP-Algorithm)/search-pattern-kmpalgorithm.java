//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        int patm[] = new int[pat.length()];
        int j = 0;
        ArrayList<Integer> al = new ArrayList<>();
        int i = 1;
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(j))
            {
                patm[i] = ++j;
                // System.out.println(patm[i]);
                i++;
            }
            else
            {
                if(j != 0)
                {
                    j = patm[j-1];
                }
                else
                {
                    i++;
                }
            }
            
        }
        
        i = 0;
        j = 0;
        while(i < txt.length())
        {
            if(pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            else
            {
                if(j != 0){
                    j = patm[j-1];
                }
                else{
                    i++;
                }

            }
            if(j == pat.length())
            {
                al.add(i-pat.length()+1);
                j = patm[j-1];
            }
        }
        
       
        return al;
    }
}