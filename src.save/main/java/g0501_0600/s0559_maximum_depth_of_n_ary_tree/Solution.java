package g0501_0600.s0559_maximum_depth_of_n_ary_tree;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree
// #2022_03_20_Time_1_ms_(78.18%)_Space_43.9_MB_(56.52%)

import com_github_leetcode.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        children = _neighbors;
    }
};
*/
public class Solution {
    private int max = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.neighbors == null || root.neighbors.isEmpty()) {
            return 1;
        }
        for (Node child : root.neighbors) {
            findDepth(child, 1);
        }
        return max;
    }

    private void findDepth(Node n, int d) {
        if (n.neighbors != null && !n.neighbors.isEmpty()) {
            for (Node no : n.neighbors) {
                findDepth(no, d + 1);
            }
        } else {
            max = Math.max(max, d + 1);
        }
    }
}
