
class TreeNode1{
      float key;
      TreeNode1 left;
      TreeNode1 right;
      int n;
      public TreeNode1(float key ){
          this.key = key;
          this.left = null;
          this.right = null;
          this.n =1;
      
      }
    }

 class BST1 {
    
     public TreeNode1 root = null;
    
    
    public void Insert(float key){
        root = Insert(root,key);
    }
    private TreeNode1 Insert(TreeNode1 n,float key){
        if( n == null)
            return new TreeNode1(key);
        if(n.key == key){
           // if(key.length() >= 10)
              n.n++;
           // else
               // n.n=0;
        }
        else if( key > n.key)
            n.right = Insert(n.right,key);
        else
            n.left = Insert(n.left,key);
         return n;
    }
     
        TreeNode1 floor(TreeNode1 x,int val){
        if(x == null) return null;
        if( x.key == val) return x;
        else if( val < x.key) return floor(x.left,val);
        else{
            TreeNode1 t=floor(x.right,val);
            if( t!= null) return t;
            return x;
        }
    }
}
public class Floor{
 
    public static void main(String[] args){
        BST1 tree=new BST1();
        tree.Insert(float(4.1));
        tree.Insert(3.4);
        tree.Insert(3.1);
        tree.Insert(3.8);
        tree.Insert(3.6);
        tree.Insert(4.8);
        tree.Insert(4.9);
        
        System.out.println(tree.floor(tree.root,Math.floor(2.1)).key);
        
        
    }
    
}
