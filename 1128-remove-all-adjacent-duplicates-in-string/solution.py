class Solution:
    def removeDuplicates(self, s: str) -> str:
        char_stack = []

        for current_char in s:
            if char_stack and char_stack[-1] == current_char:
                char_stack.pop()
            else:
                char_stack.append(current_char)

        return "".join(char_stack)

