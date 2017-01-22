package javaapplication2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *

import java.util.Stack;

/**
 *
 * @author Mr. Ashwani
 */
  class TreeNode{
      int key;
      TreeNode left;
      TreeNode right;
      int x;
      public TreeNode(int x,int key ){
          this.key = key;
          this.left = null;
          this.right = null;
          this.x=x;
      }
    }
   
class LinkNode{
   TreeNode  data;
    LinkNode next;
    public LinkNode(TreeNode x){
        data  =x;
        next=null;
    }
}

class Sll{
LinkNode start = null;

public void push(TreeNode key){
LinkNode newOne=new LinkNode(key);
if(start == null)
    start = newOne;
else{
    newOne.next = start;
    start = newOne;
}
}

public TreeNode pop(){
   if(start == null)
       return null;
   else if(start.next == null){
       TreeNode x= start.data;
       start = null;
       return x;
   }
   else{
       LinkNode curr=start;
       while(curr.next.next != null){
           curr=curr.next;
       }
       
       TreeNode key = curr.next.data;
       
       curr.next = null;
       return key;
   }
}

public void display(){
        LinkNode temp;
        temp = start;
        while(temp != null){
            System.out.print(temp.data.key+" ");
            temp = temp.next;
        }
}

public boolean isEmpty(){
    if(start==null)
        return true;
    else
        return false;
}
}
 class BST {
    
     public TreeNode root = null;
    
    
    public void Insert(int key){
        root = Insert(root,key,0);
    }
    private TreeNode Insert(TreeNode n,int key,int x){
        if( n == null)
            return new TreeNode(x,key);
        if( n.key == key){}
        else if( key > n.key){
            x++;
            n.right = Insert(n.right,key,x);
        }
        else{
            x--;
            n.left = Insert(n.left,key,x);
        }
            
         return n;
    }
    
     public void inOrder(TreeNode focusNode) {

        if (focusNode != null) {
            inOrder(focusNode.left);
            System.out.println(focusNode.key);
            inOrder(focusNode.right);
        }

    }
    
}
public class levelOrder{
    public static void main(String[] args){
     // Sll ls=new Sll();
     Queue <TreeNode>queue = new LinkedList<>();
      Stack st= new Stack();
      BST tree=new BST();
      
      
      tree.Insert(10);
      tree.Insert(9);
      tree.Insert(2);
      tree.Insert(1);
      tree.Insert(3);
      tree.Insert(4);
      tree.Insert(5);
      tree.Insert(6);
      tree.Insert(7);
      tree.Insert(8);
      tree.Insert(12);
      tree.Insert(11);
      tree.Insert(13);
      queue.add(tree.root);
      //ls.push(tree.root);
    
//tree.inOrder(tree.root);
      TreeNode x;
      while(queue.isEmpty() != true){
         
        
            x = queue.remove();
        System.out.println(x.key);
        if( x.left != null )
        queue.add(x.left);
        if(x.right!=null)
        queue.add(x.right);
      }

   //   ls.display();nn n
    
    
      
    }
}
    

