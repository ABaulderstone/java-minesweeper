package com.alexbaulderstone.gamelogic;

public class Board {
    private Cell[][] grid;

    public Board(byte gridSize) {
        grid = constructGrid(gridSize);
    }

    private Cell[][] constructGrid(byte gridSize) {
        Cell[][] grid = new Cell[gridSize][gridSize];
        for (byte i = 0; i < gridSize; i++) {
            for (byte j = 0; j < gridSize; j++) {
                grid[i][j] = new Cell();
            }
        }
        return grid;
    }

}
