//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        //Sort array based on profit
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job a, Job b){
                return b.profit - a.profit;
            }
        });
        
        
        //New array with size of highest deadline
        int max = 0;
        for(Job job: arr){
            max = Math.max(max, job.deadline);
        }
        
        int res[] = new int[max + 1];
        for(int i = 0; i <= max; i++){
            res[i] = -1;
        }
        
        int jobCount = 0, profit = 0;
        for(Job job: arr){
            for(int j = job.deadline; j > 0; j--){
                if(res[j] == -1){
                    jobCount++;
                    profit += job.profit;
                    res[j] = job.id;
                    break;
                }
            }
        }
        int ans[] = new int[2];
        ans[0] = jobCount;
        ans[1] = profit;
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/