//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        if(first == null)
            return second;
        if(second == null)
            return first;
        first = reverseFun(first);
        second = reverseFun(second);
        Node ans = null;
        int car = 0;
        while(first != null && second != null)
        {
            int num = first.data + second.data + car;
            Node temp = new Node(num % 10);
            car = num / 10;
            temp.next = ans;
            ans = temp;
            first = first.next; second = second.next;
        }
        while(first != null){
            int num = first.data + car;
            Node temp = new Node(num % 10);
            car = num / 10;
            temp.next = ans;
            ans = temp;
            first = first.next; 
        }
        while(second != null){
            int num = second.data + car;
            Node temp = new Node(num % 10);
            car = num / 10;
            temp.next = ans;
            ans = temp;
            second = second.next;
        }
        if(car == 0)
            return ans;
        else{
            Node new1 = new Node(1);
            new1.next = ans;
            return new1;
        }
    }
    static Node reverseFun(Node head){
        Node current = head;
        Node previous = null;
        Node temp = null;
        while(current != null){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}