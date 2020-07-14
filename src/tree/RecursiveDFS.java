package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecursiveDFS
{
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        Collections.reverse(levels);
        return levels;
    }


    void helper (TreeNode treeNode, int level){

        if(level == levels.size())
            levels.add(new ArrayList<>());

        levels.get(level).add(treeNode.val);
        if(treeNode.left!=null)
            helper(treeNode.left, level+1);
        if(treeNode.right!=null)
            helper(treeNode.right, level+1);

    }

}
