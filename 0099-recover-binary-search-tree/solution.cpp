class Solution {
public:
    TreeNode* first = nullptr; // First misplaced node
    TreeNode* second = nullptr; // Second misplaced node
    TreeNode* prev = nullptr; // Keeps track of the previous node during traversal

    void recoverTree(TreeNode* root) {
        inorder(root);

        // Swap the values of the two nodes
        if (first && second) {
            int temp = first->val;
            first->val = second->val;
            second->val = temp;
        }
    }

    void inorder(TreeNode* node) {
        if (!node) return;

        inorder(node->left); // Visit left subtree

        if (prev && prev->val > node->val) {
            if (!first) {
                first = prev; // Mark the first violation
            }
            second = node; // Mark the second violation
        }
        prev = node; // Update `prev` to current node

        inorder(node->right); // Visit right subtree
    }
};
