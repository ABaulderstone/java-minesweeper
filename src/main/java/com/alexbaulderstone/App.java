package com.alexbaulderstone;

import com.alexbaulderstone.cli.CliOutput;
import com.alexbaulderstone.gamelogic.Board;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Board testBoard = new Board((byte) 5);
        CliOutput.drawBoard(testBoard);

    }
}
