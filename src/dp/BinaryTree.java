package dp;

import utils.TreeNode;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree
{
    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

      TreeNode node=  lowestCommonAncestor(node1,node6,node7);
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node1);
        stack2.push(node1);
         searchBinaryTree(node1,4, stack1);
         searchBinaryTree(node1,5, stack2);

        Iterator<TreeNode> itr1 = stack1.iterator();
        Iterator<TreeNode> itr2 = stack2.iterator();
        TreeNode n1 = itr1.next();
        TreeNode n2 = itr2.next();
        TreeNode lca = null;
        while (n1==n2){
            lca = n1;
           n1 = itr1.next();
           n2= itr2.next();
        }
        System.out.println();
    }


   static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);  //5
        TreeNode right = lowestCommonAncestor(root.right,p,q);  //

        if(left!=null && right!=null){
            return root;
        } else if(left == null && right !=null){
            return right;
        } else if(right == null && left !=null){
            return left;
        }else{
            return null;
        }
    }
   static boolean searchBinaryTree(TreeNode root, int val, Stack<TreeNode> parentStack){
        if(root == null)
            return false;

        if(root.val == val)
            return true;

        if(root.left!=null )
        {
            parentStack.push(root.left);
            if(searchBinaryTree(root.left,val,parentStack))
            return true;
            parentStack.pop();
        }
        if(root.right!=null){
            parentStack.push(root.right);
            if(searchBinaryTree(root.right, val,parentStack))
            return true;
            parentStack.pop();
        }

        return false;
    }
}
