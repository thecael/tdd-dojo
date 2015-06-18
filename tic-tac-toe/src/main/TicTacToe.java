/**
 * @author thecael
 */
public class TicTacToe {
    public enum STATE {BLANK, CROSS, CIRCLE}

    private STATE [][] board = new STATE[3][3];
    private STATE winner;

    public TicTacToe() {
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = STATE.BLANK;
            }
        }
        winner = STATE.BLANK;
    }

    private void checkThreeInARow(int row, STATE state) {
        for (int i = 1; i <= 3; i++) {
            if (!isSet(row, i, state)) {
                return;
            }
        }
        winner = state;
    }

    private void checkThreeInACol(int col, STATE state) {
        for (int i = 1; i <= 3; i++) {
            if (!isSet(i, col, state)) {
                return;
            }
        }
        winner = state;
    }

    private void checkThreeInDiag(STATE state) {
        if (isSet(1, 1, state) && isSet(2, 2, state) && isSet(3, 3, state)) {
            winner = state;
        } else if (isSet(3, 1, state) && isSet(2, 2, state) && isSet(1, 3, state)) {
            winner = state;
        }
    }

    private void checkForWin(int x, int y, STATE state) {
        checkThreeInARow(x, state);
        checkThreeInACol(y, state);
        checkThreeInDiag(state);
    }

    public boolean setCircle(int x, int y) {
        return set(x, y, STATE.CIRCLE);
    }

    public boolean isCircle(int x, int y) {
        return isSet(x, y, STATE.CIRCLE);
    }

    public boolean setCross(int x, int y) {
        return set(x, y, STATE.CROSS);
    }

    public boolean isCross(int x, int y) {
        return isSet(x, y, STATE.CROSS);
    }

    private boolean isSet(int x, int y, STATE state) {
        if (board[x-1][y-1] == state) {
            return true;
        }
        return false;
    }

    private boolean set(int x, int y, STATE state) {
        if (board[x-1][y-1] == STATE.BLANK) {
            board[x - 1][y - 1] = state;
            checkForWin(x, y, state);
            return true;
        }
        return false;
    }

    public STATE getWinner() {
        return winner;
    }
}
