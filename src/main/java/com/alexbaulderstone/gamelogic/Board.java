package com.alexbaulderstone.gamelogic;

import java.util.ArrayList;
import java.util.Random;
import lombok.Getter;

@Getter
public class Board {
    private Cell[][] grid;

    public Board(byte gridSize) {
        grid = constructGrid(gridSize);
        placeBombs(gridSize);

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

    private void placeBombs(byte gridSize) {
        byte bombsPlaced = 0;
        Random random = new Random();
        while (bombsPlaced < gridSize) {
            byte x = (byte) random.nextInt(gridSize);
            byte y = (byte) random.nextInt(gridSize);
            Cell cell = grid[x][y];
            if (cell.isBomb()) {
                continue;
            }
            cell.setBomb(true);
            bombsPlaced++;
        }
    }

}
