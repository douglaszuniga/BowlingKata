package com.gap.university.dojo;

/**
 * Created with IntelliJ IDEA.
 * User: Shang
 * Date: 8/26/12
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private int[] rolls = new int[21];
    private int currentRoll = 0;
    private static final int totalMaxNumberOfFrames = 10;
    private static final int totalMaxNumberOfBowlsDownByFrame = 10;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
        //currentRoll++;
    }

    public int score() {
        int score = 0;
        int frameTurn = 0;
        for (int frame = 0; frame < totalMaxNumberOfFrames; frame++)
        {
            if  (isStrike(frameTurn))
            {
                score += totalMaxNumberOfBowlsDownByFrame + getStrikeBonus(frameTurn);
                frameTurn++;
            }
            else  if(isSpare(frameTurn))
            {
                score += totalMaxNumberOfBowlsDownByFrame + getSpareBonus(frameTurn);
                frameTurn +=2;
            }
            else
            {
                score += getBowlsDownInFrame(frameTurn);
                frameTurn +=2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameTurn) {
        return rolls[frameTurn] == totalMaxNumberOfBowlsDownByFrame;
    }

    private int getStrikeBonus(int frameTurn) {
        return rolls[frameTurn + 1] + rolls[frameTurn + 2];
    }

    private int getSpareBonus(int frameTurn) {
        return rolls[frameTurn + 2];
    }

    private boolean isSpare(int frameTurn) {
        return rolls[frameTurn] + rolls[frameTurn + 1] == totalMaxNumberOfBowlsDownByFrame;
    }

    private int getBowlsDownInFrame(int frameTurn) {
        return rolls[frameTurn] + rolls[frameTurn + 1];
    }
}
