/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        Node node = root;
        // Since it is a perfect binary tree, if node.left exists, node.right also exists
        while (node.left != null) {
            Node nextLineNode = node.left;
            
            // Traverse the current level and connect the children nodes
            while (node.next != null) {
                node.left.next = node.right;
                node.right.next = node.next.left;
                node = node.next;
            }
            
            // Connect the rightmost children of the last node in the current level
            node.left.next = node.right;
            
            // Move down to the start of the next level
            node = nextLineNode;
        }
        
        return root;
    }
}

