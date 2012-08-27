package com.gap.university.dojo.test;

import com.gap.university.dojo.Game;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Shang
 * Date: 8/26/12
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class BowlingGameTest extends TestCase {
    private Game bowlingGame;

    protected void setUp() throws Exception
    {
        bowlingGame = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i<n;i++)
        {
            bowlingGame.roll(pins);
        }
    }

    private void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }

    public void testGutterGame() throws Exception
    {
        rollMany(20, 0);
        assertEquals(0, bowlingGame.score());
    }

    public void testAllOnes() throws Exception
    {
        rollMany(20, 1);
        assertEquals(20, bowlingGame.score());
    }

    public void testSpareFirstRollOneInEachOther()
    {
        rollSpare();
        rollMany(18, 1);
        assertEquals(29, bowlingGame.score());
    }

    public void testSpareFirstRollThreeSecondRollOneInEachOther()
    {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(18, 0);
        assertEquals(16, bowlingGame.score());
    }

    public void testSpareLastRollOneInEachOther()
    {
        rollMany(18, 1);
        rollSpare();
        bowlingGame.roll(1);
        assertEquals(29, bowlingGame.score());
    }

    public void testStrikeFirstRollThreeInSecondRollFourThirdRollZeroInEachOther()
    {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(16, 0);
        assertEquals(24, bowlingGame.score());
    }

    public void testStrikeLastRollOneEachOther()
    {
        rollMany(18, 1);
        rollStrike();
        rollMany(2,1);
        assertEquals(30, bowlingGame.score());
    }

    public void testRollGoldenGame()
    {
        rollMany(12, 10);
        assertEquals(300, bowlingGame.score());
    }

    public void testNineFirstRollMissSecondRollEachFrame()
    {
        for (int i = 0; i < 10; i++)
        {
            bowlingGame.roll(9);
            bowlingGame.roll(0);
        }
        assertEquals(90, bowlingGame.score());
    }

    public void testFiveFirstRollSpareSecondRollTenTimesFiveLastFrame()
    {
        for (int i = 0; i < 10; i++)
        {
            rollSpare();
        }
        bowlingGame.roll(5);
        assertEquals(150, bowlingGame.score());
    }

    public void testTenPinsNotSpare() {
        bowlingGame.roll(0);
        bowlingGame.roll(7);
        bowlingGame.roll(3);
        bowlingGame.roll(2);
        //rollMany(16, 0);
        assertEquals(12, bowlingGame.score());
    }
}
