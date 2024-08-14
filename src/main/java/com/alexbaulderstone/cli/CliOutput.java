package com.alexbaulderstone.cli;

import com.alexbaulderstone.gamelogic.Board;
import com.alexbaulderstone.gamelogic.Cell;

import lombok.Synchronized;

public class CliOutput {

    public static void drawBoard(Board board) {
        Cell[][] grid = board.getGrid();
        int rows = grid.length;
        int cols = grid[0].length;
        int cellWidth = 3;
        // left pad for row labels
        System.out.print("  ");
        for (int i = 0; i < cols; i++) {
            // two spaces left, one right. this will stack
            System.out.print("  " + i + " ");
        }
        // new line for border
        System.out.println();
        printHorizontalBorder(cols, cellWidth);

        for (int i = 0; i < rows; i++) {

            System.out.print((char) ('A' + i) + " ");
            for (Cell cell : grid[i]) {
                System.out.print("| " + cell.showFace() + " ");
            }
            System.out.println("|");

            if (i < rows - 1) {
                printHorizontalBorder(cols, cellWidth);
            }
        }
        printHorizontalBorder(cols, cellWidth);
    }

    private static void printHorizontalBorder(int cols, int cellWidth) {
        // two spaces for row label
        System.out.print("  +");
        for (int j = 0; j < cols; j++) {
            System.out.print("-".repeat(cellWidth) + "+");
        }
        System.out.println();
    }

}
