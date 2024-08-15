package com.alexbaulderstone.gamelogic;

import lombok.Getter;
import lombok.Setter;

public class Cell {
    @Getter
    @Setter
    private boolean isBomb;
    @Getter
    @Setter
    private boolean isRevealed;
    private boolean isFlagged;
    @Getter
    @Setter
    private byte surroundingBombs;
    @Getter
    private byte xCoord;
    @Getter
    private byte yCoord;

    public Cell(byte xCoord, byte yCoord) {
        this.isBomb = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.surroundingBombs = 0;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public String showFace() {
        if (isFlagged) {
            return "F";
        }
        if (!isRevealed) {
            return "?";
        }
        if (isBomb) {
            return "X";
        }
        if (surroundingBombs == 0) {
            return " ";
        }
        return String.format("%s", this.surroundingBombs);
    }

    @Override
    public String toString() {
        return "Cell [isBomb=" + isBomb + ", isRevealed=" + isRevealed + ", isFlagged=" + isFlagged
                + ", surroundingBombs=" + surroundingBombs + ", xCoord=" + xCoord + ", yCoord=" + yCoord + "]";
    }

}
