//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	int findK(int A[][], int n, int m, int k)
    {
        int l = 0, i = 0, j = 0, count = 0;
        boolean hor = true, ver = true;
    	while(n > 0 || m > 0)
    	{
    	    if(l % 2 == 0)// horizontally
    	    {
    	        if(hor)//horizontally forward
    	        {
    	            for( int a = 0 ; a < m; a++, j++)
    	            {
    	                count++;
    	                if(count == k)
    	                    return A[i][j];
    	            }
    	            j--;
    	            i++;
    	            n--;
    	            hor = false;
    	        }
    	        else// horizontally backward
    	        {
    	            for(int a = 0; a < m; a++, j--)
    	            {
    	                count++;
    	                if(count == k)
    	                    return A[i][j];
    	            }
    	            j++;
    	            i--;
    	            n--;
    	            hor = true;
    	        }
    	        l++;
    	    }
    	    else //vertically
    	    {
    	        if(ver)//vertically downward
    	        {
    	            for(int b = 0 ; b < n; b++, i++)
    	            {
    	                count++;
    	                if(count == k)
    	                    return A[i][j];
    	                   
    	            }
    	            i--;
    	            j--;
    	            m--;
    	            ver = false;
    	        }
    	        else // vertically upward
    	        {
    	            for(int b = 0; b < n; b++, i--)
    	            {
    	                count++;
    	                if(count == k)
    	                    return A[i][j];
    	               
    	            }
    	            i++;
    	            j++;
    	            m--;
    	            ver= true;
    	        }
    	        l++;
    	    }
    	}
    	return 0;
    }
}