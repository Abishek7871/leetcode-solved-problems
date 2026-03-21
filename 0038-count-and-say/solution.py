class Solution:
    def countAndSay(self, n: int) -> str:
        s = "1"
        for _ in range(1, n):
            s = self.countIdx(s)
        return s

    def countIdx(self, s: str) -> str:
        res = []
        c = s[0]
        count = 1
        
        # Iterate through the string starting from the second character
        for i in range(1, len(s)):
            if s[i] == c:
                count += 1
            else:
                res.append(str(count))
                res.append(c)
                c = s[i]
                count = 1
        
        # Append the final group
        res.append(str(count))
        res.append(c)
        
        return "".join(res)
