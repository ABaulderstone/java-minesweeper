package com.alexbaulderstone.gamelogic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
