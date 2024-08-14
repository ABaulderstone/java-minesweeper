package com.alexbaulderstone;

import com.alexbaulderstone.cli.CliOutput;
import com.alexbaulderstone.gamelogic.Board;

public class App {
    public static void main(String[] args) {
        Board testBoard = new Board((byte) 10);
        CliOutput.drawBoard(testBoard);
        // CliOutput.clearScreen();

    }
}
