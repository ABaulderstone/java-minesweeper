package com.alexbaulderstone.cli;

import com.alexbaulderstone.gamelogic.Board;
import com.alexbaulderstone.gamelogic.Cell;

public class CliOutput {
    public static void drawBoard(Board board) {
        for (Cell[] row : board.getGrid()) {
            for (Cell cell : row) {
                System.out.print(" ___");

            }
            System.out.println();
            for (Cell cell : row) {
                System.out.print("| " + cell.showFace() + " ");
            }
            System.out.println("|");
        }
    }

    // for (Cell[] row : board.getGrid()) {
    // for (Cell cell : row) {
    // System.out.print(cell.showFace());
    // }
    // System.out.println();
    // }

}
