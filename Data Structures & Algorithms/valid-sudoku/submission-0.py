class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = {}      
        cols = {}     
        squares = {}   
        for i in range(len(board)):            
            for j in range(len(board)):
                c=board[i][j]
                if c==".":
                    continue
                r = rows.setdefault(i, set())
                co = cols.setdefault(j, set())
                sq = squares.setdefault((i//3, j//3), set())
                if c in r or c in co or c in sq:
                    return False
                r.add(c)
                co.add(c)
                sq.add(c)

        return True        


        