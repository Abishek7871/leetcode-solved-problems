/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* insert(TreeNode* root,vector<int> &nums,int l,int r){
        if(l>r)
            return nullptr;
        int mid = l + (r-l)/2;
        int x = nums[mid];
        if(root == nullptr)
            root = new TreeNode(x);
        root->left = insert(root->left,nums,l,mid-1);
        root->right = insert(root->right,nums,mid+1,r);
        return root;
    }
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        int n = nums.size();
        TreeNode* root = nullptr;
        root = insert(root,nums,0,n-1);
        return root;
    }
};
