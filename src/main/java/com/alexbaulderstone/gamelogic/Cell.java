package com.alexbaulderstone.gamelogic;

import lombok.Getter;
import lombok.Setter;

public class Cell {
    @Getter
    @Setter
    private boolean isBomb;
    private boolean isRevealed;
    private boolean isFlagged;
    @Getter
    @Setter
    private byte surroundingBombs;

    public Cell() {
        this.isBomb = false;
        this.isRevealed = true;
        this.isFlagged = false;
        this.surroundingBombs = 0;
    }

    public String showFace() {
        if (!this.isRevealed) {
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

}
