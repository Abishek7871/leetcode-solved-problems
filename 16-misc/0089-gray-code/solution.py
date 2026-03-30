class Solution:
    def grayCode(self, n: int) -> list[int]:
        res = [0]
        used = {0}
        size = 2**n

        def backtrack(curr):
            if len(res) == size:
                return True

            for i in range(n):
                new = curr ^ (1 << i)
                if new in used:
                    continue
                used.add(new)

                res.append(new)
                if backtrack(new):
                    return True
                res.pop()
                used.remove(new)

            return False

        backtrack(0)
        return res
