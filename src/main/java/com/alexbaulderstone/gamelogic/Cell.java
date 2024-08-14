package com.alexbaulderstone.gamelogic;

public class Cell {
    private boolean isBomb;
    private boolean isRevealed;
    private boolean isFlagged;
    private byte surroundingBombs;

    public Cell() {
        this.isBomb = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.surroundingBombs = 0;
    }

    public String showFace() {
        if (this.isRevealed) {
            return String.format("%s", this.surroundingBombs);
        }
        return "?";
    }

}
