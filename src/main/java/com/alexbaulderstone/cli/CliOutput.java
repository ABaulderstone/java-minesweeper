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

        System.out.println(colorize("BOOM!", ColorText.RED));
        System.out.println(colorize("Sorry, you hit a bomb. Game over", ColorText.RED));
    }

    public void displayWonMessage() {
        System.out.println(colorize("Congratulations, you cleared the board without hitting a mine", ColorText.GREEN));
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
                System.out.print("| " + colorCellFace(cell.showFace()) + " ");
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

    private String colorize(String input, ColorText color) {
        return color + input + ColorText.RESET;
    }

    private String colorCellFace(String input) {
        switch (input) {
            case "1":
                return colorize(input, ColorText.CYAN);
            case "2":
                return colorize(input, ColorText.GREEN);
            case "3":
                return colorize(input, ColorText.RED);
            case "4":
                return colorize(input, ColorText.BLUE);
            case "5":
                return colorize(input, ColorText.ORANGE);
            case "6":
                return colorize(input, ColorText.TEAL);
            case "7":
                return colorize(input, ColorText.PURPLE);
            case "8":
                return colorize(input, ColorText.YELLOW);
            default:
                return input;

        }
    }

}
