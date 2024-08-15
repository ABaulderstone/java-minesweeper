package com.alexbaulderstone.cli;

import java.io.IOException;

import com.alexbaulderstone.gamelogic.board.Board;
import com.alexbaulderstone.gamelogic.board.Cell;
import com.alexbaulderstone.gamelogic.interfaces.IGameOutput;

public class CliOutput implements IGameOutput {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public CliOutput() {

    }

    public void displayLossMessage() {

        System.out.println("BOOM");
        System.out.println("Sorry you hit a bomb. Game over");
    }

    public void drawBoard(Board board) {
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

    private void printHorizontalBorder(int cols, int cellWidth) {
        // two spaces for row label
        System.out.print("  +");
        for (int j = 0; j < cols; j++) {
            System.out.print("-".repeat(cellWidth) + "+");
        }
        System.out.println();
    }

}
