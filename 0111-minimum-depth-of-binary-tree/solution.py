class Solution(object):
    def minDepth(self, root):
        if root is None: 
            return 0
        
        leftDepth = self.minDepth(root.left)
        rightDepth = self.minDepth(root.right)
        
        # If one child is missing, return the depth of the existing child + 1
        if root.left is None or root.right is None:
            return leftDepth + rightDepth + 1
            
        # If both children exist, return the smaller depth + 1
        return min(leftDepth, rightDepth) + 1

