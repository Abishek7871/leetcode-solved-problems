class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        ans = []
        
        def findCombinations(i: int, target: int, combinations: list[int]):
            # Base Case: target reached
            if target == 0:
                ans.append(list(combinations))
                return
            
            # Base Case: out of bounds or target exceeded
            if i == len(candidates) or target < 0:
                return

            # Choice 1: Include candidates[i]
            if candidates[i] <= target:
                combinations.append(candidates[i])
                # We stay at index 'i' because we can reuse the same element
                findCombinations(i, target - candidates[i], combinations)
                # Backtrack
                combinations.pop()

            # Choice 2: Skip candidates[i]
            findCombinations(i + 1, target, combinations)

        findCombinations(0, target, [])
        return ans
