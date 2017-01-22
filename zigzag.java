
package javaapplication2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mr. Ashwani
 */
import java.util.Stack;

public class zigzag {
    public static void main(String[] args){
     
         BST tree = new BST();
        Stack curr = new Stack();
        Stack nextlevel = new Stack();
        boolean flag = true;
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
     // tree.inOrder(tree.root);
        curr.push(tree.root);
        TreeNode x;
        while(!( curr.empty() && nextlevel.empty())){
         
            while(!curr.empty()){
                 x = (TreeNode)curr.pop();
                 System.out.print(x.key + " ");
                if(flag){
                    if(x.left  != null)
                    nextlevel.push(x.left);
                    if(x.right!=null)
                    nextlevel.push(x.right);
                }
                else{
                    if(x.right!=null)
                    nextlevel.push(x.right);
                    if(x.left!=null)
                    nextlevel.push(x.left);
                }
            }
                curr = nextlevel;
                nextlevel = new Stack();
                flag = !flag;
            
        }
            
    }
}
