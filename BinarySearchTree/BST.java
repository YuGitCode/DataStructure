import java.util.Scanner;
//Note: this Binary tree uses String as its key. Modification is required if using int as Key
public class BST{
    //Inner TreeNode Class
    private class TreeNode{
        private String key;
        private Object value;
        private TreeNode leftChild;
        private TreeNode rightChild;
        
        public TreeNode(String inKey,Object inValue)
        {
            if(inKey == null)
                throw new IllegalArgumentException("Key cannot be Null");
            key = inKey;
            value = inValue;
            leftChild = null;
            rightChild = null; 
        }

        public String getKey()
        {
            return this.key;
        }

        public Object getValue()
        {
            return this.value;
        }

        public TreeNode getLeft()
        {
            return this.leftChild;
        }

        public TreeNode getRight()
        {
            return this.rightChild;
        }

        public void setRight(TreeNode node)
        {
            this.rightChild = node;
        }

        public void setLeft(TreeNode node)
        { 
            this.leftChild = node;
        }
    }

    private TreeNode root;

    public BST(){
        root = null;
    }

    public Object find(String key)
    {
        return findRec(key,root);
    }

    private Object findRec(String key,TreeNode curNode)
    {
        Object value = null;
        if(curNode == null)
        {
            throw new IllegalArgumentException("Key: "+ key +" not found");
        }
        else if(key.equals(curNode.getKey()))
        {
            value = curNode.getValue();

        }else if(key.compareTo(curNode.getKey())<0)
        {   //if current node key is smaller than go left else go right
            value = findRec(key,curNode.getLeft());
        }else
        {
            value = findRec(key,curNode.getRight());
        }
        return value;
    }

    public void insert(String key,Object value)
    {
        insertRec(key,value,root);
    }

    private TreeNode insertRec(String key, Object data,TreeNode curNode)
    {
        TreeNode updateNode = curNode;
        if(curNode == null)
        {
            updateNode = new TreeNode(key,data);
            if(root==null)
            {
                root = updateNode;
            }  
        }else if(key.equals(curNode.getKey()))//no duplication key allowed
        {
            throw new IllegalArgumentException("Key already exist in tree.");

        }else if(key.compareTo(curNode.getKey())<0)
        {
            curNode.setLeft(insertRec(key,data,curNode.getLeft()));
        }else
        {
            curNode.setRight(insertRec(key,data,curNode.getRight()));
        }
        return updateNode;
    }

    public void delete(String key)
    {
        root = deleteRec(key,root);
    }

    private TreeNode deleteRec(String key, TreeNode curNode)
    {
        TreeNode updateNode = curNode;
        if(curNode == null)
        {
            throw new IllegalArgumentException(key+" Doesn't Exist");

        }else if(key.equals(curNode.getKey()))
        {
            //System.out.println("deleting: "+curNode.getKey());
            updateNode = deleteNode(key,curNode);
            //System.out.println("deleting: "+curNode.getKey());

        }else if(key.compareTo(curNode.getKey())<0)
        {
           // System.out.println("Left: " +" key: "+key+" "+ curNode.getLeft());
            curNode.setLeft(deleteRec(key,curNode.getLeft()));
        }else
        {
           // System.out.println("Left: " +" key: "+key+" "+ curNode.getRight());
            curNode.setRight(deleteRec(key,curNode.getRight()));
        }

        return updateNode;
    }

    private TreeNode deleteNode(String key, TreeNode deleteNode)
    {
        TreeNode updateNode = null;
        if( ( deleteNode.getLeft() == null ) && ( deleteNode.getRight() == null ) )
        {
            //System.out.println("Child is null");
            updateNode = null;//Node has no child
            
        }else if( ( deleteNode.getLeft() != null ) && ( deleteNode.getRight() == null ) )
        {
            updateNode = deleteNode.getLeft();//has a child on the left
            //System.out.println("Deleted Node: " + updateNode.getKey());

        }else if( ( deleteNode.getLeft() == null ) && ( deleteNode.getRight() != null ) )
        {
            updateNode = deleteNode.getRight();//has a child on the right
           // System.out.println("Deleted Node: " + updateNode.getKey());

        }else{
            updateNode = promoteSuccessor(deleteNode.getRight());//has two child.
            if(updateNode != deleteNode.getRight())
            {
                updateNode.setRight(deleteNode.getRight());
            }

            updateNode.setLeft(deleteNode.getLeft());
            
            
        }
        return updateNode;
    }
    //Get the leftmost child of the right subtree
    private TreeNode promoteSuccessor(TreeNode curNode)
    {
        TreeNode successor = curNode;
        if(curNode.getLeft() != null)
        {
            successor = promoteSuccessor(curNode.getLeft());
            if(successor == curNode.getLeft())
            {
                curNode.setLeft(successor.getRight());//parent of successor adopt the right child
            }
        }
        return successor;
    }
    public void display(){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        if(root == null)
        {
            System.out.println("Tree Empty");
        }else
        {
            

            while(choice != 4)
            {
                
                System.out.println("Traversal Method\n\n(1) inOrder\n(2) preOrder\n(3) postOrder\n(4) Exit");
                DSAQueue traversalQueue = new DSAQueue();
                choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                        inOrderRec(root, traversalQueue  );
                        break;

                    case 2:
                        preOrderRec(root,traversalQueue);
                        break;

                    case 3:
                        postOrderRec(root,traversalQueue);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                            break;
                }
                System.out.print("\033[H\033[2J");
                for( Object o : traversalQueue  )
                {
                    System.out.print( o + " " );
                }
                System.out.println("\n");
            }
           
        }

    }


    private void inOrderRec( TreeNode curNode, DSAQueue queue )
    {
        if( curNode != null )
        {
            inOrderRec( curNode.getLeft(), queue );
            queue.enqueue( curNode.getValue() );
            inOrderRec( curNode.getRight(), queue );
   
        }
    }

    private void postOrderRec(TreeNode curNode,DSAQueue queue)
    {
        if( curNode != null )
        {
            postOrderRec( curNode.getLeft(), queue );
            postOrderRec( curNode.getRight(), queue );
            queue.enqueue( curNode.getValue() );
  
        }
    }

    private void preOrderRec(TreeNode curNode,DSAQueue queue)
    {
        if( curNode != null )
        {
            queue.enqueue( curNode.getValue() );
            preOrderRec( curNode.getLeft(), queue );
            preOrderRec( curNode.getRight(), queue );   
  
        }
    }



    public String max()
    {
        String maxKey = "";
        if(root==null)
        {
            throw new IllegalArgumentException("Tree empty");

        }else
        {
            maxKey = maxRec(root);
        }
        return maxKey;
    }

    public String maxRec(TreeNode curNode)
    {
        String maxKey = "";
        if(curNode.getRight()!=null)
        {
            maxKey = maxRec(curNode.getRight());
        }else
        {
            maxKey = curNode.getKey();
        }
        return maxKey;
    }

    public String minRec(TreeNode curNode)
    {
        String minKey = "";
        if(curNode.getLeft()!=null)
        {
            minKey = minRec(curNode.getLeft());
        }else
        {
            minKey = curNode.getKey();
        }
        return minKey;
    }

    public String min()
    {
        String minKey = "";
        if(root==null)
        {
            throw new IllegalArgumentException("Tree empty");

        }else
        {
            minKey = minRec(root);
        }
        return minKey;
    }
    public int height()
    {
        return heightRec(root);
    }

    private int heightRec(TreeNode curNode)
    {
        int curHeight,iLeftHt,iRightHt;
        if(curNode == null)
        {
            curHeight = -1;
        }else
        {
            iLeftHt = heightRec(curNode.getLeft());
            iRightHt = heightRec(curNode.getRight());
            curHeight = Math.max(iLeftHt,iRightHt)+1;
        }
        return curHeight;
    }



}