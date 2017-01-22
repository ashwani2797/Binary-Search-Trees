/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Mr. Ashwani
 */
public class BestBST {
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
    public void inOrder(Node focusNode) {

        if (focusNode != null) {
            inOrder(focusNode.left);
            System.out.println(focusNode.key);
            inOrder(focusNode.right);
        }

    }
    public void binaryAdd(int arr[],BestBST tree,int left,int right){
        if( left < right){
            
            int mid = (left + right)/2;
            tree.Insert(arr[mid]);
            binaryAdd(arr,tree,left,mid);
            binaryAdd(arr,tree,mid+1,right);
        }
        
    }
    public static void main(String[] args){
        BestBST tree=new BestBST();
        Scanner cin=new Scanner(System.in);
        int n;
        System.out.println("Enter the no. of nodes in trees");
        n=cin.nextInt();
         int arr[]=new int[n];
         for(int i=0;i<n;i++)
             arr[i] = cin.nextInt();
         
        Arrays.sort(arr);
        int right = n;
        int left = 0;
        tree.binaryAdd(arr,tree,0,n);
        tree.inOrder(tree.root);
      System.out.println("Root no" + tree.root.key); 
      System.out.println("Root no" + tree.root.left.key);
      System.out.println("Root no" + tree.root.right.key); 
      System.out.println("Root no" + tree.root.left.left.key);
      System.out.println("Root no" + tree.root.right.left.key); 
    } 
}
