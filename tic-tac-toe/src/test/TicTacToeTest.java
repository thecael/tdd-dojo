import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author thecael
 */
public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setup() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void setCircle() {
        ticTacToe.setCircle(1,1);
        boolean result = ticTacToe.isCircle(1,1);
        assertTrue(result);
    }

    @Test
    public void setCross() {
        ticTacToe.setCross(1, 1);
        boolean result = ticTacToe.isCross(1, 1);
        assertTrue(result);
    }

    @Test
    public void clearBoard() {
        ticTacToe.clearBoard();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                boolean isCircle = ticTacToe.isCircle(i, j);
                assertFalse(isCircle);
                boolean isCross = ticTacToe.isCross(i, j);
                assertFalse(isCross);
            }
        }
    }

    @Test
    public void winByHorizontalLine() {
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCircle(1, 1);
        ticTacToe.setCircle(1, 2);
        ticTacToe.setCircle(1, 3);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CIRCLE);
        ticTacToe.clearBoard();
        ticTacToe.setCircle(2, 1);
        ticTacToe.setCircle(2, 2);
        ticTacToe.setCircle(2, 3);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CIRCLE);
        ticTacToe.clearBoard();
        ticTacToe.setCircle(3, 1);
        ticTacToe.setCircle(3, 2);
        ticTacToe.setCircle(3, 3);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CIRCLE);
    }

    @Test
    public void winByVerticalLine() {
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCircle(1, 1);
        ticTacToe.setCircle(2, 1);
        ticTacToe.setCircle(3, 1);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CIRCLE);
        ticTacToe.clearBoard();
        ticTacToe.setCircle(1, 2);
        ticTacToe.setCircle(2, 2);
        ticTacToe.setCircle(3, 2);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CIRCLE);
        ticTacToe.clearBoard();
        ticTacToe.setCircle(1, 3);
        ticTacToe.setCircle(2, 3);
        ticTacToe.setCircle(3, 3);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CIRCLE);
    }

    @Test
    public void winByDiagonalLine() {
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCircle(1, 1);
        ticTacToe.setCircle(2, 2);
        ticTacToe.setCircle(3, 3);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CIRCLE);
        ticTacToe.clearBoard();
        ticTacToe.setCircle(3, 1);
        ticTacToe.setCircle(2, 2);
        ticTacToe.setCircle(1, 3);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CIRCLE);
    }

    @Test
    public void setCircleOnCircle() {
        ticTacToe.setCircle(3, 1);
        boolean result = ticTacToe.setCircle(3, 1);
        assertFalse(result);
    }

    @Test
    public void setCircleOnCross() {
        ticTacToe.setCross(3, 1);
        boolean result = ticTacToe.setCircle(3, 1);
        assertFalse(result);
    }

    @Test
    public void playSampleGame() {
        ticTacToe.setCross(1, 1);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCircle(2, 1);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCross(1, 2);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCircle(1, 3);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCross(2, 2);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCircle(3, 1);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.BLANK);
        ticTacToe.setCross(3, 3);
        assertEquals(ticTacToe.getWinner(), TicTacToe.STATE.CROSS);
    }
}
