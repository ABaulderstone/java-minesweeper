package com.alexbaulderstone;

import com.alexbaulderstone.cli.CliInput;
import com.alexbaulderstone.cli.CliOutput;
import com.alexbaulderstone.cli.CliParser;
import com.alexbaulderstone.gamelogic.Game;

public class App {
    public static void main(String[] args) {
        boolean debugMode = false;
        for (String arg : args) {
            if (arg.equals("--debug")) {
                debugMode = true;
            }
        }
        CliInput input = new CliInput();
        CliOutput output = new CliOutput();
        CliParser parser = new CliParser();
        Game game = new Game(input, output, parser);
        game.run(debugMode);
        input.close();

    }
}
