package com.alexbaulderstone;

import com.alexbaulderstone.cli.CliInput;
import com.alexbaulderstone.cli.CliOutput;
import com.alexbaulderstone.cli.CliParser;
import com.alexbaulderstone.gamelogic.Game;

public class App {
    public static void main(String[] args) {
        CliInput input = new CliInput();
        CliOutput output = new CliOutput();
        CliParser parser = new CliParser();
        Game game = new Game(input, output, parser);
        game.run();
        // CliOutput.clearScreen();
        input.close();

    }
}
