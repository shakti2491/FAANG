package company.recent.facebook;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class ListBelongSingleBT
{
    public boolean isValid(List<TreeNode> nodes){

        // first fill the set with all children


        HashSet<TreeNode> children = new HashSet<> ();
        // child node only has one parent node
        for (TreeNode node : nodes) {
            if (node.left != null) {
                if (!children.add(node.left)) return false ;
            }
            if (node.right != null) {
                if (!children.add(node.right)) return false ;
            }
        }

        TreeNode start = null ;
        int count = 0 ;
        for (TreeNode node : nodes) {
            if (!children.contains(node)) {
                start = node ;
                count ++ ;
            }
        }
        // only has one root node
        if (count > 1) return false ;

        // running bfs to make sure all nodes can be constructed as a binary tree
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(start) ;
        while (!q.isEmpty()) {
            int size = q.size() ;
            for (int i = 0 ; i < size ; ++i) {
                TreeNode cur = q.poll() ;
                if (cur.left != null) {
                    q.add(cur.left) ;
                    children.remove(cur.left) ;
                }
                if (cur.right != null) {
                    q.add(cur.right) ;
                    children.remove(cur.right) ;
                }
            }
        }
        return children.size() == 0 ;
    }
}
