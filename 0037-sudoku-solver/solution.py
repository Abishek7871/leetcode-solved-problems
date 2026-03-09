class Solution:
    def solveSudoku(self, board: list[list[str]]) -> None:
        # bitmasks for rows, columns, and 3x3 boxes
        rows = [0] * 9
        cols = [0] * 9
        boxes = [0] * 9
        empty_cells = []

        # Initialize masks with current board state
        for r in range(9):
            for c in range(9):
                if board[r][c] == '.':
                    empty_cells.append((r, c))
                else:
                    val = int(board[r][c])
                    mask = 1 << val
                    rows[r] |= mask
                    cols[c] |= mask
                    boxes[(r // 3) * 3 + (c // 3)] |= mask

        def backtrack(index):
            if index == len(empty_cells):
                return True
            
            r, c = empty_cells[index]
            box_idx = (r // 3) * 3 + (c // 3)
            
            # Combine masks to find all taken digits in O(1)
            taken = rows[r] | cols[c] | boxes[box_idx]
            
            # Try numbers 1-9
            for num in range(1, 10):
                if not (taken & (1 << num)):
                    # Place number and update bitmasks
                    board[r][c] = str(num)
                    rows[r] |= (1 << num)
                    cols[c] |= (1 << num)
                    boxes[box_idx] |= (1 << num)
                    
                    if backtrack(index + 1):
                        return True
                    
                    # Backtrack: Reset cell and bitmasks
                    rows[r] &= ~(1 << num)
                    cols[c] &= ~(1 << num)
                    boxes[box_idx] &= ~(1 << num)
                    board[r][c] = '.'
            
            return False

        backtrack(0)

