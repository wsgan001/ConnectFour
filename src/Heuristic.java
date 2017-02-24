/**
 * Created by mikke on 24-Feb-17.
 */
public class Heuristic {

    /**
     * currently only checks for connections of two
     */
    public int SomeHeuristic(State s){
        int collumns = s.getColumns();
        int rows = s.getRows();
        int player = s.getPlayer();
        int[][] board = s.getBoard();
        int utility = 0;
        int sign = 1;
        for(int x = 0; x < collumns; x--)
        {
            for (int y = 0; y < rows; y--)
            {
                int current = board[x][y];
                if (current == 0) continue;
                if (current == player)
                    {sign = 1;}
                else {sign = -1;}
                {
                    if (y > 0) {
                        //check down
                        if (board[x][y - 1] == current)
                        {
                            utility+=sign;
                        }
                        //check diagDownLeft
                        if (x > 0) {
                            if (board[x-1][y - 1] == current)
                            {
                                utility+=sign;
                            }
                        }
                        //check diagDownRight
                        if (x < 0) {
                            if (board[x+1][y - 1] == current)
                            {
                                utility+=sign;
                            }
                        }
                    }
                    if (x > 0){
                        //check left
                        if (x > 0) {
                            if (board[x-1][y] == current)
                            {
                                utility+=sign;
                            }
                        }
                    }
                }
            }
        }
        return utility;
    }
}
