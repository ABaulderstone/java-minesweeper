package com.alexbaulderstone.gamelogic;

import com.alexbaulderstone.cli.CliOutput;

public class Game {
    private IGameInput input;
    private IGameOutput output;
    private IGameParser parser;
    private GameState gameState;
    private Board board;

    enum GameState {
        PLAYING,
        WON,
        LOST
    }

    public Game(IGameInput input, IGameOutput output, IGameParser parser) {
        this.input = input;
        this.output = output;
        this.parser = parser;
    }

    public void run() {
        this.setUp();

        while (gameState == GameState.PLAYING) {
            drawBoard();
            String coordString = input.getValidCoordinate((byte) board.getGrid().length, this::drawBoard);
            byte[] coords = parser.translateCoordinateString(coordString);
            board.revealCell(coords[0], coords[1]);
            CliOutput.clearScreen();
        }
    }

    private void setUp() {
        byte gridSize = input.getGridSize();
        this.board = new Board(gridSize);
        this.gameState = GameState.PLAYING;

    }

    private void drawBoard() {
        output.drawBoard(board);
    }

    private void playerTurn() {
        PlayerAction action = input.getAction();
        switch (action) {
            case FLAG:
                break;
            case REVEAL:
                break;
            case GIVEUP:
                break;
        }
    }
}
