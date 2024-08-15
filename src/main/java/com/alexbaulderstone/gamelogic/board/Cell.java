package com.alexbaulderstone.gamelogic.board;

import lombok.Getter;
import lombok.Setter;

public class Cell {

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

    private CellType cellType;

    public Cell(byte xCoord, byte yCoord) {
        this.isRevealed = false;
        this.isFlagged = false;
        this.surroundingBombs = 0;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.cellType = CellType.EMPTY;
    }

    public boolean isBomb() {
        return this.cellType == CellType.BOMB;
    }

    public String showFace() {
        if (isFlagged) {
            return "F";
        }
        if (!isRevealed) {
            return "?";
        }
        if (isBomb()) {
            return "X";
        }
        if (surroundingBombs == 0) {
            return " ";
        }
        return String.format("%s", this.surroundingBombs);
    }

    protected void setBomb() {
        this.cellType = CellType.BOMB;
    }

    protected CellType getCellType() {
        return this.cellType;
    }

    protected void setCellType(CellType newType) {
        this.cellType = newType;
    }

}
