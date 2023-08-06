//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    ArrayList<String> al = new ArrayList<>();
    public ArrayList<String> permutation(String S)
    {
        per(S, 0, S.length());
        Collections.sort(al);
        return al;
    }
    public void per(String s, int st, int end)
    {
        
        if(st == end)
        {
            //System.out.println(s);
            al.add(s);
        }
        for(int i = st; i < end; i++)
        {
            char[] ca = s.toCharArray();
            char temp = ca[i];
            ca[i] = ca[st];
            ca[st] = temp;
            per(String.valueOf(ca) , st + 1, end);
            
        }

    }
	   
}
