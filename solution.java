/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair{
        int first;
        TreeNode second;
        Pair(int first,TreeNode second){
            this.first=first;
            this.second=second;
        }
    }
    static public Pair dfs(TreeNode root){
        if(root==null)
        return new Pair(0,null);
        Pair left=dfs(root.left);
        Pair right=dfs(root.right);
        if(left.first>right.first){
            return new Pair(left.first+1,left.second);
        }
        if(right.first>left.first){
            return new Pair(right.first+1,right.second);
        }
        return new Pair(left.first+1,root);
        
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).second;
    }
}
