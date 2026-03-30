class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:

        n = len(nums)
        visited = set()
        res = []

        def backtrack(path,start):

            if tuple(sorted(path)) not in visited:
                res.append(path.copy())
                visited.add((tuple(sorted(path))))

            for i in range(start,n):

                if i > start and nums[i] == nums[i-1]:
                    continue

                path.append(nums[i])
                backtrack(path,i+1)
                path.pop()

        backtrack([],0)

        return res
