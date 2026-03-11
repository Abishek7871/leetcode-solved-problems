class Solution:
    def searchInsert(self, arr: list[int], targ: int) -> int:
        low, high = 0, len(arr) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == targ:
                return mid
            elif targ > arr[mid]:
                low = mid + 1
            else:
                high = mid - 1
                
        return low

