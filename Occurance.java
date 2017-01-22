/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication2;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Mr. Ashwani
 */
class TreeNode{
      String key;
      TreeNode left;
      TreeNode right;
      int n;
      public TreeNode(String key ){
          this.key = key;
          this.left = null;
          this.right = null;
          this.n =1;
      
      }
    }
 class BST {
    
     public TreeNode root = null;
    
    
    public void Insert(String key){
        root = Insert(root,key);
    }
    private TreeNode Insert(TreeNode n,String key){
        if( n == null)
            return new TreeNode(key);
        if(key.compareTo(n.key) == 0){
           // if(key.length() >= 10)
              n.n++;
           // else
               // n.n=0;
        }
        else if( key.compareTo(n.key) > 0)
            n.right = Insert(n.right,key);
        else
            n.left = Insert(n.left,key);
         return n;
    }
    public TreeNode inOrder(TreeNode focusNode){
       
        return inOrder(root,0,null);
        
    }
    
     public TreeNode inOrder(TreeNode n,int max,TreeNode occ) {
        if (n == null) 
            return occ;
        if(n.n > max) {
           // occ.max = n.n;
            max = n.n;
            occ = n;
            //System.out.println(max+" "+occ.key);
        }
       occ =  inOrder(n.left,max, occ);        
       occ =  inOrder(n.right,max,occ);
        return occ;
    }            
}
public class Occurance {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        BST tree=new BST();
        String arr=new String();
        File f = new File("C:\\Users\\Mr. Ashwani\\Documents\\NetBeansProjects\\JavaApplication2\\build\\classes\\javaapplication2\\in.txt");
        Scanner scan = new Scanner(f);
        while( scan.hasNext()){
            arr = scan.next();
            if(arr.length() >= 10)
            tree.Insert(arr);
            //System.out.println(arr);
        }
        System.out.println(tree.inOrder(tree.root).key);
        System.out.println("Printing ="+tree.inOrder(tree.root).n);
    }
    }
        
