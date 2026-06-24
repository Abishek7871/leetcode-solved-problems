/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

// Using p1 and p2 as the parent nodes for the subtrees
bool isMirror(struct TreeNode* p1, struct TreeNode* p2)
{
    // If both pointers are NULL, they are mirrors
    if (p1 == NULL && p2 == NULL)
        return true;
        
    // If only one pointer is NULL, they are not mirrors
    if (p1 == NULL || p2 == NULL)
        return false;
        
    // Check values and recursively cross-compare their subtrees
    return (p1->val == p2->val) 
        && isMirror(p1->left, p2->right) 
        && isMirror(p1->right, p2->left);
}

bool isSymmetric(struct TreeNode* root) {
    if (root == NULL) 
        return true;
        
    // Passes the left and right child as the starting parents p1 and p2
    return isMirror(root->left, root->right);
}

