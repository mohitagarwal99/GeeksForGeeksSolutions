//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        ArrayList<Integer> ropen = new ArrayList<>();
        ArrayList<Integer> copen = new ArrayList<>();
        ArrayList<Integer> sopen = new ArrayList<>();
        int rc = -1, sc = -1, cc = -1;
        for(int i = 0; i < x.length(); i++)
        {
            switch(x.charAt(i))
            {
                case '(': ropen.add(i);
                          rc++;
                        break;
                case ')': if(rc == -1)
                            return false;
                    if(i % 2 == ropen.remove(rc) % 2)
                            return false;
                            rc--;
                    break;
                case '{': copen.add(i);
                          cc++;
                    break;
                case '}': if(cc == -1)
                            return false;
                            if(i % 2 == copen.remove(cc) % 2)
                            return false;
                            cc--;
                    break;
                case '[': sopen.add(i);
                          sc++;
                    break;
                case ']':   if(sc == -1)
                                return false;
                            if(i % 2 == sopen.remove(sc) % 2)
                            return false;
                            sc--;
                    break;
            }
        }
        if(rc > -1 || cc > -1 || sc > -1)
        {
            return false;   
        }
        return true;
    }
}
