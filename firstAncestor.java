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
 *
 */
public class firstAncestor {

    private Node root = null;

    private class Node {

        int key;
        int value;
        Node parent;
        Node right;
        Node left;
        int Size;

        //int rightSize;
        public Node(Node parent, int key) {
            this.key = key;
            this.parent = parent;
            this.left = null;
            this.right = null;
            this.Size = 1;
            //this.rightSize=1;
        }
    }

    public void insert(int key, int value) {
        root = insert(null, root, key);
    }

    private Node insert(Node temp, Node n, int key) {
        if (n == null) {
            return new Node(temp, key);
        }
        if (n.key == key) {
        } else if (n.key > key) {
            n.Size += 1;
            n.left = insert(n, n.left, key);

        } else {
            n.Size += 1;
            n.right = insert(n, n.right, key);
        }
        return n;
    }

    public boolean Search(int key) {
        return Search(root, key);
    }

    private boolean Search(Node n, int key) {
        if (n == null) {
            return false;
        }
        if (n.key == key) {
            return true;
        } else if (n.key > key) {
            return Search(n.left, key);
        } else {
            return Search(n.right, key);
        }
    }

    public void FirstCommonAncestor(int key1, int key2) {
        FirstCommonAncestor(root, key1, key2);

    }

    private void FirstCommonAncestor(Node n, int key1, int key2) {
        if ((n.key > key1 && n.key < key2) || (n.key < key1 && n.key > key2)) {
            System.out.println(n.key);
        }
        if (n.key == key1 || n.key == key2) {

            if (n == root) {
                System.out.println("-1");
            } else {
                Node temp = n.parent;
                System.out.println(temp.key);
            }
        }
        if (key1 > n.key && key2 > n.key) {
            FirstCommonAncestor(n.right, key1, key2);
        } else if (key1 < n.key && key2 < n.key) {
            FirstCommonAncestor(n.left, key1, key2);
        }

    }

    public void Rank(int key) {
        rank(root, key);

    }

    private void rank(Node n, int key) {
        if (n == null) {
            return;
        }
        if (n.key == key) {
            if (n.left == null) {
                System.out.println("Rank of node " + key + " = " + n.Size);
            } else {
                System.out.println("Rank of node " + key + " = " + n.left.Size);
            }
        } else if (key > n.key) {
            rank(n.right, key);
        } else {
            rank(n.left, key);
        }

    }

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            inOrderTraverseTree(focusNode.left);
            System.out.println(focusNode.key);
            inOrderTraverseTree(focusNode.right);
        }

    }

    public void delMin() {
        root = delMin(root);
    }

    private Node delMin(Node n) {
        if (n.left == null) {
            return n.right;
        }
        n.left = delMin(n.left);

        return n;
    }

    public void delMax() {
        root = delMax(root);
    }

    private Node delMax(Node n) {
        if (n.right == null) {
            return n.left;
        }
        n.right = delMax(n.right);

        return n;
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public void delNnode(int key) {
        root = delNnode(root, key);
    }

    public Node getMin(Node n) {
        if (n.left == null) {
            return n;
        }
        return getMin(n.left);

    }

    private Node delNnode(Node n, int key) {
        //if( n == null)
        //    return n;
        if (key < n.key) {
            n.left = delNnode(n.left, key);
            return n;
        } else if (key > n.key) {
            n.right = delNnode(n.right, key);
            return n;
        } else {
            if (n.left == null) {
                return n.right;
            }
            if (n.right == null) {
                return n.left;
            } else {
                Node t = n;
                n = getMin(n.right);
                n.right = delMin(t.right);
                n.left = t.left;
                return n;

            }

        }

    }
    
   public int height(Node n){
    if(n == null)
        return 0;
    int leftSize = height(n.left);
    int rightSize = height(n.right);
    
    if(leftSize > rightSize)
        return leftSize+1;
    else
        return rightSize+1;
   }
    public static void main(String[] args) {
        firstAncestor b = new firstAncestor();
        b.insert(1, 2);
        b.insert(3, 2);
        b.insert(2, 2);
        b.insert(5, 2);
        b.insert(4, 2);
        b.insert(6, 2);
        b.insert(7, 2);
        b.insert(9, 2);
        b.insert(8, 2);
        b.insert(11, 2);
        b.insert(13, 2);
        b.insert(12, 2);
        b.insert(10, 2);
        b.insert(15, 2);
        b.insert(14, 2);
      /*  System.out.println(b.Search(998));
        b.FirstCommonAncestor(1, 3);
        b.inOrderTraverseTree(b.root);
        b.Rank(3);
        b.delMax();
        System.out.println("After deleting max");
        b.inOrderTraverseTree(b.root);
        System.out.println("After deleting min");  */
      //  b.delMin();
      //  b.inOrderTraverseTree(b.root);
      //  b.delNnode(4);
       // System.out.println("After deleting Nth node ");
       // b.inOrderTraverseTree(b.root);
        System.out.println("A=height of tree is"+b.height(b.root));
        
    }
}
