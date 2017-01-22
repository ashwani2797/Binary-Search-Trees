/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Mr. Ashwani
 */
public class TopView {
    private Node root = null;
    
    private class Node{
      int key;
      Node left;
      Node right;
      public Node(int key ){
          this.key = key;
          this.left = null;
          this.right = null;
      }
    }
    
    public void Insert(int key){
        root = Insert(root,key);
    }
    private Node Insert(Node n,int key){
        if( n == null)
            return new Node(key);
        if( n.key == key){}
        else if( key > n.key)
            n.right = Insert(n.right,key);
        else
            n.left = Insert(n.left,key);
         return n;
    }
    
    public void top(){
        topLeft(root);
        boolean flag = false;
        topRight(flag,root);
    }
    
    private void topLeft(Node n){
     if( n == null)
         return ;
     topLeft(n.left);
     
     System.out.print(n.key+" ");
        
    }
    
     private void topRight(boolean flag,Node n){
         
     if( n == null)
         return ;
     if(flag){
     System.out.print(n.key+" ");
     
   }
     flag = true;
     topRight(flag,n.right);
     
        
    }
    void printLeaves(Node node) 
    {
        if (node != null) 
        {
            printLeaves(node.left);
  
            // Print it if it is a leaf node
            if (!(node.left == null && node.right == null))
                System.out.print(node.key + " ");
            printLeaves(node.right);
        }
    }
  
    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node) 
    {
        if (node != null) 
        {
            if (node.left != null) 
            {
                  
                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(node.key + " ");
                printBoundaryLeft(node.left);
            } 
            else if (node.right != null) 
            {
                System.out.print(node.key + " ");
                printBoundaryLeft(node.right);
            }
  
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }
  
    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node) 
    {
        if (node != null) 
        {
            if (node.right != null) 
            {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundaryRight(node.right);
                System.out.print(node.key + " ");
            } 
            else if (node.left != null) 
            {
                printBoundaryRight(node.left);
                System.out.print(node.key + " ");
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }
  
    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node node) 
    {
        if (node != null) 
        {
           // System.out.print(node.key + " ");
  
            // Print the left boundary in top-down manner.
           // printBoundaryLeft(node.left);
  
            // Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);
  
            // Print the right boundary in bottom-up manner
           // printBoundaryRight(node.right);
        }
    }
    public void changeKey(int old,int new1){
        Node n=search(root,old);
        n.key = new1;
    }
    
     public Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

         boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }
 
    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (node.key < min || node.key > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.key-1) &&
                isBSTUtil(node.right, node.key+1, max));
    }
    
    
    public static void main(String[] args){
        TopView t=new TopView();
        t.Insert(5);
        t.Insert(6);
        t.Insert(9);
        t.Insert(2);
        t.Insert(4);
        t.Insert(22);
        t.Insert(7);
        t.Insert(3);
       // t.Insert(1);
        //t.top();
        t.printBoundary(t.root);
       // t.changeKey(1,4);
       // t.changeKey(9,8);
       // System.out.println(t.isBST());
       // System.out.println( "ans  = "+Integer.MAX_VALUE);
    }
    
}
