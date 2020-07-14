package tree;

import utils.TreeNode;

import java.util.Stack;

public class TreeTraversal
{
    void preOrderIterative(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.println(node.val);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
    }



    void inOrderIterative(TreeNode node)
    {
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty())
        {
            if (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;

            }

        }
    }


    void postOrderIterative(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left!=null)
                stack1.push(root.left);
            if(root.right!=null)
                stack1.push(root.right);
        }

        while (!stack2.isEmpty()){
            root =stack2.pop();
            System.out.println(root);

        }

    }

}
