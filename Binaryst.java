/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Mr. Ashwani
 *
 * */



public class Binaryst
{
    private Node root=null;
    
        private class Node{
        int key;
        int value;
        Node right;
        Node left;
        public Node(int key)
        {
            this.key=key;
            this.left=null;
            this.right=null;
        }
}
public void insert(int key,int value)
{
    root = insert(root,key);
}

private Node insert(Node n,int key)
{
    if(n==null)
        return new Node(key);
    if(n.key == key){}
    else if(n.key > key)
        n.left = insert(n.left,key);
    else
        n.right = insert(n.right,key);
return n;
}

public boolean Search(int key){
    return Search(root,key);
}
private boolean Search(Node n,int key){
    if( n==null )
           return false;
    if ( n.key == key)
            return true;
    else if ( n.key > key )
            return Search(n.left,key);
    else    
            return Search(n.right,key);
}

public static void main(String[] args)
{
    Binaryst b = new Binaryst();
    b.insert(4,2);
    b.insert(3,2);
    b.insert(5,2);
    b.insert(7,2);
    System.out.println(b.Search(998));
}

}
    

