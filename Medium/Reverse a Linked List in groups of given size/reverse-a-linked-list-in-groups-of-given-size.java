//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    static Node th=null;
    static Node tt=null;
    public static void addFirst(Node curr){
        if(th==null){
            th=curr;
            tt=curr;
        }
        else{
            curr.next=th;
            th=curr;
        }
    }
    public static int length(Node curr){
        int length=0;
        while(curr!=null){
            curr=curr.next;
            length++;
        }
        return length;
    }
    public static Node reverse(Node node, int k)
    {
        //Your code here
        int len=length(node);
        Node oh=null;
        Node ot=null;
        Node curr=node;
        while(len>0){
            for(int i=0;curr!=null && i<k;i++){
               Node forw=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=forw;
                len--;
            }
            if(oh==null){
                oh=th;
                ot=tt;
            }
            else{
             ot.next=th;
             ot=tt;
            }
            th=null;
            tt=null;
        }
         return oh;
    }
}

 