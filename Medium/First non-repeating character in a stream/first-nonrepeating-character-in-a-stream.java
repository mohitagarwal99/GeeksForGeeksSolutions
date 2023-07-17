//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
         StringBuilder ans = new StringBuilder();

        int arr[] = new int[26];
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (arr[ch - 'a'] == 0) {
                list.add(ch);
            }

            arr[ch - 'a']++;

            int flag = 0;
            int m = list.size();

            for (int j = 0; j < m; j++) {
                char chs = list.get(j);

                if (arr[chs - 'a'] == 1) {
                    ans.append(chs);
                    flag = 1;
                    break;
                }

            }
            if (flag == 0) {
                ans.append("#");
            }

        }


        return ans.toString();
        //Time limit exceeded
        // String ans = "";
        // ArrayList<Character> al = new ArrayList<>();
        // int arr[] = new int[26];
        // for(int i = 0; i < A.length(); i++)
        // {
        //     char temp = A.charAt(i);
        //     arr[temp - 97]++;

        //     if(arr[temp-97] == 1)
        //     {
        //         al.add(temp);
        //         ans += al.get(0);
        //         continue;
        //     }
        //     if(al.size() == 0)
        //     {
        //         ans += "#";
        //         continue;
        //     }
                
        //     if(temp == al.get(0))
        //     {
        //         al.remove((Character)temp);
        //         if(al.size() == 0)
        //             ans += "#";
        //         else
        //             ans += al.get(0);
        //             continue;
        //     }
        //     else
        //     {
        //         al.remove((Character)temp);
        //         ans += al.get(0);
        //     }
        // }
        // return ans;
    }
}