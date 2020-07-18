package company.recent.amazon.onlineassesment;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubTreeAnotherSubTree
{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // find the first node match in s of subtree t
        List<TreeNode> matches = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(s);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val==t.val)
                matches.add(node);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
        // call symmetric for every match
        for(TreeNode match : matches){
            if(symmetric(match,t))
                return true;
        }
        return false;
    }



    boolean symmetric(TreeNode a, TreeNode b){
        if(a== null && b==null)
            return true;
        if(a==null &&b!=null)
            return false;
        if(a!=null && b== null)
            return false;
        if(a.val!=b.val)
            return false;
        else{
            boolean l =symmetric(a.left, b.left);
            boolean r = symmetric(a.right, b.right);
            if(l&&r)
                return true;
            else
                return false;
        }

    }
}
