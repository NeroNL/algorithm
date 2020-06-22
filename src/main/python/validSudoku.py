class Solution:
    """
    @param board: the board
    @return: whether the Sudoku is valid
    """
    def isValidSudoku(self, board):
        # write your code here
        print(board)
        for b in board:
            print(b)
        l, m, used = 9, 3, set()
        for row in range(l):
            used = set()
            for col in range(l):
                if not self.is_valid(board[row][col],used):
                    return False
        for col in range(l):
            used = set()
            for row in range(l):
                if not self.is_valid(board[row][col], used):
                    return False

        for x in range(m):
            for y in range(m):
                used = set()
                for xi in range(x*m,(x+1)*m):
                    for yi in range(y*m, (y+1)*m):
                        if not self.is_valid(board[xi][yi],used):
                            return False
        return True

    def is_valid(self,c, used):
        if c == '.':
            return True
        if c not in used:
            used.add(c)
            return True
        return False