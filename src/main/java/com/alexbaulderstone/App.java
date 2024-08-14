package com.alexbaulderstone;

import com.alexbaulderstone.cli.CliInput;
import com.alexbaulderstone.cli.CliOutput;
import com.alexbaulderstone.gamelogic.Board;

public class App {
    public static void main(String[] args) {
        CliInput tesInput = new CliInput();
        byte gridSize = tesInput.getGridSize();
        Board testBoard = new Board(gridSize);
        CliOutput.drawBoard(testBoard);
        // CliOutput.clearScreen();
        tesInput.close();

    }
}
