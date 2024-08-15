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
        calculateSurroundingBombs();

    }

    public void revealCell(byte xCoord, byte yCoord) {
        Cell foundCell = grid[xCoord][yCoord];
        foundCell.setRevealed(true);
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

    private void calculateSurroundingBombs() {
        for (byte i = 0; i < grid.length; i++) {
            for (byte j = 0; j < grid[i].length; j++) {
                byte surroundingBombCount = 0;
                Cell cell = grid[i][j];
                ArrayList<Cell> neighbouringCells = getNeighbouringCells(i, j);
                for (Cell neighbour : neighbouringCells) {
                    if (neighbour.isBomb()) {
                        surroundingBombCount++;
                    }
                }
                cell.setSurroundingBombs(surroundingBombCount);
            }
        }
    }

    private ArrayList<Cell> getNeighbouringCells(byte xCoord, byte yCoord) {
        ArrayList<Cell> neighbouringCells = new ArrayList<>();
        int[][] neighbourPositions = {
                { -1, -1 }, // Top-left
                { -1, 0 }, // Top
                { -1, 1 }, // Top-right
                { 0, 1 }, // Right
                { 1, 1 }, // Bottom-Right
                { 1, 0 }, // Bottom
                { 1, -1 }, // Bottom-Left
                { 0, -1 } // Left
        };
        for (int[] neighbourCoords : neighbourPositions) {
            int neighbourX = xCoord + neighbourCoords[0];
            int neighbourY = yCoord + neighbourCoords[1];
            if (neighbourX >= 0 && neighbourX < grid.length && neighbourY >= 0 && neighbourY < grid.length) {
                Cell neighbour = grid[neighbourX][neighbourY];
                neighbouringCells.add(neighbour);
            }
        }
        return neighbouringCells;
    }

}
