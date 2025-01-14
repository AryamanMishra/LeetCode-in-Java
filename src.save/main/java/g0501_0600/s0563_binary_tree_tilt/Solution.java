package g0501_0600.s0563_binary_tree_tilt;

// #Easy #Depth_First_Search #Tree #Binary_Tree
// #2022_03_20_Time_0_ms_(100.00%)_Space_45.6_MB_(25.19%)

import com_github_leetcode.TreeNode;

/*
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
public class Solution {
    private int sum = 0;

    private int sumTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ls = sumTilt(root.left);
        int rs = sumTilt(root.right);
        sum += Math.abs(ls - rs);
        return ls + rs + root.val;
    }

    public int findTilt(TreeNode root) {
        sum = 0;
        sumTilt(root);
        return sum;
    }
}
