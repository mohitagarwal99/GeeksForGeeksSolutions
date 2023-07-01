//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	char[] array = str.toCharArray();
	    boolean found = false;
	    int i =0;
	    for(char x : array)
	    {
	        if(str.charAt(0) == '-' && i==0)
	        {
	            i = 1;
	            continue;
	        }
	        if(!(x >= '0' && x <= '9') )
	        {
	            found = true;
	            break;
	        }
	    }
	    if(found)
	        return -1;
	    else
	        return Integer.parseInt(str);
    }
}
