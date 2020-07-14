package grokking.treebfs;

import javafx.util.Pair;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();
            if(result.size()<level+1)
            {
                result.add(level, new ArrayList<>());
            }
            result.get(level).add(node.val);

            if(node.left!=null)
                queue.add(new Pair<>(node.left, level+1));
            if(node.right!=null)
                queue.add(new Pair<>(node.right, level+1));

        }



        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
