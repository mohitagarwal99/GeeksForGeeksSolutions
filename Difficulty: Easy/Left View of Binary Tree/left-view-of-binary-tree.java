//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
    			ArrayList<Integer> result = g.leftView(root);
    			for(int value : result){
    			    System.out.print(value + " ");
    			}
    			System.out.println();
                t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        
      ArrayList<Integer> al = new ArrayList<>();
      if(root == null){
          return al;
      }
    //   al.add(root.data);
    //   recursionLeft(root.left, al);
    //   recursionRight(root.right, al, 2);
      recursionLeft(root, 0, al);
      
      return al;
    }
    
    private void recursionLeft(Node root, int level, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.data);
        }

        recursionLeft(root.left, level + 1, res);
        recursionLeft(root.right, level + 1, res);
    }
    
    // void recursionLeft(Node root, ArrayList<Integer> al){
    //     if(root == null){
    //         return;
    //     }
    //     al.add(root.data);
    //     while(root.left != null || root.right != null){
    //       if(root.left != null){
    //           al.add(root.left.data);
    //           root = root.left;
    //       }
    //       else {
    //           al.add(root.right.data);
    //           root = root.right;
    //       }
    //   }
    // }
    // void recursionRight(Node root, ArrayList<Integer> al, int level){
    //     if(root == null){
    //         return;
    //     }
    //     if(level > al.size()){
            
    //         al.add(root.data);
    //     }
    //     level++;
    //     while(root.left != null || root.right != null){
    //       if(root.left != null){
    //           if(level > al.size())
    //             al.add(root.left.data);
    //           root = root.left;
    //       }
    //       else {
    //           if(level > al.size())
    //             al.add(root.right.data);
    //           root = root.right;
    //       }
    //       level++;
    //   }
    // }
}