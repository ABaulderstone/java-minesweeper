package com.alexbaulderstone.gamelogic;

public class Game {
    private IGameInput input;
    private IGameOutput output;
    private GameState gameState;
    private Board board;

    enum GameState {
        PLAYING,
        WON,
        LOST
    }

    public Game(IGameInput input, IGameOutput output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        this.setUp();

        while (gameState == GameState.PLAYING) {
            drawBoard();
            input.getValidCoordinate((byte) board.getGrid().length, this::drawBoard);

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
