/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.HashSet;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Set;
/**
 *
 * @author Mr. Ashwani
 */
class Node{
      int key;
      Node left;
      Node right;
      public Node(int key ){
          this.key = key;
          this.left = null;
          this.right = null;
      }
    }
 
class cNode{
         int d;
         Node n;
         public cNode(Node n,int d){
             this.n=n;
             this.d=d;
         }
     }
public class trickytop {
    Node root = null;
    
      
     
    
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
    int count  = 0;
    int ans;
    public int rank(int key){
        count = 0;
        ans = 0;
        inorder(root,key);
        return ans;
    }
    public void inorder(Node p,int key){
        if(p==null)
            return ;
        inorder(p.left,key);
        System.out.print(p.key+" ");
        
        if(p.key == key){
            ans = count;
         return; 
        }
        else{
        count++;
        }
        
        inorder(p.right,key);
        return;
    }
    public static void main(String[] args){
        trickytop tree = new trickytop();
        tree.Insert(15);
        tree.Insert(5);
        tree.Insert(3);
        tree.Insert(7);
        tree.Insert(1);
        tree.Insert(4);
        tree.Insert(20);
        tree.Insert(17);
        tree.Insert(25);
        tree.Insert(16);
        tree.Insert(19);
        tree.Insert(22);
        tree.Insert(30);
       // System.out.println("count "+ tree.rank(16));
       // tree.inorder(tree.root);
        System.out.println();
        cNode p;
        Set <Integer> s = new HashSet();
        Queue <cNode> q = new LinkedList();
        int d=0;
        p=new cNode(tree.root,d);
        q.add(p);
        
     /*   q.add(new cNode(tree.root.left,2));
        q.add(new cNode(tree.root.right,2));
        q.add(new cNode(tree.root.left.right,2));
        q.add(new cNode(tree.root.left.right.right,2));
        q.add(new cNode(tree.root.left.right.right.right,2));
        while(! q.isEmpty()){
            cNode temp = q.remove();
             System.out.print(temp.n.key+" ");
        }
        */
        while(!q.isEmpty()){
            cNode t = q.remove();
           if(!s.contains(t.d))
               System.out.print(t.n.key+" ");
            s.add(t.d);
            d = t.d;
            if(t.n.left != null) q.add(new cNode(t.n.left,d-1));
            if(t.n.right != null) q.add(new cNode(t.n.right,d+1));
        }

    }
}
