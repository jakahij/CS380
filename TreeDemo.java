class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }


   /**
    * Prints a given tree in Pre Order
    * @param root The given tree
    */
   public void preOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      System.out.print(root.value+" ");
      //go left recursively
      preOrderTraversal(root.left);
      //go right recursively
      preOrderTraversal(root.right);
   }


   /**
    * Prints a given tree In Order
    * @param root The given tree
    */
   public void inOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      //go left recursively
      inOrderTraversal(root.left);
      //process the root
      System.out.print(root.value+" ");
      //go right recursively
      inOrderTraversal(root.right);
   }


   /**
    * Prints a given tree in Post Order
    * @param root The given tree
    */
   public void postOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      //go left recursively
      postOrderTraversal(root.left);
      //go right recursively
      postOrderTraversal(root.right);
      //process the root
      System.out.print(root.value+" ");
   }


   /**
    * A method to find the node in the tree with a specific value
    * @param root The given tree
    * @param key The key to find in the tree
    * @return Returns true if the key is found, returns false if key is not found
    */
   public boolean find(Node root, int key) {
      if (root == null) {
         return false;
      }
      if (root.value == key) {
         return true;
      } else if (root.value < key) {
         return find(root.right, key);
      } else {
         return find(root.left, key);
      }
   }


   /**
    * A method to find the node in the tree with a smallest key
    * @param The given tree
    * @return Returns the smallest node value
    */
   public int getMin(Node root){
      if (root == null) {
         return root.value;
      }
      Node current = root;
      while (current.left != null) {
         current = current.left;
      }
      return current.value;
   }



   /**
    * A method to find the node in the tree with a largest key
    * @param The given tree
    * @return Returns the largest node value
    */
   public int getMax(Node root){
	  if (root == null) {
      return root.value;
     }
     Node current = root;
     while (current.right != null) {
      current = current.right;
     }
     return current.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}
