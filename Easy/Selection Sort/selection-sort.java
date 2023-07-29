//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	int  select(int arr[], int j, int n)
	{
	    int min = j;
	    for(int i = j+1; i < n; i++)
	        {
	            if(arr[min] > arr[i])
	                min = i;
	        }
	   return min;
        
	}
	
	void selectionSort(int arr[], int n)
	{
	    for(int i = 0; i < n-1; i++)
	    {
	        int min = i;
	        int s = select(arr, i, n);
	        if(min != s)
    	        swap(arr, min, s);
	    }
	}
	void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}